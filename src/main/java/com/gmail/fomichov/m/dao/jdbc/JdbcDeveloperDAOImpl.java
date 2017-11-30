package com.gmail.fomichov.m.dao.jdbc;

import com.gmail.fomichov.m.dao.ConnectionUtil;
import com.gmail.fomichov.m.dao.DeveloperDAO;
import com.gmail.fomichov.m.model.Developer;
import com.gmail.fomichov.m.work.ShowTablesInConsole;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcDeveloperDAOImpl implements DeveloperDAO {

    public Developer getById(Long id) throws SQLException {
        String sql = "SELECT * FROM developers WHERE id = " + id;
        Statement statement = ConnectionUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        Developer developer = new Developer();

        while (resultSet.next()) {
            Long developerId = resultSet.getLong("id");
            String name = resultSet.getString("name");
            BigDecimal salary = resultSet.getBigDecimal("salary");

            developer.withId(developerId)
                    .withName(name)
                    .withSalary(salary);
        }

        resultSet.close();
        statement.close();

        return developer;
    }

    public List<Developer> getAll() throws SQLException {
        List<Developer> developerList = new ArrayList<Developer>();
        String sql = "SELECT * FROM developers ORDER BY id";
        Statement statement = ConnectionUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Developer developer = new Developer();
            Long developerId = resultSet.getLong("id");
            String name = resultSet.getString("name");
            BigDecimal salary = resultSet.getBigDecimal("salary");

            developer.withId(developerId)
                    .withName(name)
                    .withSalary(salary);

            developerList.add(developer);
        }

        resultSet.close();
        statement.close();

        return developerList;
    }

    public void update(Developer developer) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String query = "UPDATE developers SET name='" + developer.getName() + "', salary='" + developer.getSalary() + "' where id=" + developer.getId();
        statement.executeUpdate(query);
        statement.close();
        ShowTablesInConsole.showTableDevelopers();
    }

    public void delete(Developer developer) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String deleteQuery = "DELETE FROM developers WHERE id=" + developer.getId();
        statement.executeUpdate(deleteQuery);
        statement.close();
        ShowTablesInConsole.showTableDevelopers();
    }

    public void create(Developer developer) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String name = developer.getName();
        BigDecimal salary = developer.getSalary();
        String insertQuery = "INSERT INTO developers(name, salary)" + "VALUES('" + name + "', '" + salary + "')";
        statement.executeUpdate(insertQuery);
        statement.close();
        ShowTablesInConsole.showTableDevelopers();
    }
}
