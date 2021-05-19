package tests;

import org.junit.jupiter.api.*;
import pages.EventsCalendarPage;
import pages.MainPage;
import pages.PeopleDirectoryPage;
import pages.SocialMediaHubPage;
import tests.base.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.DateUtils.getCurrentDate;
import static utils.DateUtils.getLocalDate;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MitTest extends BaseTest {
    protected SocialMediaHubPage socialMediaHubPage = new SocialMediaHubPage(driver);
    protected MainPage mainPage = new MainPage(driver);
    protected PeopleDirectoryPage peopleDirectoryPage = new PeopleDirectoryPage(driver);
    protected EventsCalendarPage eventsCalendarPage = new EventsCalendarPage(driver);

    @Test()
    @Order(1)
    public void checkWidgetElementsCount() {
        mainPage.openPage()
                .clickSocialMediaHubLink();
        socialMediaHubPage.goToFrame();
        System.out.println("Social media elements count: " + socialMediaHubPage.getElementsCount());

        socialMediaHubPage.loadMoreContent();
        socialMediaHubPage.goToFrame();
        System.out.println("Social media elements count after loading more content: " + socialMediaHubPage.getElementsCount());

        socialMediaHubPage.closePage();
    }

    @Test()
    @Order(2)
    public void checkPeopleSearchCount() {
        mainPage.openPage().clickPeopleLink();
        peopleDirectoryPage.activateNewTab();
        peopleDirectoryPage.emptyFieldSearch();
        peopleDirectoryPage.chooseReverseLookupSearch();
        peopleDirectoryPage.searchByValue("617-253-1212");
        System.out.println("People search result: " + peopleDirectoryPage.getSearchResultCount());

        peopleDirectoryPage.closePage();
    }

    @Test()
    @Order(3)
    public void checkEvents() {
        mainPage.openPage().clickEventsLink();
        eventsCalendarPage.activateNewTab();
        assertEquals(getCurrentDate(), eventsCalendarPage.getSelectedCalendarDate());

        eventsCalendarPage.clickFirstEventTypesLink();
        eventsCalendarPage.previousPaginationClick();
        assertEquals(String.valueOf(getLocalDate().minusDays(1).getDayOfMonth()), eventsCalendarPage.getHighlightedDate());

        eventsCalendarPage.nextPaginationClick();
        assertEquals(String.valueOf(getLocalDate().getDayOfMonth()), eventsCalendarPage.getHighlightedDate());
    }

    @Test()
    @Order(4)
    public void checkFilters() {
        mainPage.openPage()
                .clickEventsLink();
        eventsCalendarPage.pickDateAfterDaysCount(5);
        assertEquals(
                eventsCalendarPage.getCountConferenceSeminarsLecturesCountFromBrackets(),
                eventsCalendarPage.getCountConfirenceSeminarsLecturesCountFromFilterResult()
        );
    }

}
