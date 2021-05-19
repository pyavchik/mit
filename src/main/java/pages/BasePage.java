package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static utils.constants.Constant.TimeoutVariables.EXPLICIT_WAIT;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for navigating to a specific URL
     *
     * @param url
     */
    public void goToUrl(String url) {
        driver.get(url);
    }

    /**
     * Wait for element to be clickable in DOM model
     *
     * @param element
     * @return
     */
    public WebElement waitElementIsClickable(WebElement element) {
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.elementToBeClickable(element));
        if (element.isDisplayed()) {
            return element;
        }
        throw new RuntimeException("There is no element " + element);
    }

    /**
     * Method for navigating to a specific window
     *
     * @param windowTitle
     */
    public void handleMultipleWindows(String windowTitle) {
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getTitle().contains(windowTitle)) {
                return;
            }
        }
    }

    /**
     * Method for navigating to a specific frame
     *
     * @param frame
     */
    public void switchToFrame(String frame) {
        driver.switchTo().frame(frame);
    }

    /**
     * Method for closing page
     */
    public void closePage() {
        driver.close();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
        }
    }
}
