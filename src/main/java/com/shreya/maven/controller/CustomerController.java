package com.shreya.maven.controller;
import com.shreya.maven.exception.CustomerException;
import com.shreya.maven.model.Customer;
import com.shreya.maven.repository.CustomerRepository;
import com.shreya.maven.service.CustomerService;
//import com.shreya.service.CustomerService;
import java.util.Scanner;

public class CustomerController {

    private CustomerService customerService = new CustomerService();
    CustomerRepository customerRepository = new CustomerRepository();
    Customer customer = new Customer();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        int option ;
        do{
            System.out.println("\n---- Customer ----");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customer Details");
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
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (CustomerException e) {
                System.out.println("Error: " + e.getClass());
            }
        } while (option != 0);
    }
}