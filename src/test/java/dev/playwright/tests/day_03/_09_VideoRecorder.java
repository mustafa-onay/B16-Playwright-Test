package dev.playwright.tests.day_03;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import dev.playwright.tests.utils.TestBase;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class _09_VideoRecorder extends TestBase {

    @Test
    public void test1() throws InterruptedException {

        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String videoPath = System.getProperty("user.dir") + "/src/test/resources/videos/" + date;

        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get(videoPath)));

        Page newPage = browserContext.newPage();
        newPage.navigate("https://www.ebay.com/");

        Locator searchBox = newPage.getByPlaceholder("Search for anything");
        searchBox.fill("java");
        searchBox.press("Enter");

        Thread.sleep(2000);
    }
}
