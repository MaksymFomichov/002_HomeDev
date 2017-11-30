INSERT INTO companies (company)
  VALUE
  ("asus"),
  ("dell"),
  ("lenovo"),
  ("sony"),
  ("apple");
INSERT INTO customers (customer)
  VALUE
  ("spain"),
  ("france"),
  ("south korea"),
  ("north korea"),
  ("canada");
INSERT INTO developers (name)
  VALUE
  ("gena"),
  ("misha"),
  ("serega"),
  ("sveta"),
  ("denis");
INSERT INTO skills (skill)
  VALUE
  ("c++"),
  ("java"),
  ("c#"),
  ("lisp"),
  ("cotlin"),
  ("sql"),
  ("javascript"),
  ("basic"),
  ("python"),
  ("php");
INSERT INTO projects (project)
  VALUE
  ("кофеварка"),
  ("пылесос"),
  ("мультиварка"),
  ("чайник"),
  ("монитор"),
  ("клавиатура"),
  ("мышка"),
  ("ноутбук"),
  ("сайт"),
  ("программа");
INSERT INTO companies_projects (companies_id, projects_id)
  VALUE
  (1, 1),
  (1, 2),
  (2, 3),
  (2, 4),
  (3, 5),
  (3, 6),
  (4, 7),
  (4, 8),
  (5, 9),
  (5, 10);
INSERT INTO customers_projects (customers_id, projects_id)
  VALUE
  (1, 10),
  (1, 9),
  (2, 8),
  (2, 7),
  (3, 6),
  (3, 5),
  (4, 4),
  (4, 3),
  (5, 2),
  (5, 1);
INSERT INTO developers_projects (developers_id, projects_id)
  VALUE
  (1, 10),
  (1, 9),
  (1, 8),
  (2, 7),
  (3, 6),
  (3, 5),
  (4, 4),
  (4, 5),
  (4, 6),
  (4, 10),
  (4, 3),
  (5, 3),
  (5, 2),
  (5, 1);
INSERT INTO developers_skills (developers_id, skills_id)
  VALUE
  (1, 1),
  (1, 2),
  (1, 5),
  (2, 7),
  (2, 4),
  (2, 8),
  (2, 10),
  (2, 1),
  (2, 3),
  (2, 9),
  (3, 6),
  (3, 5),
  (4, 4),
  (4, 5),
  (4, 6),
  (4, 10),
  (4, 3),
  (5, 3),
  (5, 2),
  (5, 1);


