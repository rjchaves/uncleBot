package io.rjchaves;

import io.rjchaves.login.LoginController;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.quartz.SchedulerException;

public class App 
{
    public static void main( String[] args ) throws SchedulerException {
        WebDriver webDriver = new FirefoxDriver();
        var loginPage = new LoginPage(webDriver, "https://www.the-west.com.br/");
        var loginController = new LoginController(loginPage, "angrymouse", "senhauenha", 20);
        loginController.login();
    }
}
