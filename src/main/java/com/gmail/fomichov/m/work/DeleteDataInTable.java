package com.gmail.fomichov.m.work;

import com.gmail.fomichov.m.dao.jdbc.*;
import com.gmail.fomichov.m.model.*;

import java.sql.SQLException;
import java.util.Scanner;

class DeleteDataInTable {
    void deleteDeveloper() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id разработчика для удаления:");
        long choice = scanner.nextLong();
        Developer developer = new JdbcDeveloperDAOImpl().getById(choice);
        new JdbcDeveloperDAOImpl().delete(developer);
    }

    void deleteCompany() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id компании для удаления:");
        long choice = scanner.nextLong();
        Company company = new JdbcCompanyDAOImpl().getById(choice);
        new JdbcCompanyDAOImpl().delete(company);
    }

    void deleteCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id клиента для удаления:");
        long choice = scanner.nextLong();
        Customer customer = new JdbcCustomerDAOImpl().getById(choice);
        new JdbcCustomerDAOImpl().delete(customer);
    }

    void deleteProject() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id проекта для удаления:");
        long choice = scanner.nextLong();
        Project project = new JdbcProjectDAOImpl().getById(choice);
        new JdbcProjectDAOImpl().delete(project);
    }

    void deleteSkill() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id навыка для удаления:");
        long choice = scanner.nextLong();
        Skill skill = new JdbcSkillDAOImpl().getById(choice);
        new JdbcSkillDAOImpl().delete(skill);
    }
}
