package com.employee.CallbackGen.api.controllers;

import com.employee.CallbackGen.business.pages.atl.ATLPage;
import com.employee.CallbackGen.business.pages.atl.ATLTest;
import com.employee.CallbackGen.business.pages.kyivstar.KyivstarPage;
import com.employee.CallbackGen.business.pages.kyivstar.KyivstarTest;
import com.employee.CallbackGen.business.pages.shypShyna.ShypShynaPage;
import com.employee.CallbackGen.business.pages.shypShyna.ShypShynaTest;
import com.employee.CallbackGen.business.pages.volia.VoliaPage;
import com.employee.CallbackGen.business.pages.volia.VoliaTest;
import com.employee.CallbackGen.business.services.webDrivers.WebDriverConfig;
import com.employee.CallbackGen.utils.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/app")
public class AppController {

    WebDriver driver;
    WebDriverWait wait;

    @PostMapping("/initDriver")
    public ResponseEntity<String> initRemoteWebDriver(@RequestParam String url) {
        try {
            driver = new WebDriverConfig().remoteWebDriver(url);
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            return ResponseEntity.ok().body(((RemoteWebDriver) driver).getSessionId().toString());
        } catch (MalformedURLException | WebDriverException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/getSessionID")
    public String getSessionID() {
        return ((RemoteWebDriver) driver).getSessionId().toString();
    }

    @PostMapping("/destroy")
    public ResponseEntity<String> destroyTarget(@RequestBody List<String> targetList) {
        try {
            for (String s : targetList) destroyStart(s);
            return ResponseEntity.ok("The screenshot report archive is ready for uploading");
        } catch (WebDriverException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while the driver was running: " + e.getMessage());
        } catch (HttpMessageNotReadableException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid request format, must be:\n[\"...\", \"...\"]\n" + e.getMessage());
        }
    }

    private void destroyStart(String s) {
        String name = "Дмитрий";

        if (!phoneNumberVerification(s)) return;
        new KyivstarTest(new KyivstarPage(driver, wait)).start("Запорожье", s);
        new VoliaTest(new VoliaPage(driver, wait)).start(name, s);
        new ShypShynaTest(new ShypShynaPage(driver, wait)).start(name, s);
        new ATLTest(new ATLPage(driver, wait)).start(s);
    }

    private static boolean phoneNumberVerification (String phoneNumber) {
        return Pattern.compile("^(?:\\+?\\d{12}|\\d{10})$")
                .matcher(phoneNumber).matches();
    }

    @PostMapping("/stop")
    public void stopApp() {
        if (driver != null) driver.quit();
    }

    @GetMapping("/test")
    public String testConnection() {
        return Common.getTimeStamp();
    }
}