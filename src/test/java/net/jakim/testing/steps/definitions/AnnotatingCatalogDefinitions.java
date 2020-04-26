package net.jakim.testing.steps.definitions;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.jakim.testing.entities.Catalog;
import net.jakim.testing.entities.Product;
import org.assertj.core.api.SoftAssertions;

public class AnnotatingCatalogDefinitions
{
    private Catalog catalog;
    private static final String EXPECTED_CATALOG_NAME = "awesome";
    private static final String EXPECTED_PRODUCT_NAME = "awestruck eels";

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
}
