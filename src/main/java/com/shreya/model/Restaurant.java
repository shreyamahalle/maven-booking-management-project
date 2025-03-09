package com.shreya.model;

import lombok.Data;
import lombok.ToString;

import java.util.Objects;
@Data
@ToString
public class Restaurant {
    private int registerNo;
    private String name;
    private String City;
    private String Area;
}