/*Вычислить общую ЗП всех Java разработчиков. */

SELECT sum(developers.salary)
FROM developers_skills
  JOIN developers ON developers.id = developers_skills.developers_id
  JOIN skills ON skills.id = developers_skills.skills_id
WHERE skills.skill = "java"

