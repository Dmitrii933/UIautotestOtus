package main;

import annotations.Driver;
import componets.PopularCursComponent;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.MainPage;

import javax.swing.*;


@ExtendWith(UIExtension.class)
public class MainPage_Test {

    @Driver
    private WebDriver driver;

    @Test
    public void filterTest (){

        new MainPage(driver)
                .open();

        new PopularCursComponent(driver)
                .filterStream("Специализации");
    }

    @Test
    public void actionAndClickElementTest (){

        new MainPage(driver)
                .open();

        new PopularCursComponent(driver)
                .clickPopularCursItems(0);



    }

}
