package dev.playwright.tests.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;

    private Locator searchBox;

    private Locator searchButton;

    public HomePage(Page page) {
        this.page = page;
        this.searchBox = page.getByPlaceholder("Search for anything");
        this.searchButton = page.locator("#gh-btn");
    }

    public Locator getSearchBox() {
        return searchBox;
    }

    public Locator getSearchButton() {
        return searchButton;
    }
}
