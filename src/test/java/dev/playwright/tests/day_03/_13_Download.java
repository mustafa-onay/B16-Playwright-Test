package dev.playwright.tests.day_03;

import com.microsoft.playwright.Download;
import dev.playwright.tests.utils.TestBase;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class _13_Download extends TestBase {

    @Test
    public void testName() {

        page.navigate("https://demoqa.com/upload-download");

        Download download = page.waitForDownload(()->{
            page.getByText("Download").last().click();
        });

        String filePath = System.getProperty("user.home") + "/Downloads/file.jpeg";

        download.saveAs(Paths.get(filePath));

        System.out.println("download.path() = " + download.path());
        System.out.println("download.url() = " + download.url());
        System.out.println("download.page().title() = " + download.page().title());

        boolean isFileDownloaded = Files.exists(Paths.get(filePath));
        System.out.println("isFileDownloaded = " + isFileDownloaded);
        assert isFileDownloaded;


    }
}
