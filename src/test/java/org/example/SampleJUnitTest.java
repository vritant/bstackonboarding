package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import org.example.pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SampleJUnitTest extends JUnitTestBase {

  private HomePage homepage;

  @Before
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  @Test
  @Ignore
  public void testHomePageHasAHeader() {
    driver.get(baseUrl);
    Assert.assertFalse("".equals(homepage.header.getText()));
    driver.findElement(By.id("searchInput")).sendKeys("Red Hat");
    //pause(4000);
    WebDriverWait wait = new WebDriverWait(driver, 10);
    By link = By.partialLinkText("Red Hat Enterprise Linux");
    wait.until(ExpectedConditions.visibilityOfElementLocated(link));
    driver.findElement(link).click();
    Assert.assertTrue("Red Hat Enterprise Linux - Wikipedia".equals(homepage.getTitle()));
  }

  @Test
  public void testBstackLogin() {

    //System.out.println(passwd);

    driver.get(baseUrl);
    WebDriverWait wait = new WebDriverWait(driver, 10);

    By terms = By.id("accept-cookie-notification");
    wait.until(ExpectedConditions.elementToBeClickable(terms));
    driver.findElement(terms).click();

    //Assert.assertFalse("".equals(homepage.header.getText()));
    By signIn = By.partialLinkText("Sign in");

    wait.until(ExpectedConditions.visibilityOfElementLocated(signIn));
    driver.findElement(signIn).click();

    By emailEl = By.id("user_email_login");
    By passwordEl = By.id("user_password");
    By submit = By.id("user_submit");
    wait.until(ExpectedConditions.visibilityOfElementLocated(emailEl));
    driver.findElement(emailEl).sendKeys(email);
    driver.findElement(passwordEl).sendKeys(passwd);

    wait.until(ExpectedConditions.elementToBeClickable(submit));
    driver.findElement(submit).click();


    By android = By.cssSelector("[data-test-ositem='android']");
    wait.until(ExpectedConditions.visibilityOfElementLocated(android));

    Assert.assertTrue(driver.getCurrentUrl().contains("live"));
    driver.findElement(android).click();

    By s23 = By.cssSelector("[data-test-dev-name='Galaxy S22+']");
    wait.until(ExpectedConditions.elementToBeClickable(s23));
    Actions actions = new Actions(driver);
    actions.moveToElement(driver.findElement(s23));
    driver.findElement(s23).click();

    By chrome = By.cssSelector("[data-test-device-browser='chrome']");
    pause(2000);
    //wait.until(ExpectedConditions.elementToBeClickable(chrome));
    driver.findElement(chrome).click();

    By message = By.className("loader__head-message");
    pause(2000);
    //wait.until(ExpectedConditions.visibilityOfElementLocated(message));

    /* SSO login
    By emailEl = By.id("identifierId");
    wait.until(ExpectedConditions.visibilityOfElementLocated(emailEl));
    driver.findElement(emailEl).sendKeys(email);

    By next = By.id("identifierNext");
    driver.findElement(next).click();

    By password = By.name("Passwd");
    By passwordNext = By.id("passwordNext");

    driver.findElement(password).sendKeys(passwd);
    driver.findElement(passwordNext).click();

    */
    pause(10000);

    //By signMeIn = By.id("user_submit");
    //driver.findElement(signMeIn).click();
    pause(10000);

    //By enterpriseLogin = By.id("enterprise_user_submit");
    //wait.until((ExpectedConditions.visibilityOfElementLocated(enterpriseLogin)));
    //driver.findElement(enterpriseLogin).click();
    //driver.findElement(password).sendKeys("blah");
    //driver.findElement(submit).click();
    /*
    driver.findElement(By.id("searchInput")).sendKeys("Red Hat");
    //pause(4000);

    By link = By.partialLinkText("Red Hat Enterprise Linux");
    wait.until(ExpectedConditions.visibilityOfElementLocated(link));
    driver.findElement(link).click();
    Assert.assertTrue("Red Hat Enterprise Linux - Wikipedia".equals(homepage.getTitle()));

     */
  }

  public void pause(Integer milliseconds){
    try {
      Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
