package com.bsu.vbabenya.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by walter on 20.12.15.
 */

public class MainPage extends Page{
    private final String BASE_URL = "https://mail.ru/";

    @FindBy(xpath = "//div[@class='b-datalist__item__addr']")
    private WebElement messages;

    @FindBy(xpath = "//div[@class='b-toolbar__item']")
    private WebElement writeButton;

    @FindBy(id = "PH_user-email")
    private WebElement userNameframe;

    @FindBy(xpath = "//span[@class='js-text-inner pm-toolbar__button__text__inner  pm-toolbar__button__text__inner_noicon']")
    private WebElement contact;

    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void checkPage(){
        if(!driver.getCurrentUrl().contains(BASE_URL))
        {
            throw new IllegalStateException();
        }
    }

    public WebElement getUserNameframe() {
        return userNameframe;
    }

    public WebElement getMessages() {
        return messages;
    }

    public WebElement getWriteButton() {
        return writeButton;
    }

    public WebElement getContact() {
        return contact;
    }

}