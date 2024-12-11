package jsi.iks.dicethronestats.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "hero")
@NoArgsConstructor
@Getter
@Setter
public class Hero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int heroId;

	@Column(name = "name")
	private String name;

	@Column(name = "season")
	private int season;

	@Column(name = "difficulty")
	private int difficulty;

	@ElementCollection
	@CollectionTable(name = "wins", joinColumns = @JoinColumn(name = "hero_id"))
	@Column(name = "game_id")
	private List<Integer> wins;

	@ElementCollection
	@CollectionTable(name = "losses", joinColumns = @JoinColumn(name = "hero_id"))
	@Column(name = "game_id")
	private List<Integer> losses;

	@ElementCollection
	@CollectionTable(name = "draws", joinColumns = @JoinColumn(name = "hero_id"))
	@Column(name = "game_id")
	private List<Integer> draws;

	public int getGames() {
		return wins.size() + losses.size() + draws.size();
	}
}
