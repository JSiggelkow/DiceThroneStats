package jsi.iks.dicethronestats.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import jsi.iks.dicethronestats.dto.CreateGameDTO;
import jsi.iks.dicethronestats.dto.GameDTO;
import jsi.iks.dicethronestats.repositories.GameRepository;
import jsi.iks.dicethronestats.util.Hero;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Sql(scripts = {"/sql_scripts/insert_heroes.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
@Sql(scripts = {"/sql_scripts/truncate_games_losses_wins_draws.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@AutoConfigureEmbeddedDatabase(refresh = AutoConfigureEmbeddedDatabase.RefreshMode.AFTER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class GameControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private GameRepository gameRepository;

	String baseUrl = "http://localhost:8080/game";

	@Test
	public void createTest() throws Exception {
		CreateGameDTO createGameDTO = new CreateGameDTO(Hero.BARBARIAN.getHeroDTO(), Hero.PYROMANCER.getHeroDTO(), LocalDateTime.now());

		mockMvc.perform(post(baseUrl)
						.contentType("application/json")
						.content(objectMapper.writeValueAsString(createGameDTO)))
				.andExpect(status().isCreated());

		assertTrue(gameRepository.findById(1).isPresent());
	}

	@Test
	@Sql(scripts = {"/sql_scripts/insert_dummy_games.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	public void getAllTest() throws Exception {
		String content = mockMvc.perform(get(baseUrl))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();

		List<GameDTO> games = objectMapper.readValue(content, new TypeReference<>() {});

		assertNotNull(games);
		assertEquals(5, games.size());
	}
}
