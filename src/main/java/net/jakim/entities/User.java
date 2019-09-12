package net.jakim.entities;

import utils.AbstractEntitiesBuilder;

public class User
{
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthDate;
    private Address address;

    public Address getAddress( )
    {
        return address;
    }

    public User( String tile,
                 String firstName,
                 String lastName,
                 String email,
                 String password,
                 String birthDate,
                 Address address )
    {
        this.title = tile;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.address = address;
    }

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

    public void setAddress( Address address )
    {
        this.address = address;
    }

    public static class Builder
            extends AbstractEntitiesBuilder<User.Builder>
    {

        private String title;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String birthDate;
        private Address address;

        public User build( )
        {
            return new User( title,
                             firstName,
                             lastName,
                             email,
                             password,
                             birthDate,
                             address );
        }

        public Builder withTitle( String title )
        {
            this.title = title;
            return this;
        }

        public Builder withFirstName( String firstName )
        {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName( String lastName )
        {
            this.lastName = lastName;
            return this;
        }

        public Builder withEmail( String email )
        {
            this.email = email;
            return this;
        }

        public Builder withPassword( String password )
        {
            this.password = password;
            return this;
        }

        public Builder withBirthDate( String birthDate )
        {
            this.birthDate = birthDate;
            return this;
        }

        public Builder withAddress( Address address )
        {
            this.address = address;
            return this;
        }

    }
}
