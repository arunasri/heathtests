package com.qa.health.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.health.pageobjects.HomepageEntitiesPO;
import com.qa.health.pageobjects.LoginPO;

public class BaseTest {
  public WebDriver driver;
  private String URL = "https://hidden-chamber-33381.herokuapp.com/#/login";

  @BeforeMethod
  public void setUp() {
    driver = new ChromeDriver();
    driver.get(URL);
  }

  public void call() {
    System.out.println("callin base test");
  }

  // method
  // return type void
  // no arguments
  // name of method is loginTestWithValidCredientials

  public void loginTestWithValidCredientials() {
      // creating an instance of  class LoginPO
      // passing driver to constructor
      LoginPO loginPageObject = new LoginPO(driver);
      // create webdriverwait instance
      // passing two arguments to construcotr
      WebDriverWait wait = new WebDriverWait(driver, 60);
      // wait for condition to succed
      // it waits maximum 60 seconds
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-title")));
      // calling page object field type admin to username field
      loginPageObject.signInUsernameTextfield.sendKeys("admin");
      // entering password
      loginPageObject.signInPasswordTextfield.sendKeys("admin");
      // submit button
      loginPageObject.loginSubmitButton.click();

      // wait until success elements shows up
      wait.until(
          ExpectedConditions.visibilityOfElementLocated(
              By.xpath("//div[@class='alert alert-success fade show']")));
      WebElement userAdminLoginMessage =
          driver.findElement(By.xpath("//div[@class='alert alert-success fade show']"));
      // assert result text
      Assert.assertTrue(
          userAdminLoginMessage.isDisplayed(), "User is not able login with admin credientials");
    }
  
  
  public void gotoCreatePatientPage() {
    //loginTestWithValidCredientials();
    HomepageEntitiesPO homepageEntitiesObject = new HomepageEntitiesPO(driver);
    // click patient entities
    homepageEntitiesObject.entitiesButton.click();
    homepageEntitiesObject.entitiesPatientlink.click();
    // verify your on entities page
    WebElement patientsPage = driver.findElement(By.id("patient-heading"));
    Assert.assertTrue(patientsPage.isDisplayed(), "patients page is not present");
  }

  @AfterMethod
  public void teardown() {
    driver.quit();
  }
}
