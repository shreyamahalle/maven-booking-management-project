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
 public class Customer {
    private int id;
    private String name;
    private String city;
    private int mobileNo;
    private int age;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", mobileNo=" + mobileNo +
                ", age=" + age +
                '}';
    }


     @Override
     public boolean equals(Object o) {
         if (o == null || getClass() != o.getClass()) return false;
         Customer customer = (Customer) o;
         return id == customer.id && mobileNo == customer.mobileNo;
     }

     @Override
     public int hashCode() {
         return Objects.hash(id, mobileNo);
     }
 }
