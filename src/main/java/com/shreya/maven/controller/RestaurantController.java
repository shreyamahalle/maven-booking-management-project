package com.shreya.maven.controller;
import com.shreya.maven.exception.CustomerException;
import com.shreya.maven.model.Restaurant;
import com.shreya.maven.service.RestaurantService;

import java.sql.SQLException;
import java.util.Scanner;

public class RestaurantController {

    private RestaurantService restaurantService = new RestaurantService();
    Restaurant restaurant = new Restaurant();
    private final Scanner sc = new Scanner(System.in);

    public void run() {
        int option;
        do{
            System.out.println("\n---- Order ----");
            System.out.println("1. Add Order");
            System.out.println("2. View Order Details");
            System.out.println("3. create Customer on db");
            System.out.println("4. delete Customer on db");
            System.out.println("5. Retrieve Customer");
            System.out.println("6. Update Customer");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(sc.nextLine());
            try {
                switch (option) {
                    case 1:
                        RestaurantService.createRestaurant();
                        RestaurantService.displayRestaurant();
                        System.out.print("restaurant " + restaurant);
                        break;
                    case 2:
                        RestaurantService.displayRestaurant();
                        break;
                    case 3:
                        System.out.println("Performing create operation on Restaurant");
                        RestaurantService.insertRestaurant(new Restaurant(135, "krishna", "pune", "abc"));
                        break;
                    case 4:
                        System.out.println("delete Restaurant");
                        RestaurantService.deleteRestaurant();
                        break;
                    case 5:
                        System.out.println("Retrieve Restaurant");
                        RestaurantService.retrieveRestaurants().forEach(restaurant -> {
                            System.out.println("restaurant ID: " + restaurant.getRegisterNo() + ", name: " + restaurant.getName());
                        });
                        break;
                    case 6:
                        System.out.println("Update Restaurant");
                        RestaurantService.updateRestaurant();
                        break;

                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (CustomerException e) {
                System.out.println("Error: " + e.getClass());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } while (option != 0);
    }

    public RestaurantService getRestaurantService() {
        return restaurantService;
    }

    public void setRestaurantService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
}


