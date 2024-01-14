package com.employee.CallbackGen.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
    // Application folders and path IDE
    private static final String projectPath = "C:/Users/Rodion/IdeaProjects/CallbackGen/";
    private static final String uploadFilesPath = projectPath + "src/main/resources/uploadFiles/";
    private static final String screenshotPath = "./reports/screenshots/";

    // Docker folders path
    private static final String dockerContainerWorkDir = "/cbg/data";
    private static final String workDirUploadsFilesPath = dockerContainerWorkDir + "/uploadFiles/";
    private static final String workDirScreenshotPath = dockerContainerWorkDir + "/result/screenshots/";

    // ChromeOptions
    public static final boolean chromeOptionsStealthMode = false;
    public static final boolean chromeOptionsNotifications = false;
    public static final boolean chromeOptionsClearStorage = true;

    // Application options
    public static final boolean screenshotReport = true;

    // environment project
    public static final boolean isIDE = false;
    public static final boolean isDocker = true;

    public static String getScreenshotPath() {
        if (isIDE) return screenshotPath;
        if (isDocker) return workDirScreenshotPath;
        return "C:/";
    }

    public static String getUploadFilesPath() {
        if (isIDE) return uploadFilesPath;
        if (isDocker) return workDirUploadsFilesPath;
        return "C:/";
    }

    // Files naming
    public static final String outputFilesNamePattern = "Callback_screenshots_";

    public static String getScreenshotName(){
        return "ReportScreenshot_" + getTimeStamp() + ".png";
    }

    public static String getOutputZipNamePattern() {
        return outputFilesNamePattern + getTimeStamp() + ".zip";
    }

    public static String getTimeStamp () {
        return new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
    }
}
