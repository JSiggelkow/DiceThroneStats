package jsi.iks.dicethronestats.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "game")
@NoArgsConstructor
@Getter
@Setter
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gameId;

	@Column(name = "hero_one_id")
	private int heroOne;

	@Column(name = "hero_two_id")
	private int heroTwo;

	@Column(name = "date_time")
	private LocalDateTime dateTime;
}
