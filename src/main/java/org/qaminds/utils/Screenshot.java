package org.qaminds.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {


    public static String screenshot(WebDriver driver){
        String datetime = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        String dirName = "src/test/resources/screenshot/" + datetime;

        String filename = "screenshot_" + datetime + ".png";

        File directory  = new File(dirName);
        if (!directory.exists()){
            directory.mkdirs();
        }

        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshotFile.toPath(),new File(directory,filename).toPath()) ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new File(directory,filename).toPath().toString();
    }
}
