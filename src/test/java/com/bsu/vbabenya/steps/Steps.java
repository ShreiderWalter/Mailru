package com.bsu.vbabenya.steps;

import com.bsu.vbabenya.pages.LoginPage;
import com.bsu.vbabenya.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by walter on 20.12.15.
 */

public class Steps {
    private final String BASE_URL = "https://e.mail.ru/messages/inbox/?back=1";
    private final String MESSAGE_URL = "https://e.mail.ru/compose/?*";
    private final String CONTACTS_URL = "https://e.mail.ru/addressbook";
    private final Logger logger = Logger.getLogger(Steps.class);
    private WebDriver driver;

    public void initBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logger.info("Browser started");
    }

    public void closeDriver(){
        driver.quit();
        logger.info("Browser stoped");
    }

    public void loginMailRU(String email, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkPage();
        loginPage.login(email,password);
        logger.info("Login mail.ru");
        Assert.assertTrue(driver.getCurrentUrl().equals(BASE_URL));
    }

    public void isLoggedIn()
    {
        MainPage homePage = new MainPage(driver);
        Assert.assertTrue(homePage.getUserNameframe().isEnabled() && homePage.getUserNameframe().isDisplayed(), "Login failed");
    }

    public void isMessageExists(){
        MainPage homePage = new MainPage(driver);
        Assert.assertTrue(homePage.getMessages().isEnabled() && homePage.getMessages().isDisplayed(), "Message doesnt exist");
    }

    public void canWriteMessage(){
        MainPage homePage = new MainPage(driver);
        homePage.getWriteButton().click();
    }

    public void ifContactExists(){
        MainPage homePage = new MainPage(driver);
        homePage.getContact().click();
        Assert.assertTrue(driver.getCurrentUrl().equals(CONTACTS_URL));
    }
}