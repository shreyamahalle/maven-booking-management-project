package com.shreya.maven.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Order {
    private int id;
    private String type;
    private String note;
    private String paymentMethod;

}
