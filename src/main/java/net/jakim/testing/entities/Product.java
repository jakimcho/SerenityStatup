package net.jakim.testing.entities;

public class Product
{
    private String name;
    private String Vendor;
    private String Type;

    public Product( final String productName )
    {
        this.name = productName;
    }

    public String getName( )
    {
        return this.name;
    }

    public void setName( final String name )
    {
        this.name = name;
    }

    public String getVendor( )
    {
        return Vendor;
    }

    public void setVendor( final String vendor )
    {
        Vendor = vendor;
    }

    public String getType( )
    {
        return Type;
    }

    public void setType( final String type )
    {
        Type = type;
    }
}
