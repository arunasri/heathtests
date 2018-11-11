package com.qa.health.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.health.pageobjects.CreateNewPatientPO;
import com.qa.health.pageobjects.EntitiesPatientsPO;

public class CreateNewPatientTest extends BaseTest {

  @Test
  public void createNewPatient() throws InterruptedException {
    loginTestWithValidCredientials();
    gotoCreatePatientPage();
    EntitiesPatientsPO patientsPage = new EntitiesPatientsPO(driver);
    patientsPage.entitiesCreateNewPatientButton.click();

    CreateNewPatientPO createPatient = new CreateNewPatientPO(driver);
    createPatient.nameTextField.sendKeys("Dave");
    createPatient.saveButton.click();
    driver.findElements(By.xpath("//table//tr//td[2]"));
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Dave']")));
    // deleting the user
    WebElement deleteLink = driver.findElement(By.xpath("//a[@class='btn btn-danger btn-sm']"));
    deleteLink.click();
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//h5[text()='Confirm delete operation']")));
    WebElement deleteButtonPopup = driver.findElement(By.id("jhi-confirm-delete-patient"));
    deleteButtonPopup.click();
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[contains(text(),'A patient is deleted')]")));
  }

  @Test // editing the user
  public void editTheUser() {
    loginTestWithValidCredientials();
    gotoCreatePatientPage();
    EntitiesPatientsPO patientsPage = new EntitiesPatientsPO(driver);
    patientsPage.entitiesCreateNewPatientButton.click();
    // Creating a patient
    CreateNewPatientPO createPatient = new CreateNewPatientPO(driver);
    createPatient.nameTextField.sendKeys("Peter");
    createPatient.saveButton.click();
    
    WebDriverWait wait = new WebDriverWait(driver, 60);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Peter']")));
    // Editing a patient
    WebElement editLink = driver.findElement(By.xpath("//a[@class='btn btn-primary btn-sm']"));
    editLink.click();
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.name("name")));
    WebElement editNameTextfield = driver.findElement(By.name("name"));
    editNameTextfield.clear();
    editNameTextfield.sendKeys("Emily");
    WebElement saveButton = driver.findElement(By.id("save-entity"));
    saveButton.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Emily']")));
    WebElement verifyName = driver.findElement(By.xpath("//td[text()='Emily']"));
    Assert.assertTrue(
	    verifyName.isDisplayed(), "User name is not created");
    System.out.println(verifyName);    
  }
  
  @Test
  public void viewAPatientDetails() {
      
  }

  //    if(driver.getPageSource().contains("Valentina")){
  //	System.out.println("Text is present");
  //	}else{
  //	System.out.println("Text is absent");
  //	}

}
