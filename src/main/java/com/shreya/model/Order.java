package com.shreya.model;

import lombok.Data;

import java.util.Objects;
@Data
public class Order {
    private int id;
    private String type;
    private String note;
    private String paymentMethod;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", note='" + note + '\'' +
                ", paymentMethod=" + paymentMethod +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
