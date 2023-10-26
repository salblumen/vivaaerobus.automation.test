package org.qaminds.utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class ScreenshotHelpers {
    private static String directory = "";
    public ScreenshotHelpers(){
//        String currentWorkingDirectory = System.getProperty("use.dir");
        directory = String.format("src/test/resources/screenshot/%s", new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()));
    }



    public static String screenshot(WebDriver driver){
//        String datetime = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
//        String dirName = "src/test/resources/screenshot/" + datetime;
        String filename = String.format("screenshot_%s.png",new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()));

        File dirScreenshot  = new File(directory);
        if (!dirScreenshot.exists()){
            dirScreenshot.mkdirs();
        }

        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File newScreenshotFile = new File(dirScreenshot,filename);
        try {
            Files.copy(screenshotFile.toPath(),newScreenshotFile.toPath()) ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newScreenshotFile.toURI().toString();
    }






}
