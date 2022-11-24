package com.pages;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;

public class SolutionarchitectPage extends AbsBasePage<SolutionarchitectPage>{
    public SolutionarchitectPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[class = container] h1")
    private WebElement titleHeader;


    public SolutionarchitectPage getTitle(String title){
        Assertions
                .assertTrue(titleHeader.getText().trim().contains(title));
        return this;

    }
}
