import org.openqa.selenium.chrome.ChromeDriver

def chromeDriverPath = Thread.currentThread().getContextClassLoader().getResource("chromedriver.exe").path
System.setProperty("webdriver.chrome.driver", chromeDriverPath);

driver = { new ChromeDriver() }
cacheDriverPerThread = true