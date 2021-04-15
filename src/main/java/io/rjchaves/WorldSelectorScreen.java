package io.rjchaves;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorldSelectorScreen {

    private final WebDriver webDriver;

    public WorldSelectorScreen(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void click(Integer world) {
        var worldSelector = By.cssSelector("#world_"+world + " > a");
        waitElements(worldSelector);
        webDriver.findElement(worldSelector).click();
    }

    private void waitElements(By worldSelector) {
        WebDriverWait waiter = WaitFactory.build(webDriver);
        waiter.until(ExpectedConditions.presenceOfElementLocated(worldSelector));
        waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(worldSelector));
    }
}
