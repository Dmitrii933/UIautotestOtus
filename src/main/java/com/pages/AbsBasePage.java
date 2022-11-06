package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbsBasePage<T> {

    protected WebDriver driver;

    private String hostname = System.getProperty("webdriver.base.url");

    public AbsBasePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public T open(){
        driver.get(hostname);
        return (T)this;
    }

}
