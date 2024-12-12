ALTER TABLE wins
    DROP CONSTRAINT wins_pkey,
    ADD COLUMN IF NOT EXISTS win_id SERIAL PRIMARY KEY,
    ADD CONSTRAINT unique_hero_game_win UNIQUE (hero_id, game_id);

ALTER TABLE losses
    DROP CONSTRAINT losses_pkey,
    ADD COLUMN IF NOT EXISTS loss_id SERIAL PRIMARY KEY,
    ADD CONSTRAINT unique_hero_game_loss UNIQUE (hero_id, game_id);

ALTER TABLE draws
    DROP CONSTRAINT draws_pkey,
    ADD COLUMN IF NOT EXISTS draw_id SERIAL PRIMARY KEY,
    ADD CONSTRAINT unique_hero_game_draw UNIQUE (hero_id, game_id);
