package com.gmail.fomichov.m.work;

import com.gmail.fomichov.m.dao.jdbc.JdbcCompanyDAOImpl;
import com.gmail.fomichov.m.dao.jdbc.JdbcCustomerDAOImpl;
import com.gmail.fomichov.m.dao.jdbc.JdbcDeveloperDAOImpl;
import com.gmail.fomichov.m.model.Company;
import com.gmail.fomichov.m.model.Customer;
import com.gmail.fomichov.m.model.Developer;

import java.sql.SQLException;
import java.util.Scanner;

class ExpandedShowList {

    // выбираем id разработчика для которого будет показываться определенный список навыков
    void choiceDeveloperFromShowListSkills(Boolean addSkill, Boolean deleteSkill) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите id разработчика:");
        Long idDeveloper = scanner.nextLong();
        Developer developer = new JdbcDeveloperDAOImpl().getById(idDeveloper);
        if (!addSkill) {
            ShowTablesInConsole.showTableDevelopersSkills(developer, deleteSkill);
        } else {
            ShowTablesInConsole.showTableSkillsButNoChoiceDeveloper(idDeveloper);
        }
    }

    // выбираем id разработчика для которого будет показываться определенный список проектов
    void choiceDeveloperFromShowListProjects() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите id разработчика:");
        Long idDeveloper = scanner.nextLong();
        Developer developer = new JdbcDeveloperDAOImpl().getById(idDeveloper);
        ShowTablesInConsole.showTableDevelopersProjects(developer);
    }

    // выбираем id компании для которой будут показаны проекты
    void choiceCompanyFromShowListProjects() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите id компании:");
        Long idCompany = scanner.nextLong();
        Company company = new JdbcCompanyDAOImpl().getById(idCompany);
        ShowTablesInConsole.showTableCompanyProjects(company);
    }

    // выбираем id заказчика для которой будут показаны проекты
    void choiceCustomerFromShowListProjects() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите id заказчика:");
        Long idCustomer = scanner.nextLong();
        Customer customer = new JdbcCustomerDAOImpl().getById(idCustomer);
        ShowTablesInConsole.showTableCustomerProjects(customer);
    }
}
