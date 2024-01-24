package com.employee.CallbackGen.business.pages.aService;

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
public class AServicePage {
    @NonNull private WebDriver driver;
    @NonNull private WebDriverWait wait;

    @Getter private final String address = "https://a-service.ua/ua";

    private final By callbackButton = By.cssSelector(".form_in_call button");
    private final By fieldPhoneNumber = By.id("#bingc-passive-get-phone-form-input");
    private final By submitButton = By.id("#bingc-passive-phone-form-button");

    public AServicePage openAddress() {
        driver.get(address);
        return this;
    }

    private WebElement getCallbackButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(callbackButton));
        return driver.findElement(callbackButton);
    }

    public AServicePage callbackButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(callbackButton));
        getCallbackButton().click();
        return this;
    }

    private WebElement getFieldPhoneNumber() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldPhoneNumber));
        return driver.findElement(fieldPhoneNumber);
    }

    public AServicePage fieldPhoneNumberSendKeys(String phoneNumber) {
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
