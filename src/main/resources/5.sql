/*Найти клиента (customer), которая приносит меньше всего прибыли компании (company)
 для каждой из компаний .*/

SELECT
company,
customer,
project,
min(cost)
FROM customers, projects, customers_projects, companies, companies_projects
WHERE customers_projects.projects_id = projects.id AND
customers_projects.customers_id = customers.id AND
companies_projects.projects_id = projects.id AND
companies_projects.companies_id = companies.id
GROUP BY company