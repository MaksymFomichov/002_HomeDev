/*Вычислить, среднюю ЗП программистов в проекте, который приносит наименьшую прибыль.*/

SELECT sum(developers.salary) / count(developers.salary)
FROM developers, developers_projects, projects
WHERE developers_projects.developers_id = developers.id AND
      (developers_projects.projects_id = projects.id AND
       (projects.id, projects.cost) IN (
         SELECT
           projects.id,
           min(projects.cost)
         FROM projects))