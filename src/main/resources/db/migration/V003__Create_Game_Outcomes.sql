CREATE TABLE IF NOT EXISTS wins
(
    hero_id INTEGER REFERENCES hero (hero_id),
    game_id INTEGER REFERENCES game (game_id),
    PRIMARY KEY (hero_id, game_id)
);

CREATE TABLE IF NOT EXISTS losses
(
    hero_id INTEGER REFERENCES hero (hero_id),
    game_id INTEGER REFERENCES game (game_id),
    PRIMARY KEY (hero_id, game_id)
);

CREATE TABLE IF NOT EXISTS draws
(
    hero_id INTEGER REFERENCES hero (hero_id),
    game_id INTEGER REFERENCES game (game_id),
    PRIMARY KEY (hero_id, game_id)
)