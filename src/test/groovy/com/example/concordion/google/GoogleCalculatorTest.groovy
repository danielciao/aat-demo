package com.example.concordion.google

import com.example.common.page.GoogleCalculatorPage
import com.example.common.page.GoogleSearchPage
import geb.Browser
import org.concordion.integration.junit4.ConcordionRunner
import org.junit.runner.RunWith

@RunWith(ConcordionRunner.class)
class GoogleCalculatorTest {

    def calculate(String firstOperand, String secondOperand, String operator) {
        def result

        Browser.drive() {
            to GoogleSearchPage

            searchInput = 'calc'
            searchBtn().click()

            at GoogleCalculatorPage

            numberBtn(firstOperand).click()
            operatorBtn(operator).click()
            numberBtn(secondOperand).click()

            equalsBtn.click()

            result = totalOutput.text()
        }

        result
    }
}
