package net.jakim.testing.entities;

import lombok.Data;

@Data
public class User {
    private String firstName;
    private String surName;
    private String country;
    private String city;
    private String email;
    private String password;
}
