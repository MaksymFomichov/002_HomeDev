package com.gmail.fomichov.m.work;

import com.gmail.fomichov.m.dao.*;
import com.gmail.fomichov.m.dao.jdbc.*;
import com.gmail.fomichov.m.model.*;

import java.sql.SQLException;
import java.util.List;

public class ShowTablesInConsole {

    // полные таблицы базы

    // выводим в консоль таблицу Developer
    public static void showTableDevelopers() throws SQLException {
        DeveloperDAO developerDAO = new JdbcDeveloperDAOImpl();
        List<Developer> developerList = developerDAO.getAll();
        System.out.println("\nтаблица - \"developers\"");
        System.out.format("%s%10s%10s", "id", "name", "salary");
        System.out.println("\n----------------------");
        for (Developer value : developerList) {
            System.out.format("%d%10s%10s", value.getId(), value.getName(), value.getSalary());
            System.out.println();
        }
        MenuInConsole.workConsoleMenu("developers");
    }

    // выводим в консоль таблицу Skills
    public static void showTableSkills() throws SQLException {
        SkillDAO skillDAO = new JdbcSkillDAOImpl();
        List<Skill> skillList = skillDAO.getAll();
        System.out.println("\nтаблица - \"skills\"");
        System.out.format("%s%15s", "id", "skill");
        System.out.println("\n-------------------");
        for (Skill value : skillList) {
            System.out.format("%d%15s", value.getId(), value.getSkill());
            System.out.println();
        }
        MenuInConsole.workConsoleMenu("skills");
    }

    // выводим в консоль таблицу Companies
    public static void showTableCompanies() throws SQLException {
        CompanyDAO companyDAO = new JdbcCompanyDAOImpl();
        List<Company> companyList = companyDAO.getAll();
        System.out.println("\nтаблица - \"companies\"");
        System.out.format("%s%10s", "id", "company");
        System.out.println("\n--------------");
        for (Company value : companyList) {
            System.out.format("%d%10s", value.getId(), value.getCompany());
            System.out.println();
        }
        MenuInConsole.workConsoleMenu("companies");
    }

    // выводим в консоль таблицу Customers
    public static void showTableCustomers() throws SQLException {
        CustomerDAO customerDAO = new JdbcCustomerDAOImpl();
        List<Customer> customerList = customerDAO.getAll();
        System.out.println("\nтаблица - \"customers\"");
        System.out.format("%s%15s", "id", "customer");
        System.out.println("\n--------------");
        for (Customer value : customerList) {
            System.out.format("%d%15s", value.getId(), value.getCustomer());
            System.out.println();
        }
        MenuInConsole.workConsoleMenu("customers");
    }

    // выводим в консоль таблицу Projects
    public static void showTableProjects() throws SQLException {
        ProjectDAO projectDAO = new JdbcProjectDAOImpl();
        List<Project> projectList = projectDAO.getAll();
        System.out.println("\nтаблица - \"projects\"");
        System.out.format("%s%10s%15s", "id", "cost", "project");
        System.out.println("\n----------------------------");
        for (Project value : projectList) {
            System.out.format("%d%10s%15s", value.getId(), value.getCost(), value.getProject());
            System.out.println();
        }
        MenuInConsole.workConsoleMenu("projects");
    }

    // таблицы по запросам

    // выводим в консоль таблицу навыков выбранного разработчика
    public static void showTableDevelopersSkills(Developer developer, Boolean deleteSkill) throws SQLException {
        System.out.println("\nнавыки разработчика - " + "\"" + developer.getName() + "\"");
        System.out.format("%s%10s", "id", "skill");
        System.out.println("\n-----------------");
        if (developer.getSkillList().isEmpty()) {
            System.out.println("У разработчика нет навыков");
        } else {
            for (Skill value : developer.getSkillList()) {
                System.out.format("%d%10s", value.getId(), value.getSkill());
                System.out.println();
            }
        }
        if (!deleteSkill) {
            MenuInConsole.developerExpandedMenuEdit();
        } else {
            MenuInConsoleInside.choiceDeleteSkillFromDeveloper(developer.getId());
        }
    }

    // выводим все проекты выбранного разработчика
    static void showTableDevelopersProjects(Developer developer) throws SQLException {
        System.out.println("\nпроекты разработчика - " + "\"" + developer.getName() + "\"");
        System.out.format("%s%10s", "id", "projects");
        System.out.println("\n-----------------");
        if (developer.getProjectList().isEmpty()) {
            System.out.println("У разработчика нет проектов");
        } else {
            for (Project value : developer.getProjectList()) {
                System.out.format("%d%10s", value.getId(), value.getProject());
                System.out.println();
            }
        }
        MenuInConsole.developerExpandedMenuEdit();
    }

    // выводим все проекты выбранной компании
    static void showTableCompanyProjects(Company company) throws SQLException {
        System.out.println("\nпроекты компании - " + "\"" + company.getCompany() + "\"");
        System.out.format("%s%10s", "id", "projects");
        System.out.println("\n-----------------");
        if (company.getProjectList().isEmpty()) {
            System.out.println("У компании нет проектов");
        } else {
            for (Project value : company.getProjectList()) {
                System.out.format("%d%10s", value.getId(), value.getProject());
                System.out.println();
            }
        }
        MenuInConsole.companyExpandedMenuEdit();
    }

    // выводим все проекты выбранного заказчика
    static void showTableCustomerProjects(Customer customer) throws SQLException {
        System.out.println("\nпроекты заказчика - " + "\"" + customer.getCustomer() + "\"");
        System.out.format("%s%10s", "id", "projects");
        System.out.println("\n-----------------");
        if (customer.getProjectList().isEmpty()) {
            System.out.println("У заказчика нет проектов");
        } else {
            for (Project value : customer.getProjectList()) {
                System.out.format("%d%10s", value.getId(), value.getProject());
                System.out.println();
            }
        }
        MenuInConsole.customerExpandedMenuEdit();
    }


    // таблицы с сложными запросами и внутренеей обработкой

    // выводим в консоль таблицу Skills за исключением навыков выбранного разработчика
    static void showTableSkillsButNoChoiceDeveloper(Long developerId) throws SQLException {
        List<Skill> skillList = JdbcDeveloperDAOImpl.getAllSkillButNoChoiceDeveloper(developerId);

        // если ваня не ответ на вопрос то нужно будет убрать отдельный метод для получения листа навыков без разработчика и использовать обычный лсит навыка и сравнивать его с листом
        List<Skill> developerSkillList = new JdbcDeveloperDAOImpl().getById(developerId).getSkillList();

        System.out.println("\nтаблица - \"skills\"");
        System.out.format("%s%15s", "id", "skill");
        System.out.println("\n-------------------");

        // чистим лист навыков от повторов с навыками разработчика
        for (int i = 0; i < skillList.size(); i++) {
            for (int j = 0; j < developerSkillList.size(); j++) {
                if (skillList.get(i).getSkill().equals(developerSkillList.get(j).getSkill())) {
                    skillList.remove(i);
                    break;
                }
            }
        }

        // выводим лист без повторов навыков которые есть у разработчика
        for (Skill value : skillList) {
            System.out.format("%d%15s", value.getId(), value.getSkill());
            System.out.println();
        }

        MenuInConsoleInside.choiceAddSkillFromDeveloper(developerId);
    }
}
