package junitAmazon;



import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ReadCustomerReview {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testReadCustomerReview() throws Exception {
    driver.get("http://www.amazon.com/");
    new Select(driver.findElement(By.id("searchDropdownBox"))).selectByVisibleText("Clothing & Accessories");
    driver.findElement(By.cssSelector("option[value=\"search-alias=apparel\"]")).click();
    driver.findElement(By.cssSelector("input.nav-submit-input")).click();
    driver.findElement(By.linkText("Accessories")).click();
    driver.findElement(By.linkText("Shop All Women")).click();
    driver.findElement(By.cssSelector("p")).click();
    driver.findElement(By.cssSelector("span.lrg.bold")).click();
    driver.findElement(By.linkText("40 customer reviews")).click();
    driver.findElement(By.cssSelector("img[alt=\"Add to cart\"]")).click();
    driver.findElement(By.linkText("Edit your Cart")).click();
    driver.findElement(By.name("quantity.C2C957KCE5F775")).clear();
    driver.findElement(By.name("quantity.C2C957KCE5F775")).sendKeys("0");
    driver.findElement(By.id("remove-button-C2C957KCE5F775")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
