package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    private final String filePath = "src/test/data/config/configuration.properties";

    @BeforeMethod
    public void setUp(){
        initializeDriver(ConfigReader.readProperty(filePath, "browser"));
        driver.get(ConfigReader.readProperty(filePath, "url"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public void initializeDriver(String browser){
        driver = null;
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("Wrong browser name was entered");
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver(){
        return driver;
    }

//    public void multiWindow(String[] args) throws InterruptedException {
//        // open a website
//        driver.get("https://weather.com");
//
//        String currentWindow = driver.getWindowHandle();
//        System.out.println(currentWindow);
//
//        //capturing IDs of all open windows
//        Set<String> allWindows = driver.getWindowHandles();
//
//        //switch to second window
//        for (String eachWindow : allWindows) {
//            if (!eachWindow.equals(currentWindow)) {
//                driver.switchTo().window(eachWindow);
//            }
//        }
//        System.out.println(driver.getTitle());
//    }

    }