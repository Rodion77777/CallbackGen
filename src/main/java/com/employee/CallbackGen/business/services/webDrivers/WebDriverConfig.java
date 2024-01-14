package com.employee.CallbackGen.business.services.webDrivers;

import com.employee.CallbackGen.business.services.ChromeOptionsFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@SuppressWarnings("deprecation")
//@Configuration
public class WebDriverConfig {

    //@Value("${remote.driver.url}")
    private String remoteDriverUrl;

    //@Autowired
    private ChromeOptions chromeOptionsFactory;


    //@Bean
    public WebDriver remoteWebDriver() throws MalformedURLException {
        return remoteWebDriver(remoteDriverUrl);
    }


    public WebDriver remoteWebDriver(String url) throws MalformedURLException {
        RemoteWebDriver rDriver = new RemoteWebDriver(new URL(url), new ChromeOptionsFactory().build());
        rDriver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(60));
        rDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        rDriver.manage().window().maximize();
        return rDriver;
    }
}