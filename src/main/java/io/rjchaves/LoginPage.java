package io.rjchaves;

import io.rjchaves.login.Loggable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;

public class LoginPage implements Loggable{
    private final WebDriver webDriver;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "userpassword")
    private WebElement password;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    private final WorldSelectorScreen worldSelectorScreen;


    public LoginPage(WebDriver webDriver, String baseUrl) {
        this.webDriver = webDriver;
        this.worldSelectorScreen = new WorldSelectorScreen(webDriver);
        webDriver.get(baseUrl);
        PageFactory.initElements(webDriver, this);
    }


    @Override
    public void fillUser(String user) {
        this.username.sendKeys(user);
    }

    @Override
    public void fillPassword(String password) {
        this.password.sendKeys(password);
    }

    @Override
    public void pressButton() {
        this.loginButton.click();
    }

    @Override
    public void selectWorld(Integer world) {
        this.worldSelectorScreen.click(world);
    }
}
