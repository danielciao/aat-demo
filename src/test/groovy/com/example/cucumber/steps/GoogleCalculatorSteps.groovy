package com.example.cucumber.steps

import com.example.common.page.GoogleCalculatorPage
import com.example.common.page.GoogleSearchPage

import static cucumber.api.groovy.EN.*
import static org.junit.Assert.assertEquals

Given(~/^user has access to Google Calculator$/) { ->
    to GoogleSearchPage

    page.searchInput = 'calc'
    page.searchBtn().click()

    at GoogleCalculatorPage
}

When(~/^user input "([^"]*)", "([^"]*)", "([^"]*)"$/) { String firstOperand, String operator, String secondOperand ->
    page.numberBtn(firstOperand).click()
    page.operatorBtn(operator).click()
    page.numberBtn(secondOperand).click()

    page.equalsBtn.click()
}

Then(~/^result "([^"]*)" is displayed$/) { String expectedResult ->
    assertEquals expectedResult, page.totalOutput.text()
}