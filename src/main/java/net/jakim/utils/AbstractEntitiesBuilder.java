package utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.AccessControlException;
import java.util.*;


public abstract class AbstractEntitiesBuilder<T extends AbstractEntitiesBuilder>
{
    private static Logger LOGGER = LoggerFactory.getLogger( AbstractEntitiesBuilder.class );

    public T fromMap( Map<String, String> rawData )
    {
        LOGGER.debug( "Inside fromMap() method" );
        T builder = ( T ) this;
        Class currentBuilder = builder.getClass( );

        rawData.keySet( )
               .parallelStream( )
               .forEach( key->
                         {
                             String value = "";
                             try
                             {
                                 LOGGER.debug( "Searching for field in {} {}",
                                               builder.getClass( )
                                                      .getName( ),
                                               key );
                                 Field field = currentBuilder.getDeclaredField( key );
                                 field.setAccessible( true );
                                 value = Randomiser.randomizeValue( rawData.get( key ) );
                                 LOGGER.debug( "Setting {} field {} with value {} ",
                                               field.getType( ),
                                               key,
                                               value );
                                 if( field.getType( )
                                          .getName( )
                                          .equals( "boolean" ) )
                                 {
                                     boolean boolValue = value.equalsIgnoreCase( "true" );
                                     field.set( builder,
                                                boolValue );
                                 } else if( field.getType( )
                                                 .getName( )
                                                 .equals( "int" ) )
                                 {
                                     int intValue = Integer.parseInt( value );
                                     field.set( builder,
                                                intValue );
                                 } else if( field.getType( )
                                                 .equals( List.class ) )
                                 {
                                     field.set( builder,
                                                generateListValue( field,
                                                                   value ) );
                                 } else if( field.getType( )
                                                 .equals( Map.class ) )
                                 {
                                     field.set( builder,
                                                generateMapValue( field,
                                                                  value ) );
                                 } else
                                 {
                                     field.set( builder,
                                                value );
                                 }
                             } catch( NoSuchFieldException e )
                             {
                                 LOGGER.error( "Did not found such field {}",
                                               key );
                                 e.printStackTrace( );
                                 throw new NoSuchElementException( "Did not found such field {}" );
                             } catch( IllegalAccessException e )
                             {
                                 LOGGER.error( "Cannot assign value {} to field {}",
                                               value,
                                               key );
                                 e.printStackTrace( );
                                 throw new AccessControlException( "Cannot assign value {} to field {}" );
                             }
                         } );

        LOGGER.debug( "Exiting fromMap() method" );
        return builder;
    }


    /////////////////////////////////////////////////////// Helpers //////////////////////////////////////////////////////

    private List generateListValue( Field field,
                                    String value )
    {
        LOGGER.debug( "Inside  generateListValue() method" );
        List<String> resultList = new ArrayList<>( );
        ParameterizedType type = ( ParameterizedType ) field.getGenericType( );

        Type listGenericType = type.getActualTypeArguments( )[0];
        LOGGER.debug( "Generic Type: " + listGenericType.getTypeName( ) );

        LOGGER.debug( "Checking if the provided value is a list object" );
        if( listGenericType.getTypeName( )
                           .equals( "java.lang.String" ) )
        {
            String[] listItems = value.replace( "{",
                                                "" )
                                      .replace( "}",
                                                "" )
                                      .split( "," );
            for( String item : listItems )
            {
                LOGGER.debug( "Injecting {} in the list.",
                              item );
                resultList.add( Randomiser.randomizeValue( item )
                                          .trim( ) );
            }
        } else
        {
            throw new ClassCastException( "The passed object is not expected Type" );
        }

        LOGGER.debug( "Exiting generateListValue() method" );
        return resultList;
    }

    private Map<String, String> generateMapValue( Field field,
                                                  String value )
    {
        LOGGER.debug( "Inside  generateMapValue() method" );
        if (null == value || value.isEmpty()){
            return null;
        }
        ParameterizedType type = ( ParameterizedType ) field.getGenericType( );

        Type mapKeyType = type.getActualTypeArguments( )[0];
        LOGGER.debug( "Key: " + mapKeyType.getTypeName( ) );

        Type mapValueType = type.getActualTypeArguments( )[1];
        LOGGER.debug( "Value: " + mapValueType.getTypeName( ) );

        Map<String, String> map = new HashMap<>( );
        if( mapKeyType.getTypeName( )
                      .equals( "java.lang.String" ) && mapValueType.getTypeName( )
                                                                   .equals( "java.lang.String" ) )
        {
            String[] mapEntriesTokens = value.replaceAll( "[{|}|\"]",
                                                          "" )
                                             .split( "," );
            for( String mapEntry : mapEntriesTokens )
            {
                String[] kvp = mapEntry.split( "[=|:]" );
                map.put( kvp[0].trim( ),
                         kvp[1].trim( ) );
            }

        } else
        {
            throw new ClassCastException( "The passed object is not expected Type" );
        }

        LOGGER.debug( "Exiting generateMapValue() method" );
        return map;
    }
}
