package net.jakim.testing.entities;

public class Product
{
    private String name;

    public Product( final String productName )
    {
        this.name = productName;
    }

    public String getName( )
    {
        return this.name;
    }
}
