package steps_libraries;


import net.thucydides.core.annotations.Step;

public class DemoNavigations
{


    public DemoNavigations logsIn()
    {

        return logsIn( "Gosho",
                       "Hdsf$weGD5" );
    }

    @Step( "A registered user logs in with user/pass {0}{1}" )
    public DemoNavigations logsIn( String username,
                                   String pass )
    {
        return this;
    }

    @Step
    public DemoNavigations opensPage(String p){
        return this;
    }

    public DemoNavigations and()
    {
        return this;
    }

    @Step
    public DemoNavigations ordersWithRest()
    {
        return this;
    }
}
