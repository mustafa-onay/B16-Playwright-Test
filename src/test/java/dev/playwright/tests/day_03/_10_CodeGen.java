package dev.playwright.tests.day_03;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import dev.playwright.tests.utils.TestBase;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _10_CodeGen extends TestBase {

    @Test
    void test() {

        newPage.navigate("https://www.ebay.com/");
        newPage.getByPlaceholder("Search for anything").click();
        newPage.getByPlaceholder("Search for anything").fill("java");
        newPage.getByLabel("java fern").click();
        Page page1 = newPage.waitForPopup(() -> {
            newPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("BUY 2 GET 1 FREE - Java Fern Microsorum Pteropus Small Easy Live Aquarium Plant")).nth(1).click();
        });

        assertThat(page1).hasTitle("BUY 2 GET 1 FREE - Java Fern Microsorum Pteropus Small Easy Live Aquarium Plant  | eBay");

    }
}
