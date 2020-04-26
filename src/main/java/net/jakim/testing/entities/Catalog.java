package net.jakim.testing.entities;

import java.util.ArrayList;
import java.util.List;

public class Catalog
{
    private String name;
    private List<Product> products;

    public Catalog( final String name )
    {
        this.products = new ArrayList<>( );
        this.name = name;
    }

    public void addProduct( Product product )
    {
        products.add( product );
    }

    public List<Product> getProducts( )
    {
        return products;
    }

    public void setProducts( final List<Product> products )
    {
        this.products = products;
    }

    public String getName( )
    {
        return name;
    }

    public void setName( final String name )
    {
        this.name = name;
    }
}
