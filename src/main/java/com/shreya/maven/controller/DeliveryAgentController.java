package com.shreya.maven.controller;
import com.shreya.maven.exception.DeliveryAgentException;
import com.shreya.maven.model.Customer;
import com.shreya.maven.model.DeliveryAgent;
import com.shreya.maven.service.DeliveryAgentService;

import java.util.Scanner;

public class DeliveryAgentController {
    private DeliveryAgentService deliveryAgentService = new DeliveryAgentService();
    private Customer C = new Customer();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        int option;
        do{
            System.out.println("\n---- DeliveryAgent ----");
            System.out.println("1. Add DeliveryAgent");
            System.out.println("2. View DeliveryAgent Details");
            System.out.println("0. Back to the Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(sc.nextLine());
            try {
                switch (option) {
                    case 1:
                        deliveryAgentService.createDeliveryAgent();
                        DeliveryAgent deliveryAgent = new DeliveryAgent();
                        deliveryAgentService.displayDeliveryAgent();
                        System.out.println("DeliveryAgent " + deliveryAgent );
                        break;
                    case 2:
                        deliveryAgentService.displayDeliveryAgent();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (DeliveryAgentException e) {
                System.out.println("Error: " + e.getClass());
            }
        } while (option != 0);
    }
}
