package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.constants.Constant;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='http://socialmediahub.mit.edu/']")
    private WebElement socialMediaHubLink;

    @FindBy(xpath = "//a[@href='http://web.mit.edu/people.html']")
    private WebElement peopleLink;

    @FindBy(xpath = "//a[@href='http://calendar.mit.edu/']")
    private WebElement eventsLink;

    public MainPage openPage() {
        goToUrl(Constant.Urls.BASE_URL);
        return this;
    }

    public SocialMediaHubPage clickSocialMediaHubLink() {
        socialMediaHubLink.click();
        return new SocialMediaHubPage(driver);
    }

    public PeopleDirectoryPage clickPeopleLink() {
        peopleLink.click();
        return new PeopleDirectoryPage(driver);
    }

    public EventsCalendarPage clickEventsLink() {
        eventsLink.click();
        return new EventsCalendarPage(driver);
    }
}
