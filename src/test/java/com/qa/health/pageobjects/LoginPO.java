package com.qa.health.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPO {
  // variable
  // visiblity of vairable(public|private|protected)
  // type of the vairbale(classname WebDriver)
  // nameYouwanttoccall(driver)
  private WebDriver driver;

  // special method name which is same as the class name called construtor
  // no return type
  // you can have any arguments you want
  public LoginPO(WebDriver driver) {
    // you can use any variables declared in class body
    // here driver is used
    PageFactory.initElements(driver, this);
  }

   @FindBy(how = How.XPATH, using = "//span[text()='Account']")
   public WebElement accountButton;
   @FindBy(how = How.ID, using = "login-item")
   public WebElement signInButton;
   @FindBy(how = How.ID, using = "login-title")
   public WebElement signInPopupWindow;
   @FindBy(how = How.ID, using = "username")
   public WebElement signInUsernameTextfield;
   @FindBy(how = How.ID, using = "password")
   public WebElement signInPasswordTextfield;
   @FindBy(how = How.XPATH, using = "//button[@type='submit']")
   public WebElement loginSubmitButton;
  
   
}
