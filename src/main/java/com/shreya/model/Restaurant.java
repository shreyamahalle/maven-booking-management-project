package com.shreya.model;

import lombok.Data;

import java.util.Objects;
@Data
public class Restaurant {
    private int registerNo;
    private String name;
    private String City;
    private String Area;

    @Override
    public String toString() {
        return "Restaurant{" +
                "registerNo=" + registerNo +
                ", name='" + name + '\'' +
                ", City='" + City + '\'' +
                ", Area='" + Area + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return registerNo == that.registerNo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(registerNo);
    }
}