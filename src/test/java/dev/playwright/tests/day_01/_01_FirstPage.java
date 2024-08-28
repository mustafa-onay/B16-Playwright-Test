package dev.playwright.tests.day_01;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_FirstPage {


    @Test
    public void firstPageTest(){

        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium(); //firefox
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        Page page = browser.newPage();

        page.navigate("http://www.google.com");

        String title = page.title();

        Assert.assertEquals(title,"Google");

        System.out.println("title = " + title);

        page.close();
        browser.close();
        playwright.close();
    }
}
