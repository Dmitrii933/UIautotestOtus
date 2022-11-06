package com.componets;

import com.pages.SolutionarchitectPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;



public class PopularCursComponent extends AbsComponent<PopularCursComponent> {

    public PopularCursComponent(WebDriver driver) {

        super(driver);
    }
    @FindBy(css = ".lessons__new-item-bg")
    private List<WebElement> popularCursItems;

    @FindBy(css =".lessons__new-item-start")
        private List<WebElement> dateElement;

    @FindBy(css = ".lessons__new-item-container")
    private List<WebElement> titleCursItems;

    private List<String> dateKurs = new ArrayList<>();
    private List<Integer> dateKursInt = new ArrayList<>();




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
                start = matcher.end();
            }
            dateKursInt.add(result);

        }


    }

    public PopularCursComponent movePopularCursItems(int index){
        Actions actions = new Actions(driver);
        actions
                .moveToElement(popularCursItems.get(index))
                .click(popularCursItems.get(index))
                .moveByOffset(0,0)
                .build()
                .perform();

        return new PopularCursComponent(driver);
    }

    public PopularCursComponent filterStream(String title){
            WebElement element = titleCursItems
                    .stream()
                    .filter((val) -> val.getText().trim().toLowerCase(Locale.ROOT).contains(title.toLowerCase(Locale.ROOT).trim()))
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);
            element.click();
            return new PopularCursComponent(driver);

        }

    public PopularCursComponent dateStreamMax(){
setDate();
Optional<Integer> sortedList = dateKursInt
                .stream()
                .reduce((x,y)-> Math.max(x, y));
        System.out.println(sortedList.get());

        return new PopularCursComponent(driver);
    }

    public PopularCursComponent dateStreamMin(){
        Optional<Integer> sortedList1 = dateKursInt
                .stream()
                .reduce((x,y)-> Math.min(x, y));
        System.out.println(sortedList1.get());

        return new PopularCursComponent(driver);
    }

}