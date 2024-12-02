CREATE TABLE IF NOT EXISTS game (
    game_id SERIAL PRIMARY KEY,
    hero_one_id INTEGER REFERENCES hero(hero_id),
    hero_two_id INTEGER REFERENCES hero(hero_id),
    date_time timestamp
)