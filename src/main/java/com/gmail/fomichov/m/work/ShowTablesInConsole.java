package com.gmail.fomichov.m.work;

import com.gmail.fomichov.m.dao.*;
import com.gmail.fomichov.m.dao.jdbc.*;
import com.gmail.fomichov.m.model.*;

import java.sql.SQLException;
import java.util.List;

public class ShowTablesInConsole {

    // выводим в консоль таблицу Developer
    public static void showTableDevelopers() throws SQLException {
        DeveloperDAO developerDAO = new JdbcDeveloperDAOImpl();
        List<Developer> developerList = developerDAO.getAll();

        System.out.format("%s%10s%10s", "id", "name", "salary");
        System.out.println("\n----------------------");
        for (Developer value : developerList) {
            System.out.format("%d%10s%10s", value.getId(), value.getName(), value.getSalary());
            System.out.println();
        }

        ShowMenuInConsole.workConsoleMenu("developers");
    }

    // выводим в консоль таблицу Skills
    public static void showTableSkills() throws SQLException {
        SkillDAO skillDAO = new JdbcSkillDAOImpl();
        List<Skill> skillList = skillDAO.getAll();

        System.out.format("%s%15s", "id", "skill");
        System.out.println("\n-------------------");
        for (Skill value : skillList) {
            System.out.format("%d%15s", value.getId(), value.getSkill());
            System.out.println();
        }

        ShowMenuInConsole.workConsoleMenu("skills");
    }

    // выводим в консоль таблицу Companies
    public static void showTableCompanies() throws SQLException {
        CompanyDAO companyDAO = new JdbcCompanyDAOImpl();
        List<Company> companyList = companyDAO.getAll();

        System.out.format("%s%10s", "id", "company");
        System.out.println("\n--------------");
        for (Company value : companyList) {
            System.out.format("%d%10s", value.getId(), value.getCompany());
            System.out.println();
        }

        ShowMenuInConsole.workConsoleMenu("companies");
    }

    // выводим в консоль таблицу Customers
    public static void showTableCustomers() throws SQLException {
        CustomerDAO customerDAO = new JdbcCustomerDAOImpl();
        List<Customer> customerList = customerDAO.getAll();

        System.out.format("%s%15s", "id", "customer");
        System.out.println("\n--------------");
        for (Customer value : customerList) {
            System.out.format("%d%15s", value.getId(), value.getCustomer());
            System.out.println();
        }

        ShowMenuInConsole.workConsoleMenu("customers");
    }

    // выводим в консоль таблицу Projects
    public static void showTableProjects() throws SQLException {
        ProjectDAO projectDAO = new JdbcProjectDAOImpl();
        List<Project> projectList = projectDAO.getAll();

        System.out.format("%s%10s%15s", "id", "cost", "project");
        System.out.println("\n----------------------------");
        for (Project value : projectList) {
            System.out.format("%d%10s%15s", value.getId(), value.getCost(), value.getProject());
            System.out.println();
        }

        ShowMenuInConsole.workConsoleMenu("projects");
    }
}
