package com.gmail.fomichov.m.work;

import com.gmail.fomichov.m.dao.jdbc.*;
import com.gmail.fomichov.m.model.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

class MenuCreateDataInTable {

    void createDeveloper() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Developer developer = new Developer();
        System.out.println("Введите имя разработчика:");
        String name = scanner.nextLine();
        System.out.println("Введите зарплату разработчика:");
        BigDecimal salary = scanner.nextBigDecimal();
        developer.withName(name)
                .withSalary(salary);
        new JdbcDeveloperDAOImpl().create(developer);
    }

    void createCompany() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Company company = new Company();
        System.out.println("Введите имя компании:");
        String name = scanner.nextLine();
        company.withCompany(name);
        new JdbcCompanyDAOImpl().create(company);
    }

    void createCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.println("Введите имя клиента:");
        String name = scanner.nextLine();
        customer.withCustomer(name);
        new JdbcCustomerDAOImpl().create(customer);
    }

    void createProject() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Project project = new Project();
        System.out.println("Введите название проекта:");
        String name = scanner.nextLine();
        System.out.println("Введите стоимость проекта:");
        BigDecimal cost = scanner.nextBigDecimal();
        project.withProject(name)
                .withCost(cost);
        new JdbcProjectDAOImpl().create(project);
    }

    void createSkill() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Skill skill = new Skill();
        System.out.println("Введите навык:");
        String nameSkill = scanner.nextLine();
        skill.withSkill(nameSkill);
        new JdbcSkillDAOImpl().create(skill);
    }
}
