package tests;

import base.BasePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends BaseTest {
    HomePage homePage;
    BasePage basePage;

    @BeforeMethod
    public void localSetUp() {
        homePage = new HomePage(getDriver());
    }

    @Test(testName = "IN-1 - pop-up window", description = "print out message")
    public void test01() {

        System.out.println(homePage.popupWindow.getText());
        homePage.closeBtn.click();

    }

    @Test(testName = "IN-2 social media titles", description = "printing out titles")
    public void test02() {

        homePage.facebookLink.click();
        System.out.println(getDriver().getTitle());

       // homePage.twitterLink.click();
       // System.out.println(getDriver().getTitle());

       // homePage.youtubeLink.click();
       // System.out.println(getDriver().getTitle());

    }

}
