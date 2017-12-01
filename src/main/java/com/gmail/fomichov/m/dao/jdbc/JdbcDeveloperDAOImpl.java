package com.gmail.fomichov.m.dao.jdbc;

import com.gmail.fomichov.m.dao.ConnectionUtil;
import com.gmail.fomichov.m.dao.DeveloperDAO;
import com.gmail.fomichov.m.model.Developer;
import com.gmail.fomichov.m.model.Project;
import com.gmail.fomichov.m.model.Skill;
import com.gmail.fomichov.m.work.ShowTablesInConsole;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcDeveloperDAOImpl implements DeveloperDAO {

    public Developer getById(Long id) throws SQLException {
        String query = "SELECT * FROM developers WHERE id = " + id;
        Statement statement = ConnectionUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        Developer developer = new Developer();

        while (resultSet.next()) {
            Long developerId = resultSet.getLong("id");
            String name = resultSet.getString("name");
            BigDecimal salary = resultSet.getBigDecimal("salary");

            developer.withId(developerId)
                    .withName(name)
                    .withSalary(salary)
                    .withListProject(getListProject(developerId))
                    .withListSkill(getListSkill(developerId));
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
                    .withSalary(salary)
                    .withListProject(getListProject(developerId))
                    .withListSkill(getListSkill(developerId));

            developerList.add(developer);
        }

        resultSet.close();
        statement.close();

        return developerList;
    }

    // редактируем имя разработчика
    public void update(Developer developer) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String query = "UPDATE developers SET name='" + developer.getName() + "', salary='" + developer.getSalary() + "' where id=" + developer.getId();
        statement.executeUpdate(query);
        statement.close();
        ShowTablesInConsole.showTableDevelopers();
    }

    // удаляем разработчика
    public void delete(Developer developer) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String deleteQuery = "DELETE FROM developers WHERE id=" + developer.getId();
        statement.executeUpdate(deleteQuery);
        statement.close();
        ShowTablesInConsole.showTableDevelopers();
    }

    // создаем разработчика
    public void create(Developer developer) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String name = developer.getName();
        BigDecimal salary = developer.getSalary();
        String insertQuery = "INSERT INTO developers(name, salary)" + "VALUES('" + name + "', '" + salary + "')";
        statement.executeUpdate(insertQuery);
        statement.close();
        ShowTablesInConsole.showTableDevelopers();
    }

    // получаем навыки разрабочика
    private List<Skill> getListSkill(Long developerId) throws SQLException {
        List<Skill> listSkill = new ArrayList<Skill>();
        String query = "SELECT * FROM developers_skills WHERE developers_id = " + developerId;
        Statement statement = ConnectionUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            Skill skill = new Skill();
            Long skillId = resultSet.getLong("skills_id");
            String skillName = new JdbcSkillDAOImpl().getById(skillId).getSkill();

            skill.withId(skillId)
                    .withSkill(skillName);

            listSkill.add(skill);
        }
        resultSet.close();
        statement.close();
        return listSkill;
    }

    // получаем список навыков без навыков выбранного разарботчика (правда не все так гладко по сути выводит навыки оставшихся разработчиков но без повторов)
    public static List<Skill> getAllSkillButNoChoiceDeveloper(Long developerId) throws SQLException {
        List<Skill> listSkill = new ArrayList<Skill>();
        String query = "SELECT DISTINCT skills_id FROM developers_skills WHERE developers_id <> " + developerId;
        Statement statement = ConnectionUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            Skill skill = new Skill();
            Long skillId = resultSet.getLong("skills_id");
            String skillName = new JdbcSkillDAOImpl().getById(skillId).getSkill();

            skill.withId(skillId)
                    .withSkill(skillName);

            listSkill.add(skill);
        }
        resultSet.close();
        statement.close();
        return listSkill;
    }

    // добавляем разработчику навык
    public void addSkillToDeveloper(Long developerId, Long skillId) throws SQLException {
        String query = "INSERT INTO developers_skills (developers_id, skills_id)" + "VALUES ('" + developerId + "', '" + skillId + "')";
        //String insertQuery = "INSERT INTO developers(name, salary)" + "VALUES('" + name + "', '" + salary + "')";
        Statement statement = ConnectionUtil.getConnection().createStatement();
        statement.executeUpdate(query);
        statement.close();
        ShowTablesInConsole.showTableDevelopersSkills(new JdbcDeveloperDAOImpl().getById(developerId), false);
    }

    // удаляем разработчику навык
    public void deleteSkillToDeveloper(Long developerId, Long skillId) throws SQLException {
        String query = "DELETE FROM developers_skills WHERE skills_id=" + skillId + " AND developers_id=" + developerId;
        Statement statement = ConnectionUtil.getConnection().createStatement();
        statement.executeUpdate(query);
        statement.close();
        ShowTablesInConsole.showTableDevelopersSkills(new JdbcDeveloperDAOImpl().getById(developerId), false);
    }

    // получаем список проектов в которых участвует разработчик
    private List<Project> getListProject(Long developerId) throws SQLException {
        List<Project> listProject = new ArrayList<Project>();
        String query = "SELECT * FROM developers_projects WHERE developers_id = " + developerId;
        Statement statement = ConnectionUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            Project project = new Project();
            Long projectId = resultSet.getLong("projects_id");
            String projectName = new JdbcProjectDAOImpl().getById(projectId).getProject();

            project.withId(projectId)
                    .withProject(projectName);

            listProject.add(project);
        }
        resultSet.close();
        statement.close();
        return listProject;
    }
}
