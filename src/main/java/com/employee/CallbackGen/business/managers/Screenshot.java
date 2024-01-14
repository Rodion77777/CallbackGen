package com.employee.CallbackGen.business.managers;

import com.employee.CallbackGen.utils.Common;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

@RequiredArgsConstructor
public class Screenshot {
    @NonNull WebDriver driver;

    public void takeScreenshot () {
        takeScreenshot(Common.getScreenshotPath() + Common.getScreenshotName());
    }

    public void takeScreenshot (String pathAndName) {

        if (Common.screenshotReport) {
            File scrFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File(pathAndName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
