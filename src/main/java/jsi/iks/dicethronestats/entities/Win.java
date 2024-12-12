package jsi.iks.dicethronestats.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wins")
@Getter
@Setter
@NoArgsConstructor
public class Win {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int winId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hero_id")
	private Hero hero;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "game_id")
	private Game game;
}
