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

/**
 * Clase que tiene la finalidad de generar capturas de pantalla de la pagina web que estamos probando.
 */
@Slf4j
public class ScreenshotHelpers {
    private static String directory = "";
    private static ScreenshotHelpers screenshotHelpers;

    private ScreenshotHelpers(){
        log.debug("Se crea el nombre del directorio para las imagenes.");
        directory = String.format("src/test/resources/screenshot/%s", new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()));
    }

    public static ScreenshotHelpers setup(){
        if(screenshotHelpers == null) screenshotHelpers = new ScreenshotHelpers();
        return screenshotHelpers;
    }

    /**
     * Método que ayuda en la generacion de capturas de pantallas durante la ejecución de los test
     * @param driver
     */
    public static void getScreenshot(WebDriver driver){
        log.debug("Se crea el nombre de la imagen");
        String filename = String.format("screenshot_%s.png",new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()));

        File dirScreenshot  = new File(directory);
        if (!dirScreenshot.exists()){
            log.debug("No existe el directorio, se procede a crear la ruta de carpetas");
            dirScreenshot.mkdirs();
        }

        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File newScreenshotFile = new File(dirScreenshot,filename);

        try {
            log.debug("Guardamos la captura en una ruta especifica {}", newScreenshotFile.toURI().toString());
            Files.copy(screenshotFile.toPath(),newScreenshotFile.toPath());
            log.info("Screenshot {}", newScreenshotFile.toURI().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
