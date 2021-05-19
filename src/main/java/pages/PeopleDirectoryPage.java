package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PeopleDirectoryPage extends BasePage {

    public static final String TITLE_SOCIAL_MEDIA_HUB = "MIT - people directory";

    public PeopleDirectoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='query']")
    private WebElement searchField;

    @FindBy(xpath = "//form[@method='get']/input[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@value='phone']")
    private WebElement reverseLookupCheckbox;

    @FindBy(xpath = "//pre/a[@href]")
    private List<WebElement> allSearchResultItems;

    public void emptyFieldSearch() {
        searchButton.click();
        driver.switchTo().alert().accept();
    }

    public void chooseReverseLookupSearch() {
        reverseLookupCheckbox.click();
    }

    public void searchByValue(String value) {
        searchField.sendKeys(value);
        searchButton.click();
    }

    public int getSearchResultCount() {
        return allSearchResultItems.size();
    }

    public void activateNewTab() {
        handleMultipleWindows(TITLE_SOCIAL_MEDIA_HUB);
    }
}
