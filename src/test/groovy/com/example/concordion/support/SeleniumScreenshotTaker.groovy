package com.example.concordion.support

import org.concordion.ext.ScreenshotTaker
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.events.EventFiringWebDriver

class SeleniumScreenshotTaker implements ScreenshotTaker {

    private static final int DEFAULT_WIDTH = 900
    private final WebDriver driver

    public SeleniumScreenshotTaker(WebDriver driver) {
        WebDriver baseDriver = driver

        while (baseDriver instanceof EventFiringWebDriver) {
            baseDriver = ((EventFiringWebDriver) baseDriver).getWrappedDriver()
        }
        this.driver = baseDriver
    }

    @Override
    public int writeScreenshotTo(OutputStream outputStream) throws IOException {
        outputStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES))
        return DEFAULT_WIDTH
    }

    @Override
    public String getFileExtension() {
        return "png"
    }
}
