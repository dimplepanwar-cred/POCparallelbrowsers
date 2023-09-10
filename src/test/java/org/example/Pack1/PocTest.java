package org.example.Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class PocTest {
    private RemoteWebDriver driver;
    //WebDriver driver;
    @Parameters("browser")

    @BeforeTest
    public void first ( String browser) throws MalformedURLException
    {
        {
            //driver=new ChromeDriver();
            if (browser.equalsIgnoreCase("firefox"))
            {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new RemoteWebDriver((new URL("http://192.168.83.5:4444/wd/hub")), firefoxOptions);
            }
            else if (browser.equalsIgnoreCase("chrome"))
            {
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new RemoteWebDriver((new URL("http://192.168.83.5:4444/wd/hub")), chromeOptions);
            }
//            else if (browser.equalsIgnoreCase("edge"))
//            {
//                EdgeOptions edgeOptions = new EdgeOptions();
//                driver = new RemoteWebDriver((new URL("http://192.168.143.5:4444")), edgeOptions);
//            }
            else
            {
                SafariOptions safariOptions = new SafariOptions();
                driver = new RemoteWebDriver((new URL("http://192.168.83.5:4444/wd/hub")), safariOptions);
            }
        }
        //driver=new ChromeDriver();
        //FirefoxOptions firefoxOptions = new FirefoxOptions();
        //driver = new RemoteWebDriver((new URL("http://192.168.92.5:4444")), firefoxOptions);
    }
    @Test
    public void second() throws MalformedURLException, InterruptedException {
        Thread.sleep(5000);
        driver.get("https://www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement abc = driver.findElement(By.xpath("//*[@class='gLFyf' and @type='search']"));
        abc.click();
        abc.sendKeys("Flora");
        abc.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }
    @AfterTest
    public void third()
    {
        System.out.println("You are viewing results for flora");
        driver.quit();
    }
}

