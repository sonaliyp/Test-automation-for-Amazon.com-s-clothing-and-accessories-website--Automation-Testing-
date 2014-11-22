package junitAmazon;



import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class basicTest {
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
  public void testUntitled() throws Exception {
    driver.get("http://www.amazon.com/");
    new Select(driver.findElement(By.id("searchDropdownBox"))).selectByVisibleText("Clothing & Accessories");
    driver.findElement(By.cssSelector("option[value=\"search-alias=apparel\"]")).click();
    driver.findElement(By.cssSelector("input.nav-submit-input")).click();
    driver.findElement(By.linkText("Shoes")).click();
    driver.findElement(By.cssSelector("div.left_nav > ul > li > a")).click();
    driver.findElement(By.linkText("New Arrivals")).click();
    driver.findElement(By.cssSelector("span.lrg.bold")).click();
    driver.findElement(By.id("dp")).click();
    new Select(driver.findElement(By.id("native_dropdown_selected_size_name"))).selectByVisibleText("11 B(M) US");
    driver.findElement(By.id("native_size_name_12")).click();
    driver.findElement(By.id("add-to-cart-button")).click();
    driver.findElement(By.linkText("Edit your Cart")).click();
    driver.findElement(By.name("quantity.C10NBLZ1OQFRUX")).clear();
    driver.findElement(By.name("quantity.C10NBLZ1OQFRUX")).sendKeys("0");
    driver.findElement(By.id("remove-button-C10NBLZ1OQFRUX")).click();
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
