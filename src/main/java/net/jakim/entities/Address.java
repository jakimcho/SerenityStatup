package net.jakim.entities;

import utils.AbstractEntitiesBuilder;

public class Address
{
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String mobilePhone;
    private String emailAlias;
    private String alias;

    public Address( String firstName,
                    String lastName,
                    String company,
                    String address,
                    String city,
                    String state,
                    String postalCode,
                    String country,
                    String mobilePhone,
                    String emailAlias,
                    String alias )
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.mobilePhone = mobilePhone;
        this.emailAlias = emailAlias;
        this.alias = alias;
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

    public String getCompany( )
    {
        return company;
    }

    public void setCompany( String company )
    {
        this.company = company;
    }

    public String getAddress( )
    {
        return address;
    }

    public void setAddress( String address )
    {
        this.address = address;
    }

    public String getCity( )
    {
        return city;
    }

    public void setCity( String city )
    {
        this.city = city;
    }

    public String getState( )
    {
        return state;
    }

    public void setState( String state )
    {
        this.state = state;
    }

    public String getPostalCode( )
    {
        return postalCode;
    }

    public void setPostalCode( String postalCode )
    {
        this.postalCode = postalCode;
    }

    public String getCountry( )
    {
        return country;
    }

    public void setCountry( String country )
    {
        this.country = country;
    }

    public String getMobilePhone( )
    {
        return mobilePhone;
    }

    public void setMobilePhone( String mobilePhone )
    {
        this.mobilePhone = mobilePhone;
    }

    public String getEmailAlias( )
    {
        return emailAlias;
    }

    public void setEmailAlias( String emailAlias )
    {
        this.emailAlias = emailAlias;
    }

    public String getAlias( )
    {
        return alias;
    }

    public void setAlias( String alias )
    {
        this.alias = alias;
    }

    public static class Builder
            extends AbstractEntitiesBuilder<Address.Builder>
    {

        private String firstName;
        private String lastName;
        private String company;
        private String address;
        private String city;
        private String state;
        private String postalCode;
        private String country;
        private String mobilePhone;
        private String emailAlias;
        private String alias;

        public Address build( )
        {
            return new Address( firstName,
                                lastName,
                                company,
                                address,
                                city,
                                state,
                                postalCode,
                                country,
                                mobilePhone,
                                emailAlias,
                                alias );
        }


        public Address.Builder withFirstName( String firstName )
        {
            this.firstName = firstName;
            return this;
        }

        public Address.Builder withLastName( String lastName )
        {
            this.lastName = lastName;
            return this;
        }


        // TODO: add the additional methods

    }

}
