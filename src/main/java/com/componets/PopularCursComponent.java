package com.componets;

import com.google.common.collect.Comparators;
import com.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.lang.model.element.Element;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PopularCursComponent extends AbsComponent<PopularCursComponent> {

    public PopularCursComponent(WebDriver driver) {

        super(driver);
    }
    @FindBy(css = "[class='lessons'] .lessons__new-item_hovered, .lessons__new-item_hovered:active, .lessons__new-item_hovered:link, .lessons__new-item_hovered:visited")
    private List<WebElement> popularCursItems;

    private List<String> nameKurs = new ArrayList<>();
    private List<String> dateKurs = new ArrayList<>();
    private List<Integer> dateKursInt = new ArrayList<>();

    @FindBy(css = ".transitional-main__event-button")
    private WebElement buttonKurs;

    public void getElementsFromPage(){
            List<WebElement> elements = driver.findElements(By.cssSelector(".subtitle-new"));

                    for(WebElement element : elements) {
                        nameKurs.add(element.getText());
                    }
        }


    public void getDateFromPage() {
        List<WebElement> elements = driver.findElements(By.cssSelector(".lessons__new-item-start"));
        for (WebElement element : elements) {
            dateKurs.add(element.getText());
        }
    }
    public void setDate(){
        getDateFromPage();
        for(String dates : dateKurs) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(dates);
            int start = 0;
            int result = 0;
            while (matcher.find(start)) {
                String value = dates.substring(matcher.start(), matcher.end());
                result = Integer.parseInt(value);
                System.out.println(result);
                start = matcher.end();
            }
            dateKursInt.add(result);

        }


    }



    public MainPage movePopularCursItems(int index){
        Actions actions = new Actions(driver);
        actions
                .moveToElement(popularCursItems.get(index))
                .moveToElement(buttonKurs)
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

    public void dateStreamMax(){
setDate();
Optional<Integer> sortedList = dateKursInt
                .stream()
                .sorted()
                .reduce((x,y)-> Math.max(x, y));
        System.out.println(sortedList);
    }

    public void dateStreamMin(){
        Optional<Integer> sortedList1 = dateKursInt
                .stream()
                .sorted()
                .reduce((x,y)-> Math.min(x, y));
        System.out.println(sortedList1);
    }

}