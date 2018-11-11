package com.qa.health.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EntitiesPatientsPO {
  private WebDriver driver;

  public EntitiesPatientsPO(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  @FindBy(
      how = How.XPATH,
      using =
          "//a[@class='btn btn-primary float-right jh-create-entity' and contains(text(),'Create new Patient')]")
  public WebElement entitiesCreateNewPatientButton;
  
}
