package dev.playwright.tests.day_02;

import com.microsoft.playwright.Locator;
import dev.playwright.tests.utils.TestBase;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _06_Assertion extends TestBase {

    @Test
    public void testName() {

        newPage.navigate("https://www.ebay.com/");
        assertThat(newPage).hasURL("https://www.ebay.com/");
        assertThat(newPage).not().hasURL("error");
        assertThat(newPage).hasTitle("Electronics, Cars, Fashion, Collectibles & More | eBay");

        Locator signIn = newPage.getByText("Sign in").first();

        assertThat(signIn).hasText("Sign in");
        assertThat(signIn).containsText("Sign");

        Locator searchBox = newPage.getByPlaceholder("Search for anything");
        assertThat(searchBox).hasAttribute("autocomplete", "off");

        assertThat(searchBox).isVisible();
        assertThat(searchBox).isEmpty();
        assertThat(searchBox).isEditable();

        searchBox.fill("java");

        //assertThat(searchBox).isEmpty();


    }
}
