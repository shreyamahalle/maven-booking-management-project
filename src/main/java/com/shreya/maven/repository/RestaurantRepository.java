package com.shreya.maven.repository;
import com.shreya.maven.model.Restaurant;
import com.shreya.maven.service.ConnectionService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class RestaurantRepository {
    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }

    Set<Restaurant> restaurants = new HashSet<>();

    public void createRestaurant(Restaurant restaurant){

        restaurants.add(restaurant);
    }

    public void displayRestaurant(Restaurant restaurant){

        restaurants.remove(restaurant);
    }

    public void displayRestaurantToBeClosed(String name){
        Restaurant restaurantToBeClosed = null;
        for (Restaurant restaurant : restaurants){
            if (restaurant.getName() == name){
                restaurantToBeClosed = restaurant;
            }
        }
        restaurants.remove(restaurantToBeClosed);
    }
}
