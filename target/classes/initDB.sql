CREATE TABLE developers (
  id   BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE skills (
  id    BIGINT AUTO_INCREMENT PRIMARY KEY,
  skill VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE projects (
  id      BIGINT AUTO_INCREMENT PRIMARY KEY,
  project VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE companies (
  id      BIGINT AUTO_INCREMENT PRIMARY KEY,
  company VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE customers (
  id       BIGINT AUTO_INCREMENT PRIMARY KEY,
  customer VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE `developers_skills` (
  `developers_id` BIGINT,
  `skills_id`     BIGINT,
  PRIMARY KEY (`developers_id`, `skills_id`),
  CONSTRAINT fk_id_developer FOREIGN KEY (developers_id) REFERENCES developers (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_id_skill FOREIGN KEY (skills_id) REFERENCES skills (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `developers_projects` (
  `developers_id` BIGINT,
  `projects_id`   BIGINT,
  PRIMARY KEY (`developers_id`, `projects_id`),
  CONSTRAINT fk_id_developer_project FOREIGN KEY (developers_id) REFERENCES developers(id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_id_project FOREIGN KEY (projects_id) REFERENCES projects(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `companies_projects` (
  `companies_id` BIGINT,
  `projects_id`  BIGINT,
  PRIMARY KEY (`companies_id`, `projects_id`),
  CONSTRAINT fk_id_company FOREIGN KEY (companies_id) REFERENCES companies(id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_id_project_company FOREIGN KEY (projects_id) REFERENCES projects(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `customers_projects` (
  `customers_id` BIGINT,
  `projects_id`  BIGINT,
  PRIMARY KEY (`customers_id`, `projects_id`),
  CONSTRAINT fk_id_customer FOREIGN KEY (customers_id) REFERENCES customers(id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_id_project_customer FOREIGN KEY (projects_id) REFERENCES projects(id) ON DELETE CASCADE ON UPDATE CASCADE
);