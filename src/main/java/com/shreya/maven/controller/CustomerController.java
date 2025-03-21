package com.shreya.maven.controller;
import com.shreya.maven.exception.CustomerException;
import com.shreya.maven.exception.CustomerNotfound;
import com.shreya.maven.model.Customer;
import com.shreya.maven.repository.CustomerRepository;
import com.shreya.maven.service.CustomerService;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerController {

    private final CustomerService customerService = new CustomerService();
    CustomerRepository customerRepository = new CustomerRepository();
    Customer customer = new Customer();
    private final Scanner sc = new Scanner(System.in);

    public void run() {
        int option ;
        do{
            System.out.println("\n---- Customer ----");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customer Details");
            System.out.println("3. create Customer on db");
            System.out.println("4. delete Customer on db");
            System.out.println("5. Retrieve Customer");
            System.out.println("6. Update Customer");
            System.out.println("7. Read Operation Customer");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(sc.nextLine());
            try {
                switch (option) {
                    case 1:
                        customerService.createCustomer();
                        customerService.displayCustomers();
                        customerService.displayCustomerInfo();
                        customerRepository.createCustomer(customer);
                        customerRepository.displayCustomers(customer);
                        System.out.println("Customer created : " + customer);
                        break;
                    case 2:
                        customerService.displayCustomers();
                        break;
                    case 3:
                        System.out.println("Performing create operation on Customer");
                        CustomerService.insertCustomer(new Customer(135, "krishna", "amt", 908547358, 45));
                        break;
                    case 4:
                        System.out.println("delete Customer");
                        CustomerService.deleteCustomer();
                        break;
                    case 5:
                        System.out.println("Retrieve Customer");
                        customerService.retrieveCustomers().forEach(customer -> {
                            System.out.println("customer ID: " + customer.getId() + ", name: " + customer.getName());
                        });
                        break;
                    case 6:
                        System.out.println("Update Customer");
                        CustomerService.updateCustomer();

                    case 7:
                        System.out.println("Update Customer");
                        CustomerService.updateCustomer();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (CustomerException e) {
                System.out.println("Error: " + e.getClass());
            } catch (CustomerNotfound | SQLException e) {
                throw new RuntimeException(e);
            }
        } while (option != 0);
    }
}