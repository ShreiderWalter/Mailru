package com.bsu.vbabenya.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by walter on 20.12.15.
 */

public class LoginPage extends Page {
    private final String BASE_URL = "https://mail.ru/";

    @FindBy(id = "mailbox__login")
    private WebElement loginField;

    @FindBy(id = "mailbox__password")
    private WebElement passwordField;

    @FindBy(id = "mailbox__auth__button")
    private WebElement submitButton;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void checkPage() {
        driver.navigate().to(BASE_URL);
    }

    public void login(String userEmail, String password) {
        loginField.sendKeys(userEmail);
        passwordField.sendKeys(password);
        submitButton.click();
    }

}