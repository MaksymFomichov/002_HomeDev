package com.gmail.fomichov.m.work;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuInConsole {

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

    // меню работы с таблицами
    static void workConsoleMenu(String nameTable) throws SQLException {
        System.out.println("\nВыберите, что вы хотите сделать с данными или 0 для возрата в предыдущее меню");
        System.out.println("1 - создать\n2 - изменить\n3 - удалить");
        if (nameTable.equals("developers") || nameTable.equals("companies") || nameTable.equals("customers")) {
            System.out.println("4 - расширенное редактирование");
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                if (nameTable.equals("developers")) {
                    new CreateDataInTable().createDeveloper();
                } else if (nameTable.equals("companies")) {
                    new CreateDataInTable().createCompany();
                } else if (nameTable.equals("customers")) {
                    new CreateDataInTable().createCustomer();
                } else if (nameTable.equals("projects")) {
                    new CreateDataInTable().createProject();
                } else if (nameTable.equals("skills")) {
                    new CreateDataInTable().createSkill();
                }
                break;
            case 2:
                if (nameTable.equals("developers")) {
                    new UpdateDataInTable().updateDeveloper();
                } else if (nameTable.equals("companies")) {
                    new UpdateDataInTable().updateCompany();
                } else if (nameTable.equals("customers")) {
                    new UpdateDataInTable().updateCustomer();
                } else if (nameTable.equals("projects")) {
                    new UpdateDataInTable().updateProject();
                } else if (nameTable.equals("skills")) {
                    new UpdateDataInTable().updateSkill();
                }
                break;
            case 3:
                if (nameTable.equals("developers")) {
                    new DeleteDataInTable().deleteDeveloper();
                } else if (nameTable.equals("companies")) {
                    new DeleteDataInTable().deleteCompany();
                } else if (nameTable.equals("customers")) {
                    new DeleteDataInTable().deleteCustomer();
                } else if (nameTable.equals("projects")) {
                    new DeleteDataInTable().deleteProject();
                } else if (nameTable.equals("skills")) {
                    new DeleteDataInTable().deleteSkill();
                }
                break;
            case 4:
                if (nameTable.equals("developers")) {
                    developerExpandedMenuEdit();
                } else if (nameTable.equals("companies")) {
                    companyExpandedMenuEdit();
                } else if (nameTable.equals("customers")) {
                    customerExpandedMenuEdit();
                }
                break;
            case 0:
                startConsoleMenu();
        }
    }

    // меню работы с дополнительными возможностями редактирования для разработчиков
    static void developerExpandedMenuEdit() throws SQLException {
        System.out.println("\nВыберите, что вы хотите сделать или 0 для возрата в предыдущее меню");
        System.out.println("1 - просмотр навыков разрабочика\n2 - добавление навыка разработчику\n3 - удаления навыка у разработчика\n4 - просмотр проектов разработчика\n5 - добавления проекта разработчику\n6 - удаление проекта у разработчика");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                new ExpandedShowList().choiceDeveloperFromShowListSkills(false, false);
                break;
            case 2:
                new ExpandedShowList().choiceDeveloperFromShowListSkills(true, false);
                break;
            case 3:
                new ExpandedShowList().choiceDeveloperFromShowListSkills(false, true);
                break;
            case 4:
                new ExpandedShowList().choiceDeveloperFromShowListProjects();
                break;
            case 5:

                break;
            case 6:

                break;

            case 0:
                new ShowTablesInConsole().showTableDevelopers();
        }
    }

    // меню работы с дополнительными возможностями редактирования для компании
    static void companyExpandedMenuEdit() throws SQLException {
        System.out.println("\nВыберите, что вы хотите сделать или 0 для возрата в предыдущее меню");
        System.out.println("1 - просмотр проектов компании\n2 - добавление проекта компании\n3 - удаления проекта компании");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                new ExpandedShowList().choiceCompanyFromShowListProjects();
                break;
            case 2:
                new ExpandedAddData().addProjectToCompany();
                break;
            case 3:

                break;

            case 0:
                new ShowTablesInConsole().showTableCompanies();
        }
    }

    // меню работы с дополнительными возможностями редактирования для заказчика
    static void customerExpandedMenuEdit() throws SQLException {
        System.out.println("\nВыберите, что вы хотите сделать или 0 для возрата в предыдущее меню");
        System.out.println("1 - просмотр проектов заказчика\n2 - добавление проекта заказчику\n3 - удаления проекта у заказчика");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                new ExpandedShowList().choiceCustomerFromShowListProjects();
                break;
            case 2:
                new ExpandedAddData().addProjectToCustomer();
                break;
            case 3:

                break;

            case 0:
                new ShowTablesInConsole().showTableCustomers();
        }
    }
}
