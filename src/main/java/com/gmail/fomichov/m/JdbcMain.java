package com.gmail.fomichov.m;

import com.gmail.fomichov.m.work.Menu;

import java.sql.SQLException;

public class JdbcMain {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Menu.startConsoleMenu();
    }
}
