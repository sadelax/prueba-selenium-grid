import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestGridSauceLabs {

  private WebDriver driver;
  protected ChromeOptions browserOptions = new ChromeOptions();
  WebDriverWait wait;

  @BeforeEach
  public void setup() throws MalformedURLException {

    browserOptions.setPlatformName("Windows 11");
    browserOptions.setBrowserVersion("latest");
    Map<String, Object> sauceOptions = new HashMap<>();
    sauceOptions.put("username", "saucelabs username here. oauth-************-**61c");
    sauceOptions.put("accessKey", "access key here. ********************************5888");
    sauceOptions.put("build", "build id here. selenium-build-2906L");
    sauceOptions.put("name", "<your test name>");
    browserOptions.setCapability("sauce:options", sauceOptions);

    //URL gridURL = new URL("http://localhost:4444");
    //driver = new RemoteWebDriver(gridURL, this.browserOptions);

    URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
    driver = new RemoteWebDriver(url, browserOptions);

    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  @Test
  public void fillContactForm() {

    driver.get("https://automationintesting.online/");

    WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
    WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
    WebElement phoneField = wait.until(ExpectedConditions.elementToBeClickable(By.id("phone")));
    WebElement subjectField = wait.until(ExpectedConditions.elementToBeClickable(By.id("subject")));
    WebElement descriptionField =
        wait.until(ExpectedConditions.elementToBeClickable(By.id("description")));

    nameField.sendKeys("John Doe");
    emailField.sendKeys("john.doe@example.com");
    phoneField.sendKeys("1234567890");
    subjectField.sendKeys("Test Subject");
    descriptionField.sendKeys("This is a test message.");

    WebElement submitButton =
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submitContact")));
    submitButton.click();

    WebElement errorMessageLabel =
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-danger p")));
    String errorMessage = errorMessageLabel.getText();
    assertEquals("Phone must be between 11 and 21 characters.", errorMessage);

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    driver.quit();
  }
}
