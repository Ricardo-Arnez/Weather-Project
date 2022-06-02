package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='PrivacyDataNotice--notice--5SUaf']")
    public WebElement popupWindow;

    @FindBy(xpath = "//*[starts-with(@d,'M19.707')][1]")
    public WebElement closeBtn;

    @FindBy(name = "facebook")
    public WebElement facebookLink;

    @FindBy(xpath = "//*[@name='twitter']")
    public WebElement twitterLink;

    @FindBy(xpath = "//*[@name='youtube']")
    public WebElement youtubeLink;

}
