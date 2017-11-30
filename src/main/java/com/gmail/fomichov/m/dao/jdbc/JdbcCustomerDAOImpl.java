package com.gmail.fomichov.m.dao.jdbc;

import com.gmail.fomichov.m.dao.ConnectionUtil;
import com.gmail.fomichov.m.dao.CustomerDAO;
import com.gmail.fomichov.m.model.Customer;
import com.gmail.fomichov.m.work.ShowTablesInConsole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcCustomerDAOImpl implements CustomerDAO {

    public Customer getById(Long id) throws SQLException {
        String sql = "SELECT * FROM customers WHERE id = " + id;
        Statement statement = ConnectionUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        Customer customer = new Customer();

        while (resultSet.next()) {
            Long customerId = resultSet.getLong("id");
            String nameCustomer = resultSet.getString("customer");

            customer.withId(customerId)
                    .withCustomer(nameCustomer);
        }

        resultSet.close();
        statement.close();

        return customer;
    }

    public List<Customer> getAll() throws SQLException {
        List<Customer> customerList = new ArrayList<Customer>();
        String sql = "SELECT * FROM customers ORDER BY id";
        Statement statement = ConnectionUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);


        while (resultSet.next()) {
            Customer customer = new Customer();
            Long customerId = resultSet.getLong("id");
            String nameCustomer = resultSet.getString("customer");

            customer.withId(customerId)
                    .withCustomer(nameCustomer);

            customerList.add(customer);
        }

        resultSet.close();
        statement.close();

        return customerList;
    }

    public void update(Customer customer) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String query = "UPDATE customers SET customer='" + customer.getCustomer() + "' where id=" + customer.getId();
        statement.executeUpdate(query);
        statement.close();
        ShowTablesInConsole.showTableCustomers();
    }

    public void delete(Customer customer) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String deleteQuery = "DELETE FROM customers WHERE id=" + customer.getId();
        statement.executeUpdate(deleteQuery);
        statement.close();
        ShowTablesInConsole.showTableCustomers();
    }

    public void create(Customer customer) throws SQLException {
        Statement statement = ConnectionUtil.getConnection().createStatement();
        String name = customer.getCustomer();
        String insertQuery = "INSERT INTO customers(customer)" + "VALUES('" + name + "')";
        statement.executeUpdate(insertQuery);
        statement.close();
        ShowTablesInConsole.showTableCustomers();
    }
}
