package com.shreya.maven.service;

import com.shreya.maven.exception.InvalideCustomerIDException;
import com.shreya.maven.exception.InvalideCustomerNameException;
import com.shreya.maven.model.Customer;

import java.sql.SQLException;

public interface CustomerServiceIInterface {
    void createCustomer() throws InvalideCustomerIDException, InvalideCustomerNameException, SQLException;

    void displayCustomers();

    Customer getCustomerById(int id);

}
