package com.shreya.maven.controller;

import com.shreya.maven.exception.CustomerException;
import com.shreya.maven.impl.OrderNumberImpl;
import com.shreya.maven.model.Customer;
import com.shreya.maven.model.Order;
import com.shreya.maven.service.OrderNumberService;
import com.shreya.maven.service.OrderService;

import java.util.Scanner;

public class OrderNumberController {

    OrderNumberService orderNumberService = new OrderNumberImpl();
    OrderService orderService = new OrderService();
    private Customer C = new Customer();
    Order order = new Order();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        int option;
        do {
            System.out.println("\n---- Order ----");
            System.out.println("1. View Order Details");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(sc.nextLine());
            try {
                switch (option) {
                    case 1:
                        orderService.createOrder();
                        orderService.displayOrder();
                        System.out.print("Order " + order);
                        break;
                    case 2:
                        orderService.displayOrder();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (CustomerException e) {
                System.out.println("Error: " + e.getClass());
            } finally {
                System.out.println("All Good ");
            }
        } while (option != 0);
    }
}

