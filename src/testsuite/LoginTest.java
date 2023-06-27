package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class LoginTest extends BaseTest
{
    String baseUrl="http://the-internet.herokuapp.com/login";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials()
    {
        // Enter the 'tomsmith' username Field
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
        // Enter the “SuperSecretPassword!” password Field
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        // Click on ‘LOGIN’ Button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        // Verify the text “Secure Area”
        String expectedMessage="Secure Area";
        String actualMessage = driver.findElement(By.xpath("//h2")).getText();
        // Verification to actualMessage and expectedMessage
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyTheUsernameErrorMessage()
    {
        // Enter “tomsmith1” username Field
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");
        // Enter “SuperSecretPassword!” password Field
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        // Click on 'LOG IN' button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        // Verify the error Message " Your Password"is invalid!"
        String expectedMessage="Your name is invalid";
        String actualMessage = driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        Assert.assertEquals("fail to login",expectedMessage,actualMessage);
    }
    @Test
    public void verifyThePasswordErrorMessage()
    {
        // Enter the 'tomsmith' username Field
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
        // Enter “SuperSecretPassword” invalid password into Field
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
        // Click on 'LOG IN' button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        String expectedMessage="Your password is invalid!";
        String actualMessage=driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @After
    public void tearDown()
    {
        // CLose the Browser
        driver.quit();
    }
}
