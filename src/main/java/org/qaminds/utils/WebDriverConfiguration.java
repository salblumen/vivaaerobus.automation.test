package org.qaminds.utils;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Clase que nos permite instanciar la configuración del navegador a un nivel global, para reusarse el driver en distintas partes del proyecto.
 */
public class WebDriverConfiguration {

    @Getter //Se puede solo agregar la anotación lombok una variable específica
    private static WebDriver driver;
    private static WebDriverConfiguration webDriverConfiguration; // Variable estatica para el control del patron de diseño singleton

    /**
     * Constructor privado que inicializa la configuración del driver y el navegador.
     * @param driver recibe como parametro el driver del tipo de navegador que deseamos usar, example: new ChromeDriver();
     */
    private WebDriverConfiguration(WebDriver driver){
        WebDriverManager.chromedriver().setup();
        WebDriverConfiguration.driver = driver;
    }

    /**
     * Método que permite generar una instancia nueva de WebDriverConfiguration, si ya existe una previa, ya regresa
     * nuevamente para no acumular instancias en la memoria
     *
     * @param driver
     * @return retorna una instancia de WebDriverConfiguration
     */
    public static WebDriverConfiguration setup(WebDriver driver){
        if(webDriverConfiguration == null) webDriverConfiguration = new WebDriverConfiguration(driver);
        return webDriverConfiguration;
    }

}
