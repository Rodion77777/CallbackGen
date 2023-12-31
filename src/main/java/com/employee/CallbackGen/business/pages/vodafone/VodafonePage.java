package com.employee.CallbackGen.business.pages.vodafone;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@RequiredArgsConstructor
public class VodafonePage {
    @NonNull private WebDriver driver;
    @NonNull private WebDriverWait wait;

    @Getter private final String address = "https://www.vodafone.ua/home-internet#modal-vega";

    public void openAddress(){
        driver.get(address);
    }
}
