package steps_libraries;

import net.thucydides.core.annotations.Step;

public class DemoShopper
{
    @Step( "searches for items starting with '{0}' in the catalog" )
    public DemoShopper searchesFor( String partName )
    {
        return this;
    }

    @Step( "selects the first {0} for the catalog search results" )
    public DemoShopper selectsItems( int itemsNumber )
    {
        return this;
    }

    @Step( "adds the secelted items to user's basket" )
    public DemoShopper addsSelectedItemsToTheBasket()
    {
        return this;
    }

    public DemoShopper and()
    {
        return this;
    }

    @Step( "purchases the basket items and complete the order" )
    public DemoShopper placesOrder()
    {
        return this;
    }

    public DemoShopper seesSuccessfulMessage( String message )
    {
        return this;
    }

    public DemoShopper seesHisAccountBallanceHasUpdated()
    {
        return this;
    }

    @Step( "refunds with message\n {0}")
    public void refundsOrder( String message)
    {
    }
}
