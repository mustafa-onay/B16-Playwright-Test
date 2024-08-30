package dev.playwright.tests.day_02;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import dev.playwright.tests.utils.TestBase;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _06_Assertion extends TestBase {

    @Test
    public void testName() {

        page.navigate("https://www.ebay.com/");
        assertThat(page).hasURL("https://www.ebay.com/");
        assertThat(page).not().hasURL("error");
        assertThat(page).hasTitle("Electronics, Cars, Fashion, Collectibles & More | eBay");

        Locator signIn = page.getByText("Sign in").first();

        assertThat(signIn).hasText("Sign in");
        assertThat(signIn).containsText("Sign");

        Locator searchBox = page.getByPlaceholder("Search for anything");
        assertThat(searchBox).hasAttribute("autocomplete", "off");

        assertThat(searchBox).isVisible();
        assertThat(searchBox).isEmpty();
        assertThat(searchBox).isEditable();

        searchBox.fill("java");

        //assertThat(searchBox).isEmpty();


    }
}
