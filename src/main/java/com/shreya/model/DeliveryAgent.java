package com.shreya.model;

import lombok.Data;

import java.util.Objects;
@Data
public class DeliveryAgent {
    private int id;
    private String name;
    private String city;
    private int mobileNo;

    @Override
    public String toString() {
        return "DeliveryAgent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", mobileNo=" + mobileNo +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryAgent that = (DeliveryAgent) o;
        return id == that.id && mobileNo == that.mobileNo && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mobileNo);
    }
}
