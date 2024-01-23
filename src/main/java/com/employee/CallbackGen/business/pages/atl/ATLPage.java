package com.employee.CallbackGen.business.pages.atl;

import com.employee.CallbackGen.business.managers.Screenshot;
import com.employee.CallbackGen.business.pages.volia.VoliaPage;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RequiredArgsConstructor
public class ATLPage {
    @NonNull private WebDriver driver;
    @NonNull private WebDriverWait wait;

    @Getter
    private final String address = "https://atl.ua/ua";

    private final By callbackMenu = By.id("#contact-widget");
    private final By callbackButton = By.id("#binotelManualButton");
    private final By fieldPhoneNumber = By.id("#bingc-passive-get-phone-form-input");
    private final By submitButton = By.id("#bingc-passive-phone-form-button");

    public ATLPage openAddress() {
        driver.get(address);
        return this;
    }

    private WebElement getCallbackMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(callbackMenu));
        return driver.findElement(callbackMenu);
    }

    public ATLPage callbackMenuClick() {
        wait.until(ExpectedConditions.elementToBeClickable(callbackMenu));
        getCallbackMenu().click();
        return this;
    }

    private WebElement getCallbackButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(callbackButton));
        return driver.findElement(callbackButton);
    }

    public ATLPage callbackButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(callbackButton));
        getCallbackButton().click();
        return this;
    }

    private WebElement getFieldPhoneNumber() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldPhoneNumber));
        return driver.findElement(fieldPhoneNumber);
    }

    public ATLPage fieldPhoneNumberSendKeys(String phoneNumber) {
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
