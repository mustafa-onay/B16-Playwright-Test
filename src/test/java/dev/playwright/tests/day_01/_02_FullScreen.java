package dev.playwright.tests.day_01;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import java.awt.*;

public class _02_FullScreen {

    @Test
    public void fullScreenTest() throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        Page page = browser.newPage();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        System.out.println("width = " + width);
        System.out.println("height = " + height);

        page.setViewportSize(width,height);

        page.navigate("https://whatismyviewport.com/");

        Thread.sleep(3000);

        page.close();
        browser.close();
        playwright.close();

    }
}
