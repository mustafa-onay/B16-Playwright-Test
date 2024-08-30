package dev.playwright.tests.day_03;

import dev.playwright.tests.pages.HomePage;
import dev.playwright.tests.utils.TestBase;
import org.testng.annotations.Test;

public class _14_POM_Example extends TestBase {

    @Test
    public void test1() throws InterruptedException {

        HomePage homePage = new HomePage(page);

        page.navigate("https://www.ebay.com/");

        homePage.getSearchBox().fill("java");

        homePage.getSearchButton().click();

        Thread.sleep(2000);

    }
}
