package net.jakim.models;

import lombok.Data;

@Data
public class User {
    private String firstName;
    private String surName;
    private String email;
    private String password;
    private String country;
    private String city;
}
