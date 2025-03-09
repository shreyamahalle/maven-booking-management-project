package com.shreya.model;

import lombok.Data;
import lombok.ToString;

import java.util.Objects;
@Data
@ToString

public class DeliveryAgent {
    private int id;
    private String name;
    private String city;
    private int mobileNo;

}
