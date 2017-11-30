package com.gmail.fomichov.m.dao.jdbc;

import com.gmail.fomichov.m.dao.CompanyDAO;
import com.gmail.fomichov.m.dao.ConnectionUtil;
import com.gmail.fomichov.m.model.Company;
import com.gmail.fomichov.m.work.ShowTablesInConsole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcCompanyDAOImpl implements CompanyDAO {

    public Company getById(Long id) throws SQLException {
        String sql = "SELECT * FROM companies WHERE id = " + id;
        Statement statement = ConnectionUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        Company company = new Company();

        while (resultSet.next()) {
            Long companyId = resultSet.getLong("id");
            String nameCompany = resultSet.getString("company");

            company.withId(companyId)
                    .withCompany(nameCompany);
        }

        resultSet.close();
        statement.close();

        return company;
    }

    public List<Company> getAll() throws SQLException {
        List<Company> companyList = new ArrayList<Company>();
        String sql = "SELECT * FROM companies ORDER BY id";
        Statement statement = ConnectionUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Company company = new Company();
            Long companyId = resultSet.getLong("id");
            String nameCompany = resultSet.getString("company");

            company.withId(companyId)
                    .withCompany(nameCompany);

            companyList.add(company);
        }

        resultSet.close();
        statement.close();

        return companyList;
    }


    public void update(Company company) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String query = "UPDATE companies SET company='" + company.getCompany() + "' where id=" + company.getId();
        statement.executeUpdate(query);
        statement.close();
        ShowTablesInConsole.showTableCompanies();
    }

    public void delete(Company company) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String deleteQuery = "DELETE FROM companies WHERE id=" + company.getId();
        statement.executeUpdate(deleteQuery);
        statement.close();
        ShowTablesInConsole.showTableCompanies();
    }

    public void create(Company company) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String name = company.getCompany();
        String insertQuery = "INSERT INTO companies(company)" + "VALUES('" + name + "')";
        statement.executeUpdate(insertQuery);
        statement.close();
        ShowTablesInConsole.showTableCompanies();
    }
}
