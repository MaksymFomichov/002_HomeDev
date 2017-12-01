package com.gmail.fomichov.m.work;

import com.gmail.fomichov.m.dao.jdbc.JdbcCompanyDAOImpl;
import com.gmail.fomichov.m.dao.jdbc.JdbcDeveloperDAOImpl;
import com.gmail.fomichov.m.model.Company;
import com.gmail.fomichov.m.model.Developer;

import java.sql.SQLException;
import java.util.Scanner;

class ExpandedShowList {

    void showListSkillsDeveloper() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите id разработчика:");
        Long idDeveloper = scanner.nextLong();
        Developer developer = new JdbcDeveloperDAOImpl().getById(idDeveloper);
        ShowTablesInConsole.showTableDevelopersSkills(developer);
    }

    void showListProjectsDeveloper() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите id разработчика:");
        Long idDeveloper = scanner.nextLong();
        Developer developer = new JdbcDeveloperDAOImpl().getById(idDeveloper);
        ShowTablesInConsole.showTableDevelopersProjects(developer);
    }

    void showListProjectCompany() throws SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите id компании:");
        Long idCompany = scanner.nextLong();
        Company company = new JdbcCompanyDAOImpl().getById(idCompany);
        ShowTablesInConsole.showTableCompanyProjects(company);
    }
}
