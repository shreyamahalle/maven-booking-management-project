package com.shreya.maven.model;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data

public class DeliveryAgent {
    private int id;
    private String name;
    private String city;
    public int mobileNo;

}
