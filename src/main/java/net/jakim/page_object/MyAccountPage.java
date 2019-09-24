package net.jakim.page_object;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl( "/index.php?controller=my-account" )
public class MyAccountPage extends PageObject
{
    @FindBy( className = "info-account" )
    public WebElementFacade infoAccountText;

}
