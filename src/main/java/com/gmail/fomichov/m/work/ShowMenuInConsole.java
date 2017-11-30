package com.gmail.fomichov.m.work;

import java.sql.SQLException;
import java.util.Scanner;

public class ShowMenuInConsole {

    // стартовое меню
    public static void startConsoleMenu() throws SQLException {
        String[] listTable = {"developers", "skills", "companies", "customers", "projects"};
        System.out.println("\nВведите номер таблицы для работы с ней или 0 для выхода");
        for (int i = 0; i < listTable.length; i++) {
            System.out.println((i + 1) + " - " + listTable[i]);
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                new ShowTablesInConsole().showTableDevelopers();
                break;
            case 2:
                new ShowTablesInConsole().showTableSkills();
                break;
            case 3:
                new ShowTablesInConsole().showTableCompanies();
                break;
            case 4:
                new ShowTablesInConsole().showTableCustomers();
                break;
            case 5:
                new ShowTablesInConsole().showTableProjects();
                break;
            case 0:
                System.exit(0);
        }
    }

    // меню работы с таблицей
    static void workConsoleMenu(String nameTable) throws SQLException {
        String[] listCommand = {"создать", "изменить", "удалить"};
        System.out.println("\nВыберите, что вы хотите сделать с данными или 0 для возрата в предыдущее меню");
        for (int i = 0; i < listCommand.length; i++) {
            System.out.println((i + 1) + " - " + listCommand[i]);
        }

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                if(nameTable.equals("developers")){
                    new CreateDataInTable().createDeveloper();
                } else if (nameTable.equals("companies")){
                    new CreateDataInTable().createCompany();
                } else if (nameTable.equals("customers")){
                    new CreateDataInTable().createCustomer();
                } else if (nameTable.equals("projects")){
                    new CreateDataInTable().createProject();
                } else if (nameTable.equals("skills")){
                    new CreateDataInTable().createSkill();
                }
                break;
            case 2:
                if(nameTable.equals("developers")){
                    new UpdateDataInTable().updateDeveloper();
                } else if (nameTable.equals("companies")){
                    new UpdateDataInTable().updateCompany();
                } else if (nameTable.equals("customers")){
                    new UpdateDataInTable().updateCustomer();
                } else if (nameTable.equals("projects")){
                    new UpdateDataInTable().updateProject();
                } else if (nameTable.equals("skills")){
                    new UpdateDataInTable().updateSkill();
                }
                break;
            case 3:
                if(nameTable.equals("developers")){
                    new DeleteDataInTable().deleteDeveloper();
                } else if (nameTable.equals("companies")){
                    new DeleteDataInTable().deleteCompany();
                } else if (nameTable.equals("customers")){
                    new DeleteDataInTable().deleteCustomer();
                } else if (nameTable.equals("projects")){
                    new DeleteDataInTable().deleteProject();
                } else if (nameTable.equals("skills")){
                    new DeleteDataInTable().deleteSkill();
                }
                break;
            case 0:
                startConsoleMenu();
        }
    }
}
