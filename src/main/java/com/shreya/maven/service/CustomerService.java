package com.shreya.maven.service;

import com.shreya.maven.exception.CustomerNotfound;
import com.shreya.maven.model.Customer;
import com.shreya.maven.repository.CustomerRepository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CustomerService {

    private static final CustomerRepository customerRepository = new CustomerRepository();
    Scanner sc = new Scanner(System.in);
    private static final Map<Integer, Customer> customers = new HashMap<>();

    public List<Customer> retrieveCustomers() {
        return customerRepository.retrieveCustomers();
    }

    public static void insertCustomer(Customer customer) throws SQLException {
        customerRepository.addCustomer(customer);
    }

    public static void Customer(Customer customer) {

        customerRepository.retrieveCustomer(1, "abc");
    }

    public static void deleteCustomer() {

        try {
            if (customerRepository.deleteCustomer(1)) {
                System.out.println("Customer deleted successfully!");
            } else {
                System.out.println("Failed to delete Customer.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateCustomer() throws SQLException {
        if (customerRepository.updateCustomer(2, "shreya")) {
            System.out.println("Customer updated successfully ");
        } else {
            System.out.println("Failed to update customer");
        }

    }


    public void displayCustomerInfo() throws CustomerNotfound {
        customers.entrySet().stream().parallel()
                .filter(entry -> entry.getValue().getId() > 101)
                .forEach(entry -> System.out.println("Customer ID: " + entry.getKey() + " = Customer Info: " + entry.getValue()));
    }

    public void createCustomer() {
        Customer customer = new Customer();
        customerRepository.createCustomer(customer);
        customerRepository.displayCustomers(customer);
        customerRepository.displayCustomerToBeClosed(1);

        try {
            System.out.println("Please enter id:");
            int id = Integer.parseInt(sc.nextLine());

            System.out.println("Please enter name:");
            String name = sc.nextLine();

            System.out.println("Please enter city:");
            String city = sc.nextLine();

            System.out.println("Please enter mobile number:");
            int mobileNo = Integer.parseInt(sc.nextLine());

            System.out.println("Please enter age:");
            int age = Integer.parseInt(sc.nextLine());

            customer.setId(id);
            customer.setAge(age);
            customer.setCity(city);
            customer.setName(name);
            customer.setMobileNo(mobileNo);
            customers.put(1, customer);

        } catch (Exception e) {
            System.out.println("Invalid input type correct data");
        }
    }

    public void displayCustomers() {
        try {
            //Set<Map.Entry<Integer, Customer>> entrySet = customers.entrySet();
//            for (Map.Entry<Integer, Customer> customerEntry : entrySet) {
//                System.out.println("Customer Info: " + customers);
//            }
            //java 8 features forEach loop ...
            customers.forEach((customerId, customers) -> System.out.println("Customer Id " + customerId + " = Customer Info " + customers));

        } catch (Exception e) {
            System.out.println("Error occurred");
        }

    }
}
