package com.shreya.maven.repository;
import com.shreya.maven.model.Order;
import com.shreya.maven.service.ConnectionService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OrderRepository {
    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }
    Set<Order> orders = new HashSet<>();

    public void createOrder(Order order){

        orders.add(order);
    }
    public void displayOrder(Order order){
        orders.remove(order);
    }

    public void displayOrderToBeClosed(int id){
        Order orderToBeClosed = null;
        for (Order order : orders){
            if (order.getId() == id){
                orderToBeClosed = order;
            }
        }
        orders.remove(orderToBeClosed);
    }

}
