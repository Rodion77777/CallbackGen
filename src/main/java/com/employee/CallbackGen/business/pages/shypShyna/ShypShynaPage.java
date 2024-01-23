package com.employee.CallbackGen.business.pages.shypShyna;

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
public class ShypShynaPage {
    @NonNull private WebDriver driver;
    @NonNull private WebDriverWait wait;

    @Getter private final String address = "https://shyp-shyna.com.ua/";

    private final By callbackButton = By.cssSelector("div[x-data*=\"callback\"]");
    private final By fieldFirstName = By.cssSelector(".form.form--callback > div:nth-child(2) > input");
    private final By fieldPhoneNumber = By.cssSelector("div:first-child > input.form-input");
    private final By checkboxRequired = By.cssSelector(".input-choice > input");
    private final By submitButton = By.cssSelector("[class*=\"callback\"] button[type=\"submit\"]");

    public ShypShynaPage openAddress() {
        driver.get(address);
        return this;
    }

    private WebElement getCallbackButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(callbackButton));
        return driver.findElement(callbackButton);
    }

    public ShypShynaPage callbackButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(callbackButton));
        getCallbackButton().click();
        return this;
    }

    private WebElement getFieldFirstName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldFirstName));
        return driver.findElement(fieldFirstName);
    }

    public ShypShynaPage fieldFirstnameSendKeys(String firstname) {
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

    public ShypShynaPage fieldPhoneNumberSendKeys(String phoneNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(fieldPhoneNumber));
        getFieldPhoneNumber().click();
        getFieldPhoneNumber().clear();
        getFieldPhoneNumber().sendKeys(phoneNumber);
        new Screenshot(driver).takeScreenshot();
        return this;
    }

    private WebElement getCheckboxRequired() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxRequired));
        return driver.findElement(callbackButton);
    }

    public ShypShynaPage submitCheckBoxRequired() {
        if (!getCheckboxRequired().isSelected()) getCheckboxRequired().click();
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