package net.jakim.testing.steps.definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.jakim.testing.entities.Catalog;
import net.jakim.testing.entities.Product;
import net.jakim.testing.entities.ProductId;
import net.jakim.testing.entities.User;
import org.assertj.core.api.SoftAssertions;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationAnnotationDefinitions
{

    private Catalog catalog;
    private List<Product> products;
    private Map<ProductId, Product> productsMap;
    private static final String EXPECTED_CATALOG_NAME = "awesome";
    private static final String EXPECTED_PRODUCT_NAME = "awestruck eels";
    private User user;

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

    @Given ( "the {catalog} catalog" )
    public void prepareCatalog( Catalog catalog )
    {
        this.catalog = catalog;
    }

    @When ( "a user places the {product} in his basket" )
    public void aUserPlacesTheAwestruckEelsInHisBasket( Product product )
    {
        this.catalog.addProduct( product );
    }

    @Then ( "you will be shocked at what happened next" )
    public void youWillBeShockedAtWhatHappenedNext( )
    {
        Product actualProduct = catalog
            .getProducts( )
            .get( 0 );
        SoftAssertions softly = new SoftAssertions( );
        softly
            .assertThat( catalog.getName( ) )
            .isEqualTo( EXPECTED_CATALOG_NAME );
        softly
            .assertThat( actualProduct.getName( ) )
            .isEqualTo( EXPECTED_PRODUCT_NAME );
        softly.assertAll( );
    }

    @When ( "a user orders products:" )
    public void aUserOrderProducts( List<Product> products )
    {
        this.products = products;
    }

    @When ( "a user orders products by id:" )
    public void aUserOrderProducts( Map<ProductId, Product> products )
    {
        this.productsMap = products;
    }

    @When ( "a user creates new account:" )
    public void createUserAccount( User user )
    {
        this.user = user;
    }

    @Then ( "order with ids is placed successfully" )
    public void orderWithIDsIsPlacedSuccessfully( )
    {
        SoftAssertions softly = new SoftAssertions( );
        softly
            .assertThat( productsMap )
            .hasSize( 2 );
        softly
            .assertThat( productsMap )
            .containsKey( new ProductId( 2 ) );
        softly
            .assertThat( productsMap )
            .containsKey( new ProductId( 4 ) );
        softly.assertAll( );
    }

    @Then ( "order is placed successfully" )
    public void orderIsPlacedSuccessfully( )
    {
        SoftAssertions softly = new SoftAssertions( );
        softly
            .assertThat( products )
            .hasSize( 2 );
        softly
            .assertThat( products
                             .get( 0 )
                             .getVendor( ) )
            .isEqualTo( "Danone" );
        softly
            .assertThat( products
                             .get( 1 )
                             .getName( ) )
            .isEqualTo( "sausages" );
        softly
            .assertThat( products
                             .get( 1 )
                             .getName( ) )
            .isEqualTo( "sausages" );
        softly
            .assertThat( products
                             .get( 1 )
                             .getType( ) )
            .isEqualTo( "meat" );
        softly.assertAll( );
    }

    @Then ( "the user account is created successfully" )
    public void theUserAccountIsCreatedSuccessfully( )
    {
        SoftAssertions softly = new SoftAssertions( );
        softly
            .assertThat( user )
            .hasFieldOrPropertyWithValue( "firstName",
                                          "Georgi" );
        softly
            .assertThat( user )
            .hasFieldOrPropertyWithValue( "surName",
                                          "Ivanov" );

        softly
            .assertThat( user )
            .hasFieldOrPropertyWithValue( "age",
                                          18 );
        softly.assertAll( );
    }
}
