package com.componets;

import com.google.common.collect.Comparators;
import com.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PopularCursComponent extends AbsComponent<PopularCursComponent> {

    public PopularCursComponent(WebDriver driver) {

        super(driver);
    }
    @FindBy(css = "[class='lessons'] .lessons__new-item_hovered, .lessons__new-item_hovered:active, .lessons__new-item_hovered:link, .lessons__new-item_hovered:visited")
    private List<WebElement> popularCursItems;

    private List<String> nameKurs = new ArrayList<>();

    @FindBy(css = ".transitional-main__event-button")
    private WebElement buttonKurs;

    public void getElementsFromPage(){
            List<WebElement> elements = driver.findElements(By.cssSelector(".subtitle-new"));

                    for(WebElement element : elements) {
                        nameKurs.add(element.getText());
                    }
        }



    public MainPage movePopularCursItems(int index){
        Actions actions = new Actions(driver);
        actions
                .moveToElement(popularCursItems.get(index))
                .moveToElement(buttonKurs)
                //.click(popularCursItems.get(index))
                .build()
                .perform();

        return new MainPage(driver);
    }

    public void filterStream(){
        getElementsFromPage();
        List<String> sortedList = nameKurs
                .stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedList);
    }

}