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

	@OneToMany(mappedBy = "hero")
	private List<Win> wins;

	@OneToMany(mappedBy = "hero")
	private List<Loss> losses;

	@OneToMany(mappedBy = "hero")
	private List<Draw> draws;

	public int getGames() {
		return wins.size() + losses.size() + draws.size();
	}
}
