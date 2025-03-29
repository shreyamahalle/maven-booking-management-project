# maven-booking-management-project
maven-booking-management-project

## **Project Overview**

The Core maven-booking-management-project is a basic Java application that demonstrates a booking management system. It utilizes object-oriented programming principles and simulates the interactions between customers, delivery agents, restaurants, and orders.

## **Features**

- Manage bookings for customers and restaurants.
- Simulate delivery agent assignments.
- Order and customer management using Java models.
- Simple and intuitive structure for learning and demonstration.
  
## **Technologies Used**

-Java: Core programming language.
-Maven: Project management and build automation tool.
-MySQL: Database management system for storing customer, delivery agent, order, and restaurant information.

## **Installation and Setup**
- Prerequisites
- Java Development Kit (JDK) 21.
- An Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse.
- Git (optional, for version control).

## **Steps**
- Clone the repository:
  ```shell
   git clone %%% "git@github.com:shreyamahalle/maven-booking-management-project.git" 
- Navigate to the project directory:
- cd core-java-if-booking-project
- Open the project in your preferred IDE.
- Compile and run the application:
- Locate Main.java.
- Run the file to start the application.

## **Code Structure**  
## **Packages Structure**
- com.booking.using.dowhile: Contains the main application logic (BookingDemoDoWhile.java).
- com.booking.using.dowhile.model: Includes the model classes:
  - Customer.java
  - DeliveryAgent.java
  - Order.java
  - Restaurant.java
- package names: com.booking.Customer.model
- package names: com.booking.DeliveryAgent.model
- package names: com.booking.Order.model
- package names: com.booking.Restaurant.model
- package names: com.booking.BookingDemoDoWhile.service

## **Functionality**
1. **Customer**
2. **DeliveryAgent**
3. **Order**
4. **Restaurant**



## **📝 Database Schema (POJO Classes)**
| **Entity**          | **Attributes** |
|---------------------|----------------------------------------------------------|
| **Customer**           | user id, name, username,monbileNo,city,area |
| **DeliveryAgent**          | id, name, city, mobileNo |
| **Order**         | id, name, city, mobileNo |
| **Restaurant**        |registerNo, name, City, Area |

---


#  Class Diagram
```mermaid
---
title: booking management project
---
classDiagram

 note " food order management "

 class Customer
 Customer : +int ID
 Customer : +String name
 Customer : +String city
 Customer : +int age
 Customer : +int contactNo

class Customer{
 +createCustomer()
 +displayCustomer()
}

class DeliveryAgent
DeliveryAgent : +int id
DeliveryAgent : +String name
DeliveryAgent : +String city
DeliveryAgent : +mobileNo

class DeliveryAgent{
+createDeliveryAgent()
+displayDeliveryAgent()
}

  Customer --|> Order  : Inheritance
class Order{
 +createOrder()
 +displayOrder()
}
 Order : +int Id
 Order : +String name
 Order : +String lastName
 Order : +int age
 Order : +int contactNo
 Order : +String address

class Order{
 +createOrder()
 +displayOrder()
}

Restaurant: +int registerNo
Restaurant: +String Name
Restaurant: +String city
Restaurant: +String Area
Restaurant: +int contactNo

class Restaurant{
 +createRestaurant()
 +displayRestaurant()
}

Customer <-- Order : Association
DeliveryAgent  <-- Order  : Assocciation


Restaurant --> Customer : Association
Restaurant --> Order : Association
Restaurant --> DeliveryAgent : Association

Customer --> DeliveryAgent : Association



```
