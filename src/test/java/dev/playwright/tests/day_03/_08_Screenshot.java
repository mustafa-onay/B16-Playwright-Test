package dev.playwright.tests.day_03;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import dev.playwright.tests.utils.TestBase;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class _08_Screenshot extends TestBase {

    @Test
    public void test1() {

        page.navigate("https://www.ebay.com/");

        String date = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath = "src/test/resources/screenshots/" + date + ".png";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(filePath)));

        // hardcoding
//        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/testFP.png")).setFullPage(true));

//        Locator searchBtn = page.locator("#gh-btn");
//        searchBtn.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("screenshots/testElement.png")));

    }
}
