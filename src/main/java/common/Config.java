package common;

public class Config {
    public static String getBrowserAndPlatform() {

        String browser = System.getProperty("browser");

        if (browser == null) {
            return "CHROME_MAC";
        }

        if (browser.equalsIgnoreCase("CHROME_MAC")) {
            return "CHROME_MAC";
        } else if (browser.equalsIgnoreCase("CHROME_WINDOWS")) {
            return "CHROME_WINDOWS";
        } else {
            return "CHROME_MAC";
        }

    }

    public static final String BROWSER_AND_PLATFORM = getBrowserAndPlatform();

}
