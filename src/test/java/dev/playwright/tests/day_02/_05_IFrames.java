package dev.playwright.tests.day_02;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import dev.playwright.tests.utils.TestBase;
import org.testng.annotations.Test;

public class _05_IFrames extends TestBase {

    @Test
    public void test1() {

        newPage.navigate("https://the-internet.herokuapp.com/nested_frames");
        Frame frame = newPage.frame("frame-left");

        Locator lastElement = frame.locator(":has-text('Left')").last();
        System.out.println("lastElement.innerText() = " + lastElement.innerText());

        System.out.println("page.url() = " + newPage.url());

        for (Frame eachFrame: newPage.frames()){
            System.out.println("eachFrame.url() = " + eachFrame.url());
        }

        Frame rightFrame = newPage.frameByUrl("https://the-internet.herokuapp.com/frame_right");
        Locator rightElement = rightFrame.locator(":has-text('Right')").last();
        System.out.println("rightElement.innerText() = " + rightElement.innerText());
    }

    @Test
    public void test2() {

        newPage.navigate("https://demoqa.com/frames");

        FrameLocator frameLocator = newPage.frameLocator("#frame1");
        Locator locator = frameLocator.locator("#sampleHeading");
        System.out.println("locator.innerText() = " + locator.innerText());


    }
}
