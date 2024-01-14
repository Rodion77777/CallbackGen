package com.employee.CallbackGen;

import com.employee.CallbackGen.business.pages.kyivstar.*;
import com.employee.CallbackGen.business.pages.volia.*;
import com.employee.CallbackGen.business.services.ChromeOptionsFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SeleniumServerTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private static String remoteDriverUrl = "http://localhost:4444/";
    private static String sessionId;

    @BeforeAll
    public static void init() throws MalformedURLException {
        //noinspection deprecation
        driver = new RemoteWebDriver(new URL(remoteDriverUrl), new ChromeOptionsFactory().build());
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    void kyivstarPageTest(){
        new KyivstarTest(new KyivstarPage(driver, wait))
                .start("Запоріжжя", "987437125");
    }

    @Test
    void voliaPageTest(){
        new VoliaTest(new VoliaPage(driver, wait))
                .start("Дмитрий", "987437125");
    }
}
