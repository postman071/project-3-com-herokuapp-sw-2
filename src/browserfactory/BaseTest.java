package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest
{
    public static WebDriver driver;

    public void openBrowser(String baseUrl)
    {

     // Login the Browser
    driver=new ChromeDriver();
     // Selenium the URL into the Browser
    driver.get(baseUrl);
    //Maximise the Browser
    driver.manage().window().maximize();
    // We Give Implicit Wait to Driver
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser()
    {
        // Close the Browser
        driver.quit();
    }
}
