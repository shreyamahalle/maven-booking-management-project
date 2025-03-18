package com.shreya.maven;
import com.shreya.maven.controller.*;
import com.shreya.maven.exception.InvalideCustomerIDException;
import com.shreya.maven.impl.CustomerImpl;
import com.shreya.maven.impl.OrderNumberImpl;
import com.shreya.maven.model.Customer;
import com.shreya.maven.model.DeliveryAgent;
import com.shreya.maven.model.Order;
import com.shreya.maven.model.Restaurant;
import com.shreya.maven.repository.CustomerRepository;
import com.shreya.maven.service.*;
import java.util.Scanner;
public class BookingOrderManagement {

    private static final ConnectionService connectionService = new ConnectionService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InvalideCustomerIDException{

        int option = 0;
        do {
            System.out.println("-----------Booking Management-----------");
            System.out.println("Please choose the option");
            System.out.println("1. Create customer");
            System.out.println("2. Create delivery agent");
            System.out.println("3. Create restaurant ");
            System.out.println("4. Create order");
            System.out.println("5. Display Order Number");
            System.out.println("6. Combo Pack Offer");
            System.out.println("7. create customer DB");
            System.out.println("0. Exit project");
            System.out.println("Select the option..");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    CustomerController customerController = new CustomerController();
                    customerController.run();
                    Customer customer = new Customer();
                    System.out.println("Customer created : " + customer);
                    break;
            }
            switch (option) {
                case 2:
                    DeliveryAgentController deliveryAgentController = new DeliveryAgentController();
                    DeliveryAgentService deliveryAgentService = new DeliveryAgentService();
                    deliveryAgentService.createDeliveryAgent();
                    deliveryAgentController.run();
                    DeliveryAgent deliveryAgent = new DeliveryAgent();
                    System.out.println("DeliveryAgent created : " + deliveryAgent);
                    break;
            }
            switch (option) {
                case 3:
                    OrderController orderController = new OrderController();
                    OrderService orderService = new OrderService();
                    OrderNumberService orderNumberService = new OrderNumberImpl();
                    orderController.run();
                    orderService.createOrder();
                    Order order = new Order();
                    orderNumberService.createOrderNo();
                    System.out.println("Order created : " + order);
                    break;
            }
            switch (option) {
                case 4:
                    RestaurantController restaurantController = new RestaurantController();
                    restaurantController.run();
                    Restaurant restaurant = new Restaurant();
                    System.out.println("Restaurant created : " + restaurant);
                    break;
            }
            switch (option) {
                case 5:
                    OrderNumberService orderNumberService = new OrderNumberImpl();
                    CustomerImpl customerImpl = new CustomerImpl();
                    OrderNumberController orderNumberController = new OrderNumberController();
                    orderNumberController.run();
                    orderNumberService.createOrderNo();
                    customerImpl.printCustomer();
                    customerImpl.createOrder();
                    customerImpl.displayOrder();
            }
            switch (option) {
                case 6:
                    OrderMultipleInheritanceService orderMultipleInheritanceService = new OrderMultipleInheritanceService();
                    orderMultipleInheritanceService.displayOrder();
            }
            switch (option) {
                case 7:
                    System.out.println("Performing CREATE operation on Customer");
                    CustomerService.insertCustomer(new Customer(2080, "krishna", "amt", 908547358, 45));
                    break;
            }
            switch (option) {
                case 0:
                    System.out.println("Exiting project");
                    break;
            }
        }
        while (option != 0);

        System.out.println("THANK YOU!");
    }
}


