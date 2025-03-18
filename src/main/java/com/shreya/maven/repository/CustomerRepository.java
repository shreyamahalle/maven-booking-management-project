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

    public boolean addCustomer(Customer customer) {
        try {
            this.initConnection();
            Statement insertStatement = connection.createStatement();
            boolean isInserted = insertStatement.execute("INSERT INTO customer (id, name, city, mobileNo, age) "
                    + "VALUES (" + customer.getId() + ", '" + customer.getName() + "', '"
                    + customer.getCity() + "', '" + customer.getMobileNo() + "', "
                    + customer.getAge() + ");");


            System.out.println(insertStatement.toString());
            return isInserted;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> showCustomers() {

        List<Customer> customers = new ArrayList<>();

        // Use the connection to execute SQL queries and interact with the database
        try {
            this.initConnection();
            // Your database operations here...
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");
            // Iterate over the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id"); // Replace "id" with your actual column name
                String name = resultSet.getString("name");
                String city = resultSet.getString("city"); // Replace "city" with your actual column name
                int mobileNo = resultSet.getInt("mobileNo");
                int age = resultSet.getInt("age");
                // Do something with the data, e.g., print it
                Customer address = new Customer(id,name,city,mobileNo,age);
                customers.add(address);
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            // Close the connection when done
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

    public Customer retrieveCustomer(int custometrId) {
        Customer customer = null;
        // Use the connection to execute SQL queries and interact with the database
        try {
            this.initConnection();
            // Your database operations here...
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer where id = " + custometrId);
            // Iterate over the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id"); // Replace "id" with your actual column name
                String name = resultSet.getString("name"); // Replace "city" with your actual column name
                String city = resultSet.getString("city"); // Replace "city" with your actual column name
                int mobileNo = resultSet.getInt("mobileNo"); // Replace "city" with your actual column name
                int age = resultSet.getInt("age"); // Replace "city" with your actual column name
                // Do something with the data, e.g., print it
                customer = new Customer(id,name, city,mobileNo,age);
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            // Close the connection when done
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

    public boolean createCustomer(Customer customer) {

        customers.add(customer);
        return false;
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

    public List<Customer> retrieveCustomers() {
        return List.of();
    }
}