package com.example.spock

import com.example.common.page.GoogleSearchPage
import geb.spock.GebSpec

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

class GoogleSearchSpec extends GebSpec {

    def "should returns correct result"() {

        given: "user has access to Google Search"
            to GoogleSearchPage

        when: "user search for 'Google Headquarters'"
            searchInput = "Google Headquarters"
            searchBtn().click()

        then: "search returns with an expanded box"
            waitFor { expandDiv }
            assertNotNull expandDiv

        and: "location is showing as 'Mountain View, California, United States'"
            assertEquals "Mountain View, California, United States", locationDivText
    }

}
