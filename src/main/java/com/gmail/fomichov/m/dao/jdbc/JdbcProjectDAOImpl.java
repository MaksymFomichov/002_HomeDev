package com.gmail.fomichov.m.dao.jdbc;

import com.gmail.fomichov.m.dao.ConnectionUtil;
import com.gmail.fomichov.m.dao.ProjectDAO;
import com.gmail.fomichov.m.model.Project;
import com.gmail.fomichov.m.work.ShowTablesInConsole;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcProjectDAOImpl implements ProjectDAO {

    public Project getById(Long id) throws SQLException {
        String sql = "SELECT * FROM projects WHERE id = " + id;
        Statement statement = ConnectionUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        Project project = new Project();

        while (resultSet.next()) {
            Long projectId = resultSet.getLong("id");
            BigDecimal cost = resultSet.getBigDecimal("cost");
            String nameProject = resultSet.getString("project");

            project.withId(projectId)
                    .withCost(cost)
                    .withProject(nameProject);
        }

        resultSet.close();
        statement.close();

        return project;
    }

    public List<Project> getAll() throws SQLException {
        List<Project> projectList = new ArrayList<Project>();
        String sql = "SELECT * FROM projects ORDER BY id";
        Statement statement = ConnectionUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);


        while (resultSet.next()) {
            Project project = new Project();
            Long projectId = resultSet.getLong("id");
            BigDecimal cost = resultSet.getBigDecimal("cost");
            String nameProject = resultSet.getString("project");

            project.withId(projectId)
                    .withCost(cost)
                    .withProject(nameProject);

            projectList.add(project);
        }

        resultSet.close();
        statement.close();

        return projectList;
    }


    public void update(Project project) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String query = "UPDATE projects SET project='" + project.getProject() + "', cost='" + project.getCost() + "' where id=" + project.getId();
        statement.executeUpdate(query);
        statement.close();
        ShowTablesInConsole.showTableProjects();
    }

    public void delete(Project project) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String deleteQuery = "DELETE FROM projects WHERE id=" + project.getId();
        statement.executeUpdate(deleteQuery);
        statement.close();
        ShowTablesInConsole.showTableProjects();
    }

    public void create(Project project) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String name = project.getProject();
        BigDecimal cost = project.getCost();
        String insertQuery = "INSERT INTO projects(project, cost)" + "VALUES('" + name + "', '" + cost + "')";
        statement.executeUpdate(insertQuery);
        statement.close();
        ShowTablesInConsole.showTableProjects();
    }
}
