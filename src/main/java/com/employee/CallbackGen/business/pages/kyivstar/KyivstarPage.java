package com.employee.CallbackGen.business.pages.kyivstar;

import com.employee.CallbackGen.business.managers.Screenshot;
import com.employee.CallbackGen.business.pages.AExampleWebPage;
import com.employee.CallbackGen.business.pages.IExampleWebPage;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KyivstarPage extends AExampleWebPage implements IExampleWebPage {
    private WebDriver driver = super.getDriver();
    private WebDriverWait wait = super.getWait();

    @Getter private final String address = "https://my-kyivstar.com.ua/?gclid=EAIaIQobChMIk6KLiZrj_QIVr0aRBR3vIwVTEAAYASAAEgJj3fD_BwE";

    private final By callbackButton = By.cssSelector(".top-line__btn a");
    private final By fieldCity = By.cssSelector(".modal-form__content div:nth-child(1)>input");
    private final By fieldPhoneNumber = By.cssSelector(".modal-form__content div:nth-child(2)>input");
    private final By submitButton = By.cssSelector(".button.btn-blue");

    public KyivstarPage(@NonNull WebDriver driver, @NonNull WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public KyivstarPage openAddress(){
        driver.get(address);
        return this;
    }

    private WebElement getCallbackButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(callbackButton));
        return driver.findElement(callbackButton);
    }

    public KyivstarPage callbackButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(callbackButton));
        getCallbackButton().click();
        return this;
    }

    private WebElement getFieldCity(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldCity));
        return driver.findElement(fieldCity);
    }

    public KyivstarPage fieldCitySendKeys(String city){
        getFieldCity().click();
        getFieldCity().clear();
        getFieldCity().sendKeys(city);
        return this;
    }

    @Override
    protected WebElement getFieldPhoneNumber(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldPhoneNumber));
        return driver.findElement(fieldPhoneNumber);
    }

    @Override
    public KyivstarPage fieldPhoneNumberSendKeys(String phoneNumber){
        getFieldPhoneNumber().click();
        getFieldPhoneNumber().clear();
        getFieldPhoneNumber().sendKeys(phoneNumber.substring(4));
        new Screenshot(driver).takeScreenshot();
        return this;
    }

    @Override
    protected WebElement getSubmitButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        return driver.findElement(submitButton);
    }

    @Override
    public void submitButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(callbackButton));
        getSubmitButton().click();
        new Screenshot(driver).takeScreenshot();
    }
}
