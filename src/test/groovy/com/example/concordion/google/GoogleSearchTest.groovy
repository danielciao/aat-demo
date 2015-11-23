package com.example.concordion.google

import com.example.common.page.GoogleSearchPage
import com.example.concordion.support.SeleniumScreenshotTaker
import geb.Browser
import org.concordion.api.ExpectedToFail
import org.concordion.api.extension.ConcordionExtension
import org.concordion.api.extension.Extension
import org.concordion.ext.ScreenshotExtension
import org.concordion.ext.ScreenshotTaker
import org.concordion.integration.junit4.ConcordionRunner
import org.junit.BeforeClass
import org.junit.runner.RunWith

@RunWith(ConcordionRunner.class)
@ExpectedToFail
class GoogleSearchTest {

    @Extension
    public static ConcordionExtension extension

    @BeforeClass
    public static void init() {
        Browser.drive() {
            ScreenshotTaker screenshotTaker = new SeleniumScreenshotTaker(driver)
            extension = new ScreenshotExtension().setScreenshotTaker(screenshotTaker)
        }
    }

    def search(String searchTerm) {
        def result = [:]

        Browser.drive() {
            to GoogleSearchPage

            searchInput = searchTerm
            searchBtn().click()

            waitFor { expandDiv }

            result = [
                expandBoxDisplayed: expandDiv != null,
                location          : locationDivText
            ]
        }

        result
    }
}
