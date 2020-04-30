package net.jakim.testing.pages;

import org.openqa.selenium.By;

public class LoginForm
{
    public final static By USERNAME_FIELD = By.name( "map(username)" );
    public final static By PASSWORD_FIELD = By.name( "map(password)" );
    public final static By LOGIN_BUTTON = By.cssSelector( "button[title='Login']" );
}
