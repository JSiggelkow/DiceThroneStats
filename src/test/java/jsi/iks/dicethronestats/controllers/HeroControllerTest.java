package jsi.iks.dicethronestats.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import jsi.iks.dicethronestats.dto.HeroDTO;
import jsi.iks.dicethronestats.exceptions.ErrorObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Sql(scripts = {"/sql_scripts/insert_heroes.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
@Sql(scripts = {"/sql_scripts/truncate_games_losses_wins_draws.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@AutoConfigureEmbeddedDatabase(refresh = AutoConfigureEmbeddedDatabase.RefreshMode.AFTER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class HeroControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	String baseUrl = "http://localhost:8080/hero";

	@Test
	public void getAllTest() throws Exception {

		String content = mockMvc.perform(get(baseUrl))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		List<HeroDTO> heroes = objectMapper.readValue(content, new TypeReference<>() {
		});

		assertNotNull(heroes);
		assertEquals(26, heroes.size());
	}

	@Test
	public void getByIdTest() throws Exception {
		String content = mockMvc.perform(get(baseUrl + "/1"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		HeroDTO heroDTO = objectMapper.readValue(content, new TypeReference<>() {
		});

		assertNotNull(heroDTO);
		assertEquals(1, heroDTO.heroId());
		assertEquals("Barbarian", heroDTO.name());
	}

	@Test
	public void getByIdFailTest() throws Exception {
		String content = mockMvc.perform(get(baseUrl + "/30"))
				.andExpect(status().isNotFound())
				.andReturn().getResponse().getContentAsString();

		ErrorObject errorObject = objectMapper.readValue(content, new TypeReference<>() {
		});

		assertNotNull(errorObject);
		assertEquals(404, errorObject.status());
		assertEquals("Hero was not found!", errorObject.message());
	}

}
