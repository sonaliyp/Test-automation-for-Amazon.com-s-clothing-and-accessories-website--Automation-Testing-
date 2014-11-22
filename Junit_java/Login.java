package junitAmazon;


//package com.example.tests;




import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Login {
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
  public void testLogin() throws Exception {
    driver.get("http://www.amazon.com/");
    new Select(driver.findElement(By.id("searchDropdownBox"))).selectByVisibleText("Clothing & Accessories");
    driver.findElement(By.cssSelector("option[value=\"search-alias=apparel\"]")).click();
    driver.findElement(By.cssSelector("input.nav-submit-input")).click();
    driver.findElement(By.cssSelector("#nav-your-account > span.nav-button-mid.nav-sprite > span.nav-button-inner.nav-sprite > span.nav-button-title.nav-button-line2")).click();
    driver.findElement(By.id("ap_email")).clear();
    driver.findElement(By.id("ap_email")).sendKeys("phsonali@gmail.com");
    driver.findElement(By.id("ap_password")).clear();
    driver.findElement(By.id("ap_password")).sendKeys("12345678abcd");
    driver.findElement(By.id("signInSubmit-input")).click();
    driver.findElement(By.cssSelector("#your-orders > span")).click();
    driver.findElement(By.id("searchOrdersInput")).clear();
    driver.findElement(By.id("searchOrdersInput")).sendKeys("clothing & Accessories");
    new Select(driver.findElement(By.id("orderFilter"))).selectByVisibleText("2013");
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

