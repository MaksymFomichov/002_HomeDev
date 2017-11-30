package com.gmail.fomichov.m.work;

import com.gmail.fomichov.m.dao.jdbc.*;
import com.gmail.fomichov.m.model.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

class UpdateDataInTable {
    void updateDeveloper() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id разработчика для обновления данных:");
        long choice = scanner.nextLong();
        scanner.nextLine();
        Developer developer = new JdbcDeveloperDAOImpl().getById(choice);
        System.out.println("Введите новое имя разработчика, текущее имя " + developer.getName());
        String name = scanner.nextLine();
        System.out.println("Введите новую зарплату разработчика, текущая зарплата " + developer.getSalary());
        BigDecimal salary = scanner.nextBigDecimal();
        developer.withName(name)
                .withSalary(salary);
        new JdbcDeveloperDAOImpl().update(developer);
    }

    void updateCompany() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id компании для обновления данных:");
        long choice = scanner.nextLong();
        scanner.nextLine();
        Company company = new JdbcCompanyDAOImpl().getById(choice);
        System.out.println("Введите новое название компании, текущее имя " + company.getCompany());
        String companyName = scanner.nextLine();
        company.withCompany(companyName);
        new JdbcCompanyDAOImpl().update(company);
    }

    void updateCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id заказчика для обновления данных:");
        long choice = scanner.nextLong();
        scanner.nextLine();
        Customer customer = new JdbcCustomerDAOImpl().getById(choice);
        System.out.println("Введите новое имя заказчика, текущее имя " + customer.getCustomer());
        String customerName = scanner.nextLine();
        customer.withCustomer(customerName);
        new JdbcCustomerDAOImpl().update(customer);
    }

    void updateProject() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id проекта для обновления данных:");
        long choice = scanner.nextLong();
        scanner.nextLine();
        Project project = new JdbcProjectDAOImpl().getById(choice);
        System.out.println("Введите новое имя проекта, текущее имя " + project.getProject());
        String name = scanner.nextLine();
        System.out.println("Введите новую стоимость проекта, текущая стоимость " + project.getCost());
        BigDecimal cost = scanner.nextBigDecimal();
        project.withProject(name)
                .withCost(cost);
        new JdbcProjectDAOImpl().update(project);
    }

    void updateSkill() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id навыка для обновления данных:");
        long choice = scanner.nextLong();
        scanner.nextLine();
        Skill skill = new JdbcSkillDAOImpl().getById(choice);
        System.out.println("Введите новый навык, текущий навык " + skill.getSkill());
        String skillName = scanner.nextLine();
        skill.withSkill(skillName);
        new JdbcSkillDAOImpl().update(skill);
    }
}
