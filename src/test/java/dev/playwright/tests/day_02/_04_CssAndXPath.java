package dev.playwright.tests.day_02;

import com.microsoft.playwright.Locator;
import dev.playwright.tests.utils.TestBase;
import org.testng.annotations.Test;

public class _04_CssAndXPath extends TestBase {

    @Test
    public void test1() {

        newPage.navigate("https://rahulshettyacademy.com/AutomationPractice/");

        Locator textLocator = newPage.locator("text=Element Displayed Example");
        System.out.println("textLocator.innerText() = " + textLocator.innerText());

        Locator practiceHasText = newPage.locator("h1:has-text(' practice  ')");

        System.out.println("practiceHasText.innerText() = " + practiceHasText.innerText());

        Locator textSwitchTab = newPage.locator("legend:text('     switch tab    ')");
        System.out.println("textSwitchTab.innerText() = " + textSwitchTab.innerText());

        Locator caseSensitive = newPage.locator(":text-is('   Suggession Class Example   ')");
        System.out.println("caseSensitive.innerText() = " + caseSensitive.innerText());

        Locator nthMatch = newPage.locator(":nth-match(:has-text('practice'),3)");
        System.out.println("nthMatch.innerText() = " + nthMatch.innerText());

        Locator xpath = newPage.locator("//legend[text()='Switch To Alert Example']");
        System.out.println("xpath.innerText() = " + xpath.innerText());
    }
}
