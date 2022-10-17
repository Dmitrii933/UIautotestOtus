package componets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.function.Predicate;


public class PopularCursComponent extends AbsComponent<PopularCursComponent> {

    public PopularCursComponent(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[class='lessons'] .lessons__new-item-container")
    private List<WebElement> popularCursItems;

    @FindBy(css = "[class='subtitle-new']")
    private List<WebElement> titleCurs;

    public MainPage clickPopularCursItems(int index){
        Actions actions = new Actions(driver);
        actions
                .moveByOffset(370, 225)
                .moveToElement(popularCursItems.get(index))
                //.moveToElement(popularCursItems.get(index1))
                .pause(100)
                .build()
                .perform();

        popularCursItems.get(index)
                .click();

        return new MainPage(driver);
    }

    public MainPage filterStream(String title){
WebElement element = titleCurs
        .stream()
        .filter((val) -> val.getText().trim().contains(title.trim()))
        .findFirst()
        .orElseThrow(NoSuchElementException::new);

        return new MainPage(driver);
    }


}