package main;

import com.annotations.Driver;
import com.componets.PopularCursComponent;
import com.extensions.UIExtension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.openqa.selenium.WebDriver;
import com.pages.MainPage;



@ExtendWith(UIExtension.class)
public class MainPage_Test {

    @Driver
    private WebDriver driver;

    @Test
    public void filterTest (){

        new MainPage(driver)
                .open();

        new PopularCursComponent(driver)
                .filterStream();
    }

    @Test
    public void actionAndClickElementTest (){

        new MainPage(driver)
                .open();

        new PopularCursComponent(driver)
                .movePopularCursItems(0);

    }

}
