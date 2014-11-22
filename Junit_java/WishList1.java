package junitAmazon;



import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WishList1 {
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
  public void testMoveWishListTocart() throws Exception {
    driver.get("http://www.amazon.com/");
    driver.findElement(By.id("nav-signin-text")).click();
    driver.findElement(By.id("ap_email")).clear();
    driver.findElement(By.id("ap_email")).sendKeys("phsonali@gmail.com");
    driver.findElement(By.id("ap_password")).clear();
    driver.findElement(By.id("ap_password")).sendKeys("12345678abcd");
    driver.findElement(By.id("signInSubmit-input")).click();
    driver.findElement(By.cssSelector("#nav-wishlist > span.nav-button-mid.nav-sprite > span.nav-button-inner.nav-sprite > span.nav-button-title.nav-button-line2")).click();
    driver.findElement(By.cssSelector("span.wlProductInfoRow.wlBuyButton > a > span.swSprite.s_add2CartSm")).click();
    driver.findElement(By.linkText("Edit your Cart")).click();
    driver.findElement(By.name("quantity.C3HZ3FWTWSOEYQ")).clear();
    driver.findElement(By.name("quantity.C3HZ3FWTWSOEYQ")).sendKeys("0");
    driver.findElement(By.id("remove-button-C3HZ3FWTWSOEYQ")).click();
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
