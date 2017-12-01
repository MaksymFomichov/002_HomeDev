package com.gmail.fomichov.m.work;

import com.gmail.fomichov.m.dao.jdbc.JdbcDeveloperDAOImpl;

import java.sql.SQLException;
import java.util.Scanner;

class MenuInConsoleInside {

    // меню работы с дополнительными возможностями редактирования для разработчиков
    static void choiceAddSkillFromDeveloper(Long developerId) throws SQLException {
        System.out.println("\nВыберите id навыка для добавления его к разработчику или 0 для возврата в предыдущее меню");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 0) {
            MenuInConsole.developerExpandedMenuEdit();
        } else {
            new JdbcDeveloperDAOImpl().addSkillToDeveloper(developerId, new Long(choice));
        }
    }

    static void choiceDeleteSkillFromDeveloper(Long developerId) throws SQLException {
        System.out.println("\nВыберите id навыка для удаления его у разработчика или 0 для возврата в предыдущее меню");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 0) {
            MenuInConsole.developerExpandedMenuEdit();
        } else {
            new JdbcDeveloperDAOImpl().deleteSkillToDeveloper(developerId, new Long(choice));
        }
    }
}
