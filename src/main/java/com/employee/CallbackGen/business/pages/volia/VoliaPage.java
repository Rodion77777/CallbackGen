package com.employee.CallbackGen.business.pages.volia;

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
public class VoliaPage {
    @NonNull private WebDriver driver;
    @NonNull private WebDriverWait wait;

    @Getter private final String address = "https://volia-promo.com.ua/?partner=google_cpc_wp_search_brand_promo_all&gclid=EAIaIQobChMItJu_gIbk_QIVK0aRBR10QwmSEAAYASAAEgLvefD_BwE";

    private final By callbackButton = By.cssSelector(".t182__buttons a:nth-of-type(1)");
    private final By fieldFirstName = By.cssSelector("[name=\"firstname\"]");
    private final By fieldPhoneNumber = By.cssSelector("[name=\"phone\"]");
    private final By submitButton = By.cssSelector("[class=\"b-form-btn\"][type=\"submit\"]");

    public VoliaPage openAddress() {
        driver.get(address);
        return this;
    }

    private WebElement getCallbackButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(callbackButton));
        return driver.findElement(callbackButton);
    }

    public VoliaPage callbackButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(callbackButton));
        getCallbackButton().click();
        return this;
    }

    private WebElement getFieldFirstName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldFirstName));
        return driver.findElement(fieldFirstName);
    }

    public VoliaPage fieldFirstnameSendKeys(String firstname) {
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

    public VoliaPage fieldPhoneNumberSendKeys(String phoneNumber) {
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