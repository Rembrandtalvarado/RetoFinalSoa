package DriverFactory.manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static io.github.bonigarcia.wdm.config.DriverManagerType.EDGE;

public class EdgeDriverManager {
    public WebDriver createDriver(){
        WebDriverManager.getInstance(EDGE).setup();
        return new EdgeDriver();
    }
}