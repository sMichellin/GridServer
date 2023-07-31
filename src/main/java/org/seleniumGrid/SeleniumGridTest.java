package org.seleniumGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class SeleniumGridTest {

    public static void main(String[] args) {
        try {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("browserVersion", "114.0.5735.248");
            chromeOptions.setCapability("platformName", "Windows");
// Showing a test name instead of the session id in the Grid UI
            chromeOptions.setCapability("se:name", "My simple test");


// Other type of metadata can be seen in the Grid UI by clicking on the
// session info or via GraphQL
            chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value");


            chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);


            WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/"), chromeOptions);



            //driver.get("http://www.google.com");

            driver.get("https://www.calculator.net/");

// Click on Math Calculators

            //   driver.findElement(By.linkText("Math Calculators")).click();


            driver.findElement(By.xpath( "/html/body/div[4]/div/div[1]/div[3]/div[2]/a"));

            // Click on Percent Calculators

            driver.findElement(By.linkText("Percentage Calculator")).click();

            // Enter value 10 in the first number of the percent Calculator
            driver.findElement(By.id("cpar1")).sendKeys("10");
// Enter value 50 in the second number of the percent Calculator
            driver.findElement(By.id("cpar2")).sendKeys("50");
// Click Calculate Button
            driver.findElement(By.xpath("/html/body/div[3]/div[1]/table[1]/tbody/tr[2]/td/input[2]")).click();
// Get the Result Text based on its xpath
            String result = driver.findElement(By.xpath("/html/body/div[3]/div[1]/p[2]/font/b")).getText();
// Print a Log In message to the screen
            System.out.println(" The Result is " + result);
            if (result.equals("5")) {
                System.out.println(" The Result is Pass");
            } else {
                System.out.println(" The Result is Fail");
            }


            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
