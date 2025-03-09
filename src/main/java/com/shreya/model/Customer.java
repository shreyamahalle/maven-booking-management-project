 package com.shreya.model;

 import lombok.Data;
 import lombok.Getter;
 import lombok.Setter;
 import lombok.ToString;

 import java.util.Objects;
//@Getter
//@Setter
//@ToString
@Data
@ToString
 public class Customer {
    private int id;
    private String name;
    private String city;
    private int mobileNo;
    private int age;


 }
