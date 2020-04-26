package net.jakim.testing.entities;

import net.jakim.testing.utils.AbstractEntitiesBuilder;

public class Dashboard
{
    private String name;
    private String description;

    public Dashboard( String name,
                      String description )
    {
        this.name = name;
        this.description = description;
    }

    public String getName( )
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getDescription( )
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    @Override
    public String toString( )
    {
        StringBuilder sb = new StringBuilder( );
        sb.append( " name: " )
          .append( this.name )
          .append( "description: " )
          .append( this.description );

        return sb.toString( );
    }

    ////////////////////////////// Builder ////////////////////////
    public static class Builder
            extends AbstractEntitiesBuilder<Dashboard.Builder>
    {
        private String name;
        private String description;

        public Dashboard build( )
        {
            return new Dashboard( this.name,
                                  this.description );
        }

        public Builder setDescription( String description )
        {
            this.description = description;
            return this;
        }

        public Builder setName( String name )
        {
            this.name = name;
            return this;
        }
    }

}
