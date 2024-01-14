package com.employee.CallbackGen.business.services;

import org.openqa.selenium.chrome.ChromeOptions;
import com.employee.CallbackGen.utils.Common;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component
public class ChromeOptionsFactory {

    //@Bean
    public ChromeOptions build() {
        ChromeOptions chromeOptions = new ChromeOptions();

        if (Common.chromeOptionsStealthMode) chromeOptions.addArguments("--headless");
        if (Common.chromeOptionsNotifications) chromeOptions.addArguments("--enable-notifications");
        else chromeOptions.addArguments("--disable-notifications");
        if (Common.chromeOptionsClearStorage) chromeOptions.addArguments("clear-storage");
        chromeOptions.addArguments(
                "lang=ru",
                "--disable-infobars",
                "--ignore-certificate-errors",
                "--web-security=false",
                "--ssl-protocol=any",
                "--ignore-ssl-errors=true",
                "--no-sandbox",
                "--disable-gpu");
        chromeOptions.setAcceptInsecureCerts(true);

        return chromeOptions;
    }
}