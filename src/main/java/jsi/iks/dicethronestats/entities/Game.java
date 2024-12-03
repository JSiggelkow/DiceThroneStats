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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hero_one_id")
	private Hero heroOne;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hero_two_id")
	private Hero heroTwo;

	@Column(name = "date_time")
	private LocalDateTime dateTime;
}
