package com.qa.health.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateNewPatientPO {
    private WebDriver driver;
    
    public CreateNewPatientPO(WebDriver driver) {
	PageFactory.initElements(driver, this);
    }
    
    @FindBy(how = How.ID, using = "healthApp.patient.home.createOrEditLabel")
    public WebElement createOrEditAPatientLabel;
    @FindBy(how = How.ID, using = "patient-name")
    public WebElement nameTextField;
    @FindBy(how = How.ID, using = "cancel-save")
    public WebElement backButton;
    @FindBy(how = How.ID, using = "save-entity")
    public WebElement saveButton;

}
