package dev.playwright.tests.day_02;

import dev.playwright.tests.utils.TestBase;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class _07_Actions extends TestBase {

    @Test
    public void keyboardAndScroll() throws InterruptedException {

        newPage.navigate("https://www.ebay.com/");
        Locator searchBox = newPage.getByPlaceholder("Search for anything");
        searchBox.fill("java");
        searchBox.press("Enter");
        Thread.sleep(3000);

        newPage.keyboard().press("End");

        Thread.sleep(3000);

        newPage.getByText("Sold Items").scrollIntoViewIfNeeded();

        Thread.sleep(3000);

    }

    @Test
    public void checkBoxAndRadioButtons() throws InterruptedException {

        newPage.navigate("https://demoqa.com/radio-button");

        Locator yes = newPage.getByText("Yes");
        Locator impressive = newPage.getByText("Impressive");
        yes.check();
        //yes.isChecked();

        Thread.sleep(3000);

        impressive.setChecked(true);
        //impressive.isChecked();

        Thread.sleep(3000);

        Locator no = newPage.getByText("No");
        no.isDisabled();

    }

    @Test
    public void dropdown() throws InterruptedException {

        newPage.navigate("https://www.ebay.com/");

        Locator dropdown = newPage.locator("#gh-cat");

        dropdown.selectOption("Art");

        dropdown.selectOption(new String[]{"Baby", "Crafts", "Music"});

        Thread.sleep(2000);

        dropdown.selectOption(new SelectOption().setIndex(5));

        Locator motors = newPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Motors"));
        motors.hover(new Locator.HoverOptions().setForce(true));
        Thread.sleep(2000);


        Locator searchButton = newPage.locator("#gh-btn");
        searchButton.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));

        Thread.sleep(2000);

    }

    @Test
    public void dragAndDrop() throws InterruptedException {

        newPage.navigate("https://demoqa.com/droppable");
        newPage.locator("#draggable").dragTo(newPage.locator("#droppable").first());

        BrowserContext browserContext = browser.newContext();
        Page newPage = browserContext.newPage();

        newPage.navigate("https://demoqa.com/upload-download");


        Locator upload = newPage.locator("#uploadFile");
        upload.setInputFiles(Paths.get("C:\\Users\\peace\\Desktop\\exp photo.jpg"));
        Thread.sleep(2000);
    }
}
