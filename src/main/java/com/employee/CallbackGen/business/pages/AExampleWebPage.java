package com.employee.CallbackGen.business.pages;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

@RequiredArgsConstructor
public abstract class AExampleWebPage{
    @NonNull @Getter
    private final WebDriver driver;
    @NonNull @Getter
    private final WebDriverWait wait;
    private String address;

    private By fieldPhoneNumber;
    private By submitButton;

    protected abstract WebElement getFieldPhoneNumber();
    protected abstract WebElement getSubmitButton();
}