package net.jakim.testing.steps.definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import net.jakim.testing.entities.Catalog;
import net.jakim.testing.entities.Product;
import net.jakim.testing.entities.ProductId;
import net.jakim.testing.entities.User;

import java.util.Map;

public class Transformers
{

    @ParameterType ( "[a-z]+" )
    public Catalog catalog( String catalogName )
    {
        return new Catalog( catalogName );
    }

    @ParameterType ( "[a-z ]+" )
    public Product product( String productName )
    {
        return new Product( productName );
    }

    @DataTableType
    public Product products( Map<String, String> rawProducts )
    {
        Product product = new Product( rawProducts.get( "name" ) );
        product.setVendor( rawProducts.get( "vendor" ) );
        product.setType( rawProducts.get( "type" ) );
        return product;
    }

    @DataTableType
    public ProductId getProductId( String cell )
    {
        return new ProductId( Integer.parseInt( cell ) );
    }

    @DataTableType
    public User getUser( DataTable userData )
    {
        Map<String, String> userDataMap = userData.asMaps().get(0);
        User user = new User( );
        user.setFirstName( userDataMap.get( "firstName" ) );
        user.setSurName( userDataMap.get( "surName" ) );
        user.setAge( Integer.parseInt( userDataMap.get( "age" ) ) );
        return user;
    }
}
