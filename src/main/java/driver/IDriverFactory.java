package driver;

import org.openqa.selenium.WebDriver;

public interface IDriverFactory {
    WebDriver getDriver(Browser browser);
}
