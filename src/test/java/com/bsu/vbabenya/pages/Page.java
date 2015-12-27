package com.bsu.vbabenya.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by walter on 20.12.15.
 */

public abstract class Page {
    protected WebDriver driver;

    public abstract void checkPage();

    public Page(WebDriver driver)
    {
        this.driver = driver;
    }
}