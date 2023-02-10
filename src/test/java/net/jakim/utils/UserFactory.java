package net.jakim.utils;

import net.jakim.models.User;

public class UserFactory {
    public static User getAValidUser() {
        User user = new User();
        user.setFirstName("Gosho");
        user.setSurName("Petrov");
        user.setEmail("testusedsr@petrov.xom");
        user.setPassword("Aprkc433XX");
        user.setCountry("Bulgaria");
        user.setCity("Sofia");

        return user;
    }
}
