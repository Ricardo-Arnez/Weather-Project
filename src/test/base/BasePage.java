package base;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElementClickability(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void moveIntoView(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void multiWindow() throws InterruptedException {
        // open a website
        driver.get("https://weather.com");

        //print out 3 button names
        List<WebElement> links = driver.findElements(By.xpath("//ul[@locale='en-US']"));

        links.get(0).click();
        switchToNextWindow(driver);
        System.out.println(driver.getTitle());

        //capturing GUID of main window
        String mainWindowID = driver.getWindowHandle();

        switchToNextWindow(driver);

        //switch back to main window
        driver.switchTo().window(mainWindowID);

        //open facebook
        links.get(1).click();
        switchToNextWindow(driver);
        System.out.println(driver.getTitle());

        //switching back to main window
        driver.switchTo().window(mainWindowID);

        //open TLA page
        links.get(3).click();
        switchToNextWindow(driver);
        System.out.println(driver.getTitle());

    }
    public static void switchToNextWindow(WebDriver driver) {
        //capturing GUID of main window
        String mainWindowID = driver.getWindowHandle();

        //capturing GUID of all windows
        Set<String> allWindows = driver.getWindowHandles();

        //switching driver to next window
        for (String each : allWindows) {
            if (!each.equals(mainWindowID))
                driver.switchTo().window(each);
        }
    }
}
