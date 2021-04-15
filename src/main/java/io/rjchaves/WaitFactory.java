package io.rjchaves;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFactory {
    public static WebDriverWait build(WebDriver driver) {
        return new WebDriverWait(driver, 100);
    }
}
