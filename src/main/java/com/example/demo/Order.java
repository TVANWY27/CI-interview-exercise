package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String id;
    private String clientName;
    private String clientSurname;
    private String address;
    private String postalCode;
    private String city;
    private String phoneNumber;
    private String email;
    private double total;
    private String source;
    private Boolean specific;

}
