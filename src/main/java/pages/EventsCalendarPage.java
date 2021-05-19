package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;

import static utils.DateUtils.getLocalDate;

public class EventsCalendarPage extends BasePage {
    private static final String TITLE_EVENTS_CALENDAR = "Events Calendar - MIT Events";

    public EventsCalendarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[@class='today active selected']//span[@class='sr-only']")
    private WebElement selectedDate;

    @FindBy(xpath = "//ul[@id='x-event_types']//li[@data-count][not(contains(@style,'display:none;'))]")
    private List<WebElement> listEventTypesLink;

    @FindBy(id = "previous-number")
    private WebElement previousPaginationBtn;

    @FindBy(id = "next-number")
    private WebElement nextPaginationBtn;

    @FindBy(xpath = "//td[contains(@class, 'selected')]")
    private WebElement highlightedDate;

    @FindBy(xpath = "//ul[@id='x-event_types']//a[contains(text(),'Conferences/Seminars/Lectures')]")
    private WebElement conferenceSeminarsLecturesLink;

    @FindBy(xpath = "//div[@class='item event_item vevent']")
    private List<WebElement> filteredListEventsResult;

    @FindBy(xpath = "//fieldset[@id='x-list-event_types']//li[@class='em-link em-show-more']/a")
    private WebElement allTypesShowMore;

    public String getSelectedCalendarDate() {
        return selectedDate.getText().split(" has events")[0].toUpperCase(Locale.ROOT);
    }

    public void clickFirstEventTypesLink() {
        listEventTypesLink.get(0).click();
    }

    public void previousPaginationClick() {
        previousPaginationBtn.click();
    }

    public void nextPaginationClick() {
        nextPaginationBtn.click();
    }

    public String getHighlightedDate() {
        return highlightedDate.getText();
    }

    public void pickDateAfterDaysCount(int days) {
        handleMultipleWindows("Events Calendar - MIT Events ");
        driver.findElement(By.xpath("//tbody[@data-minicalendar='calendar']//a[contains(text(),'" + getLocalDate().plusDays(days).getDayOfMonth() + "')]/parent::td"))
                .click();
    }

    public String getCountConferenceSeminarsLecturesCountFromBrackets() {
        allTypesShowMore.click();
        return conferenceSeminarsLecturesLink.getText().split("Conferences/Seminars/Lectures \\(")[1].split("\\)")[0];
    }

    public String getCountConfirenceSeminarsLecturesCountFromFilterResult() {
        conferenceSeminarsLecturesLink.click();
        return String.valueOf(filteredListEventsResult.size());
    }

    public void activateNewTab() {
        handleMultipleWindows(TITLE_EVENTS_CALENDAR);
    }
}
