package com.anhduc.managecake.model;

import lombok.Data;

@Data
public class Checkout {
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String zipCode;
    private String city;
    private String phone;
    private String email;
    private String note;

}
