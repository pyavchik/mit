package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SocialMediaHubPage extends BasePage {

    public static final String IFRAME_SOCIAL_MEDIA_HUB = "stack-widget-embed-35491";
    public static final String TITLE_SOCIAL_MEDIA_HUB = "MIT Social Media Hub RSS";

    public SocialMediaHubPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='stackla-widget']")
    private WebElement widget;

    @FindBy(xpath = "//a[@class='load-more-action'][text()='LOAD MORE CONTENT']")
    private WebElement loadMoreContent;

    @FindBy(xpath = "//a[@class='load-more-action load-more-action-loading']")
    private WebElement loadingDiv;


    @FindBy(xpath = "//div[@class='tile shuffle-item shuffle-item--visible']")
    private List<WebElement> allWidgetItems;

    public void goToFrame() {
        handleMultipleWindows(TITLE_SOCIAL_MEDIA_HUB);
        switchToFrame(IFRAME_SOCIAL_MEDIA_HUB);
    }

    public int getElementsCount() {
        return allWidgetItems.size();
    }

    public SocialMediaHubPage loadMoreContent() {
        waitElementIsClickable(loadMoreContent).click();
        return this;
    }
}
