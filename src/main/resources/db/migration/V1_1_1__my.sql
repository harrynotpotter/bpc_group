CREATE TABLE lord
(
    id   INTEGER UNIQUE PRIMARY KEY NOT NULL,
    age  INTEGER,
    name VARCHAR(255)
);

CREATE TABLE planet
(
    id   INTEGER PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(255),
    lord_id INTEGER,

    CONSTRAINT fk_lord
        FOREIGN KEY (lord_id)
            REFERENCES lord (id)
);


INSERT INTO lord (id, age, name)
VALUES (1, 10000, 'Владыка'),
       (2, 20000, 'Господин'),
       (3, 30000, 'Царь'),
       (4, 40000, 'Бог'),
       (5, 50000, 'Ра'),
       (6, 60000, 'Зевс'),
       (7, 70000, 'Нептун'),
       (8, 80000, 'Властелин8'),
       (9, 90000, 'Властелин9'),
       (10, 100000, 'Властелин10'),
       (11, 110000, 'Властелин11'),
       (12, 120000, 'Властелин12');



INSERT INTO planet (id, name, lord_id)
VALUES (1, 'Марс', 1),
       (2, 'Земля', 2),
       (3, 'Нептун', 3),
       (4, 'Сатурн', 4),
       (5, 'Юпитер', 1),
       (6, 'АБВ', 1);



