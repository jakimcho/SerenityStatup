package utils;

import net.jakim.entities.Address;
import net.jakim.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
  Class with factory methods for entities builders.
  Use it whenever you want to build un entity object

  Factory methods syntax:
    public static Dashboard.Builder getDashboardBuilder( )
    {
        return new Dashboard.Builder( );
    }
 */

public abstract class EntitiesBuildersFactory
{
    private static Logger LOGGER = LoggerFactory.getLogger( EntitiesBuildersFactory.class );


    public static User.Builder getUserBuilder( )
    {
        return new User.Builder( );
    }

    public static Address.Builder getAddressBuilder( )
    {
        return new Address.Builder( );
    }

}

