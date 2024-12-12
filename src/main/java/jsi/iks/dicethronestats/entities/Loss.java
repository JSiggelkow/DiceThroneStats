package jsi.iks.dicethronestats.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "losses")
@Getter
@Setter
@NoArgsConstructor
public class Loss {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lossId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hero_id")
	private Hero hero;

	@OneToOne
	@JoinColumn(name = "game_id")
	private Game game;
}
