package com.gmail.fomichov.m.dao.jdbc;

import com.gmail.fomichov.m.dao.ConnectionUtil;
import com.gmail.fomichov.m.dao.SkillDAO;
import com.gmail.fomichov.m.model.Skill;
import com.gmail.fomichov.m.work.ShowTablesInConsole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcSkillDAOImpl implements SkillDAO {

    public Skill getById(Long id) throws SQLException {
        String sql = "SELECT * FROM skills WHERE id = " + id;
        Statement statement = ConnectionUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        Skill skill = new Skill();

        while (resultSet.next()) {
            Long skillId = resultSet.getLong("id");
            String nameSkill = resultSet.getString("skill");

            skill.withId(skillId)
                    .withSkill(nameSkill);
        }

        resultSet.close();
        statement.close();

        return skill;
    }

    public List<Skill> getAll() throws SQLException {
        List<Skill> skillList = new ArrayList<Skill>();
        String sql = "SELECT * FROM skills ORDER BY id";
        Statement statement = ConnectionUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);


        while (resultSet.next()) {
            Skill skill = new Skill();
            Long skillId = resultSet.getLong("id");
            String nameSkill = resultSet.getString("skill");

            skill.withId(skillId)
                    .withSkill(nameSkill);

            skillList.add(skill);
        }

        resultSet.close();
        statement.close();

        return skillList;
    }

    public void update(Skill skill) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String query = "UPDATE skills SET skill='" + skill.getSkill() + "' where id=" + skill.getId();
        statement.executeUpdate(query);
        statement.close();
        ShowTablesInConsole.showTableSkills();
    }

    public void delete(Skill skill) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String deleteQuery = "DELETE FROM skills WHERE id=" + skill.getId();
        statement.executeUpdate(deleteQuery);
        statement.close();
        ShowTablesInConsole.showTableSkills();
    }

    public void create(Skill skill) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String name = skill.getSkill();
        String insertQuery = "INSERT INTO skills(skill)" + "VALUES('" + name + "')";
        statement.executeUpdate(insertQuery);
        statement.close();
        ShowTablesInConsole.showTableSkills();
    }
}
