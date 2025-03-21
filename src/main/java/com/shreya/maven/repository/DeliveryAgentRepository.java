package com.shreya.maven.repository;
import com.shreya.maven.model.DeliveryAgent;
import com.shreya.maven.service.ConnectionService;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeliveryAgentRepository {
    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }

    public boolean insertDeliveryAgent(DeliveryAgent deliveryAgent) throws SQLException {
        this.initConnection();
        String query = "insert into deliveryAgent values (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, deliveryAgent.getId());
            preparedStatement.setString(2, deliveryAgent.getName());
            preparedStatement.setString(3, deliveryAgent.getCity());
            preparedStatement.setInt(4, deliveryAgent.getMobileNo());
            System.out.println("inserting deliveryAgent data to table: " + deliveryAgent);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean deleteDeliveryAgent(int id) throws SQLException {

        try {
            this.initConnection();
            Statement statement = connection.createStatement();
            return statement.execute("delete from DeliveryAgent where id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("connection is closed: " + e.getMessage());

                }
            }
        }
    }

    public List<DeliveryAgent> retrieveDeliveryAgents() {
        List<DeliveryAgent> deliveryAgents = new ArrayList<>();
        try {
            this.initConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from deliveryagent");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                int mobileNo = resultSet.getInt("mobileNo");

                DeliveryAgent deliveryAgent = new DeliveryAgent(id, name, city, mobileNo);
                deliveryAgents.add(deliveryAgent);
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
        return deliveryAgents;
    }

    public DeliveryAgent retrieveDeliveryAgent(int id, String name) {
        DeliveryAgent deliveryAgent = null;

        try {
            this.initConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM deliveryagent where id = " + id + name);
            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                int mobileNo = resultSet.getInt("mobileNo");

                deliveryAgent = new DeliveryAgent(id, name, city, mobileNo);
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
        return deliveryAgent;
    }


     Set<DeliveryAgent> deliveryAgents = new HashSet<>();

      public void createDeliveryAgent (DeliveryAgent deliveryAgent){

       deliveryAgents.add(deliveryAgent);
       }
       public void displayDeliveryAgent (DeliveryAgent deliveryAgent){

           deliveryAgents.remove(deliveryAgent);
       }
       public void displayDeliveryAgentToBeClosed ( int id){

           DeliveryAgent deliveryAgentToBeClosed = null;
           for (DeliveryAgent deliveryAgent : deliveryAgents) {
               if (deliveryAgent.getId() == id) {
                   deliveryAgentToBeClosed = deliveryAgent;
               }
           }
           deliveryAgents.remove(deliveryAgentToBeClosed);
       }
}