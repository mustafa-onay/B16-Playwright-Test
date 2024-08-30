package dev.playwright.tests.day_01;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import dev.playwright.tests.utils.TestBase;
import org.testng.annotations.Test;

public class _03_Locators extends TestBase {

    @Test
    public void test1() throws InterruptedException {

        page.navigate("https://www.kitapyurdu.com/");

        //getByText
        Locator cartEmpty = page.getByText("Sepetiniz boş");
        System.out.println("signInOrSignUp.innerText() = " + cartEmpty.innerText());

        //h5[text()='Sepetiniz boş'] --> xpath --> so haben wir in Selenium locators erstellt

        //getByRole
        Locator searchBoxByRole = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("kitap adı, yazar veya yayınevi ara"));
        searchBoxByRole.fill("java");
        System.out.println("searchBoxByRole.inputValue = " + searchBoxByRole.inputValue());
        System.out.println("searchBoxByRole.getAttribute(\"name\") = " + searchBoxByRole.getAttribute("name"));
        Thread.sleep(2000);

        Locator searchBoxByPlaceholder = page.getByPlaceholder("kitap adı, yazar veya yayınevi ara");

        searchBoxByPlaceholder.clear();

        //text wird langsam eingegeben
        searchBoxByPlaceholder.pressSequentially("Monte Kristo Kontu", new Locator.PressSequentiallyOptions().setDelay(300));

        searchBoxByPlaceholder.clear();

        //getByLabel
        Locator slide8ByLabel = page.getByLabel("Go to slide 8").last();

        slide8ByLabel.click();
    }

    @Test
    public void test2() throws InterruptedException {

        page.navigate("https://www.kitapyurdu.com/");
        //getByLabel
        Locator slide8ByLabel = page.getByLabel("Go to slide 8").last();

        slide8ByLabel.click();

        Thread.sleep(2000);

        Locator paranınSosyalYaşamı = page.getByAltText("Paranın Sosyal Yaşamı").last();

        paranınSosyalYaşamı.click();
        Thread.sleep(3000);
    }

    @Test
    public void test3() throws InterruptedException {
        page.navigate("https://www.yemeksepeti.com/");

        Locator textBoxByPlaceholder = page.getByPlaceholder("Örneğin: Esentepe Dede Korkut Sk. No:28/1");

        textBoxByPlaceholder.fill("istanbul");

        Locator kesfetByTestId = page.getByTestId("homepage_cta");

        kesfetByTestId.click();
        Thread.sleep(2000);
    }

    @Test
    public void test4() throws InterruptedException {

        page.navigate("https://www.idefix.com/");

        //ByFilter
        Locator elektronikByFilter = page.locator("a.text-center").filter(new Locator.FilterOptions().setHasText("Elektronik"));

        elektronikByFilter.click();
        Thread.sleep(2000);

    }
}
