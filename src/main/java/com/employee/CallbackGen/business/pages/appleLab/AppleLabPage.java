package com.employee.CallbackGen.business.pages.appleLab;

import com.employee.CallbackGen.business.managers.Screenshot;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RequiredArgsConstructor
public class AppleLabPage {
    @NonNull private WebDriver driver;
    @NonNull private WebDriverWait wait;

    @Getter private final String address = "https://apple-lab.com.ua/zp/";

    private final By callbackButton = By.id("#popupbutton");
    private final By fieldFirstName = By.cssSelector("input[name=\"Order[name]\"]");
    private final By fieldPhoneNumber = By.id("#phone");
    private final By submitButton = By.cssSelector("[type=\"submit\"]");

    public AppleLabPage openAddress() {
        driver.get(address);
        return this;
    }

    private WebElement getCallbackButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(callbackButton));
        return driver.findElement(callbackButton);
    }

    public AppleLabPage callbackButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(callbackButton));
        getCallbackButton().click();
        return this;
    }

    private WebElement getFieldFirstName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldFirstName));
        return driver.findElement(fieldFirstName);
    }

    public AppleLabPage fieldFirstnameSendKeys(String firstname) {
        wait.until(ExpectedConditions.elementToBeClickable(fieldFirstName));
        getFieldFirstName().click();
        getFieldFirstName().clear();
        getFieldFirstName().sendKeys(firstname);
        return this;
    }

    private WebElement getFieldPhoneNumber() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldPhoneNumber));
        return driver.findElement(fieldPhoneNumber);
    }

    public AppleLabPage fieldPhoneNumberSendKeys(String phoneNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(fieldPhoneNumber));
        getFieldPhoneNumber().click();
        getFieldPhoneNumber().clear();
        getFieldPhoneNumber().sendKeys(phoneNumber);
        new Screenshot(driver).takeScreenshot();
        return this;
    }

    private WebElement getSubmitButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        return driver.findElement(submitButton);
    }

    public void submitButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        getSubmitButton().click();
        new Screenshot(driver).takeScreenshot();
    }
}
