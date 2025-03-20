package com.shreya.maven.repository;
import com.shreya.maven.model.Customer;
import com.shreya.maven.service.ConnectionService;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerRepository {
    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }
    public void addCustomer(Customer customer) {
        try {
            this.initConnection();
            Statement insertStatement = connection.createStatement();
            boolean isInserted = insertStatement.execute("INSERT INTO customer (id, name, city, mobileNo, age)"
                    + "VALUES (" + customer.getId() + ", '" + customer.getName() + "', '"
                    + customer.getCity() + "', '" + customer.getMobileNo() + "', "
                    + customer.getAge() + ");");

            System.out.println(insertStatement.toString());
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally { //close connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
    public List<Customer> retrieveCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            this.initConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customer");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                int mobileNo = resultSet.getInt("mobileNo");
                int age = resultSet.getInt("age");

                Customer address = new Customer(id,name,city,mobileNo,age);
                customers.add(address);
            }
        }
        catch (SQLException e)
        {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return customers;
    }
    public Customer retrieveCustomer(int id , String name) {
        Customer customer = null;

        try {
            this.initConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer where id = " + id + name);
            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                int mobileNo = resultSet.getInt("mobileNo");
                int age = resultSet.getInt("age");
                customer = new Customer(id,name, city,mobileNo,age);
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return customer;
    }
    Set<Customer> customers = new HashSet<>();
    public void createCustomer(Customer customer) {

        customers.add(customer);
    }
    public void displayCustomers(Customer customer) {
        customers.remove(customer);
    }
    public void displayCustomerToBeClosed(int id) {
        Customer customerToBeClosed = null;
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customerToBeClosed = customer;
            }
        }
        customers.remove(customerToBeClosed);
    }
}