package net.jakim.testing.entities;

public class User
{
    private String firstName;
    private String surName;
    private int age;

    public String getSurName( )
    {
        return surName;
    }

    public void setSurName( final String surName )
    {
        this.surName = surName;
    }

    public int getAge( )
    {
        return age;
    }

    public void setAge( final int age )
    {
        this.age = age;
    }

    public String getFirstName( )
    {
        return firstName;
    }

    public void setFirstName( final String firstName )
    {
        this.firstName = firstName;
    }
}
