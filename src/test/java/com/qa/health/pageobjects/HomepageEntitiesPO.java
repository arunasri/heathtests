package com.qa.health.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomepageEntitiesPO {
  private WebDriver driver;

  public HomepageEntitiesPO(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Entities')]")
  public WebElement entitiesButton;

  @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Patient')]")
  public WebElement entitiesPatientlink;

  @FindBy(
      how = How.XPATH,
      using = "//a[@class='dropdown-item active' and contains(text(),'Health Record')]")
  public WebElement entitiesHealthRecordlink;
}
