package tests.base;

import common.SetupActions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver = SetupActions.createDriver();

    @AfterAll
    void close() {
        driver.quit();
    }

}
