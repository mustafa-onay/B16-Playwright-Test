package dev.playwright.tests.day_02;

import com.microsoft.playwright.Locator;
import dev.playwright.tests.utils.TestBase;
import org.testng.annotations.Test;

public class _04_CssAndXPath extends TestBase {

    @Test
    public void test1() {

        page.navigate("https://rahulshettyacademy.com/AutomationPractice/");

        Locator textLocator = page.locator("text=Element Displayed Example");
        System.out.println("textLocator.innerText() = " + textLocator.innerText());

        Locator practiceHasText = page.locator("h1:has-text(' practice  ')");

        System.out.println("practiceHasText.innerText() = " + practiceHasText.innerText());

        Locator textSwitchTab = page.locator("legend:text('     switch tab    ')");
        System.out.println("textSwitchTab.innerText() = " + textSwitchTab.innerText());

        Locator caseSensitive = page.locator(":text-is('   Suggession Class Example   ')");
        System.out.println("caseSensitive.innerText() = " + caseSensitive.innerText());

        Locator nthMatch = page.locator(":nth-match(:has-text('practice'),3)");
        System.out.println("nthMatch.innerText() = " + nthMatch.innerText());

        Locator xpath = page.locator("//legend[text()='Switch To Alert Example']");
        System.out.println("xpath.innerText() = " + xpath.innerText());
    }
}
