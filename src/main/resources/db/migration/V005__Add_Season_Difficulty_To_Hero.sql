ALTER TABLE hero
ADD COLUMN season INTEGER;

ALTER TABLE hero
ADD COLUMN difficulty INTEGER;

UPDATE hero
SET season = 1 WHERE hero_id <= 8;

UPDATE hero
set season = 2 WHERE hero_id <= 16 AND hero_id > 8;

UPDATE hero
set season = 3 WHERE hero_id <= 24 AND hero_id > 16;

UPDATE hero
set season = 4 WHERE hero_id <= 26 AND hero_id > 24;

UPDATE hero
SET difficulty = CASE
    WHEN hero_id = 1 THEN 1
    WHEN hero_id = 2 THEN 2
    WHEN hero_id = 3 THEN 3
    WHEN hero_id = 4 THEN 5
    WHEN hero_id = 5 THEN 4
    WHEN hero_id = 6 THEN 5
    WHEN hero_id = 7 THEN 2
    WHEN hero_id = 8 THEN 6
    WHEN hero_id = 9 THEN 4
    WHEN hero_id = 10 THEN 6
    WHEN hero_id = 11 THEN 3
    WHEN hero_id = 12 THEN 4
    WHEN hero_id = 13 THEN 2
    WHEN hero_id = 14 THEN 3
    WHEN hero_id = 15 THEN 5
    WHEN hero_id = 16 THEN 5
    WHEN hero_id = 17 THEN 2
    WHEN hero_id = 18 THEN 2
    WHEN hero_id = 19 THEN 4
    WHEN hero_id = 20 THEN 5
    WHEN hero_id = 21 THEN 4
    WHEN hero_id = 22 THEN 4
    WHEN hero_id = 23 THEN 3
    WHEN hero_id = 24 THEN 2
    WHEN hero_id = 25 THEN 4
    WHEN hero_id = 26 THEN 2
    ELSE difficulty
END;
