package com.shreya.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class Order {
    private int id;
    private String type;
    private String note;
    private String paymentMethod;


}
