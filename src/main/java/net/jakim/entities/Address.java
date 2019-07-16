package net.jakim.entities;

import utils.AbstractEntitiesBuilder;

public class Address
{

    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String additionalInformation;
    private String mobilePhone;
    private String addressAlias;

    public Address()
    {
        super();
    }

    public Address( String firstName,
                    String lastName,
                    String company,
                    String address,
                    String address2,
                    String city,
                    String state,
                    String zip,
                    String country,
                    String additionalInformation,
                    String mobilePhone,
                    String addressAlias )
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.address = address;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.additionalInformation = additionalInformation;
        this.mobilePhone = mobilePhone;
        this.addressAlias = addressAlias;
    }

    public Address( final User user )
    {
        this.firstName = user.getFirstName();
        this.firstName = user.getLastName();
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany( String company )
    {
        this.company = company;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress( String address )
    {
        this.address = address;
    }

    public String getAddress2()
    {
        return address2;
    }

    public void setAddress2( String address2 )
    {
        this.address2 = address2;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity( String city )
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState( String state )
    {
        this.state = state;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip( String zip )
    {
        this.zip = zip;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry( String country )
    {
        this.country = country;
    }

    public String getAdditionalInformation()
    {
        return additionalInformation;
    }

    public void setAdditionalInformation( String additionalInformation )
    {
        this.additionalInformation = additionalInformation;
    }

    public String getMobilePhone()
    {
        return mobilePhone;
    }

    public void setMobilePhone( String mobilePhone )
    {
        this.mobilePhone = mobilePhone;
    }

    public String getAddressAlias()
    {
        return addressAlias;
    }

    public void setAddressAlias( String addressAlias )
    {
        this.addressAlias = addressAlias;
    }

    public static class Builder
            extends AbstractEntitiesBuilder<Builder>
    {
        private String firstName;
        private String lastName;
        private String company;
        private String address;
        private String address2;
        private String city;
        private String state;
        private String zip;
        private String country;
        private String additionalInformation;
        private String mobilePhone;
        private String addressAlias;

        public Address build()
        {
            return new Address( this.firstName,
                                this.lastName,
                                this.company,
                                this.address,
                                this.address2,
                                this.city,
                                this.state,
                                this.zip,
                                this.country,
                                this.additionalInformation,
                                this.mobilePhone,
                                this.addressAlias );
        }
    }
}

