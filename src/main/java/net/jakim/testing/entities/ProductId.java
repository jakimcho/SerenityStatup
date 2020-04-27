package net.jakim.testing.entities;

import java.util.Objects;

public class ProductId
{
    private int id;

    public ProductId( final int id )
    {
        this.id = id;
    }

    public int getId( )
    {
        return id;
    }

    public void setId( final int id )
    {
        this.id = id;
    }

    @Override
    public boolean equals( final Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass( ) != o.getClass( ) )
        {
            return false;
        }
        final ProductId productId = ( ProductId ) o;
        return id == productId.id;
    }

    @Override
    public int hashCode( )
    {
        return Objects.hash( id );
    }
}
