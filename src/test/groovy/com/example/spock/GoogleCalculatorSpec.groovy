package com.example.spock

import com.example.common.page.GoogleCalculatorPage
import com.example.common.page.GoogleSearchPage
import geb.spock.GebSpec
import spock.lang.Unroll

import static org.junit.Assert.assertEquals

class GoogleCalculatorSpec extends GebSpec {

    @Unroll
    def "should display correct result"() {

        given: "user has access to Google Calculator"
            to GoogleSearchPage

            searchInput = 'calc'
            searchBtn().click()

            at GoogleCalculatorPage

        when: "user input following numbers and operators"
            numberBtn(firstOperand).click()
            operatorBtn(operator).click()
            numberBtn(secondOperand).click()

            equalsBtn.click()

        then: "correct result is displayed"
            assertEquals result, page.totalOutput.text()

        where:
            firstOperand | operator | secondOperand | result
            '9'          | '+'      | '3'           | '12'
            '9'          | '-'      | '3'           | '6'
            '9'          | '*'      | '3'           | '27'
            '9'          | '/'      | '3'           | '3'
    }

}
