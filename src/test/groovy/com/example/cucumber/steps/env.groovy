package com.example.cucumber.steps

import geb.Browser
import geb.binding.BindingUpdater
import org.openqa.selenium.OutputType

import static cucumber.api.groovy.Hooks.After
import static cucumber.api.groovy.Hooks.Before

Before { scenario ->
    if (!binding.hasVariable('browser')) {
        bindingUpdater = new BindingUpdater(binding, new Browser())
        bindingUpdater.initialize()
    }
}

After { scenario ->
    def currentBrowser

    if (bindingUpdater) {
        currentBrowser = binding.getVariable('browser')
        bindingUpdater.remove()
    }

    if (scenario.failed && currentBrowser) {
        scenario.embed(currentBrowser.driver.getScreenshotAs(OutputType.BYTES), "image/png")
    }
}