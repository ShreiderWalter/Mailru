package com.bsu.vbabenya;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.bsu.vbabenya.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by walter on 20.12.15.
 */

public class MailRUTest {
    private Steps steps;
    private final String USER_EMAIL = "mailru.testing111@mail.ru";
    private final String PASSWORD = "test1111";

    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "Login to Mail.ru")
    public void oneCanLoginMailRU(){
        steps.loginMailRU(USER_EMAIL, PASSWORD);
    }

    @Test(dependsOnMethods = "oneCanLoginMailRU")
    public void isUserLoggedTest(){
        oneCanLoginMailRU();
        steps.isLoggedIn();
    }

    @Test(dependsOnMethods = "isUserLoggedTest")
    public void isMessageExistTest(){
        oneCanLoginMailRU();
        steps.isMessageExists();
    }

    @Test(dependsOnMethods = "isMessageExistTest")
    public void canWriteMessageTest(){
        oneCanLoginMailRU();
        steps.canWriteMessage();
    }

    @Test(dependsOnMethods = "canWriteMessageTest")
    public void hasValidContacts(){
        oneCanLoginMailRU();
        steps.ifContactExists();
    }
}