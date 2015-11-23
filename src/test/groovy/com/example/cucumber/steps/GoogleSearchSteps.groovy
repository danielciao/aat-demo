package com.example.cucumber.steps

import com.example.common.page.GoogleSearchPage

import static cucumber.api.groovy.EN.*
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue

Given(~/^user has access to Google Search$/) { ->
    // Write code here that turns the phrase above into concrete actions
}

When(~/^user search for "([^"]*)"$/) { String searchTerm ->
    to GoogleSearchPage

    page.searchInput = searchTerm
    page.searchBtn().click()
}

Then(~/^search returns with an expanded box$/) { ->
    waitFor { page.expandDiv }

    assertTrue page.expandDiv != null
}

And(~/^location is showing as "([^"]*)"$/) { String expectedLocation ->
    assertEquals expectedLocation, page.locationDivText
}