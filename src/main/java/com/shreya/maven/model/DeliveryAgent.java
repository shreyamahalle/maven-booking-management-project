package com.shreya.maven.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class DeliveryAgent {
    private int id;
    private String name;
    private String city;
    private int mobileNo;

}
