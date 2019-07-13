package net.jakim.entities;

public class User
{
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthDate;
    private Address address;

    public String getTitle( )
    {
        return title;
    }

    public void setTitle( String title )
    {
        this.title = title;
    }

    public String getFirstName( )
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName( )
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public String getEmail( )
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getPassword( )
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String getBirthDate( )
    {
        return birthDate;
    }

    public void setBirthDate( String birthDate )
    {
        this.birthDate = birthDate;
    }

    public Address getAddress( )
    {
        return address;
    }

    public void setAddress( Address address )
    {
        this.address = address;
    }
}
