package dev.playwright.tests.day_03;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;
import dev.playwright.tests.utils.TestBase;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _12_TraceViewer extends TestBase {

    @Test
    public void testName() {

        BrowserContext browserContext = browser.newContext();
        browserContext.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                        .setSnapshots(true)
                                .setSources(true)
        );

        Page newPage = browserContext.newPage();

        newPage.navigate("https://www.ebay.com/");
        newPage.getByPlaceholder("Search for anything").click();
        newPage.getByPlaceholder("Search for anything").fill("java");
        newPage.getByLabel("java fern").click();

        browserContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
    }
}
