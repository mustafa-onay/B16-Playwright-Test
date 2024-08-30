package dev.playwright.tests.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.awt.*;

public class TestBase {

    protected Playwright playwright;
    protected Browser browser;
    protected Page newPage;

    @BeforeMethod
    public void setUp(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        newPage = browser.newPage();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        newPage.setViewportSize(width,height);
    }

    @AfterMethod
    public void tearDown(){
        newPage.close();
        browser.close();
        playwright.close();
    }




}
