/*Добавить поле (cost - стоимость) в таблицу Projects .*/

ALTER TABLE projects
  ADD cost DECIMAL NOT NULL;

UPDATE projects
SET cost = 10000
WHERE id = 1;
UPDATE projects
SET cost = 20000
WHERE id = 2;
UPDATE projects
SET cost = 30000
WHERE id = 3;
UPDATE projects
SET cost = 40000
WHERE id = 4;
UPDATE projects
SET cost = 50000
WHERE id = 5;
UPDATE projects
SET cost = 60000
WHERE id = 6;
UPDATE projects
SET cost = 70000
WHERE id = 7;
UPDATE projects
SET cost = 80000
WHERE id = 8;
UPDATE projects
SET cost = 90000
WHERE id = 9;
UPDATE projects
SET cost = 100000
WHERE id = 10;