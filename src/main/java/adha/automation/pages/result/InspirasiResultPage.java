package adha.automation.pages.result;

import adha.automation.pages.common.AbstractComponent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InspirasiResultPage extends AbstractComponent {

    public InspirasiResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='search']")
    public WebElement input_search;

    @FindBy(xpath = "//h1[@class='title']")
    public List<WebElement> title_inspirasi;

    @Override
    public boolean isDisplayed() {
        return false;
    }

    public void SearchInput(String search){
        wait.until(driver -> input_search.isDisplayed());
        input_search.sendKeys(search);
        input_search.sendKeys(Keys.RETURN);
    }

    public String getTitleInspirasi(){
        StringBuilder builder = new StringBuilder();
        wait.until(driver -> title_inspirasi.size() > 0);
        for(WebElement e : title_inspirasi) {
            builder.append(e.getText());
        }

        return builder.toString();
    }

    public void SearchByScroll(String search){
        wait.until(driver -> title_inspirasi.size() > 0);
        for(WebElement e : title_inspirasi) {
            String title = e.getText();

            if(title.contentEquals(search)){
                this.actions.moveToElement(e);
                int y = e.getLocation().y;
                String output = String.format("window.scrollBy(0,%d)", y);
                this.js.executeScript(output);
                break;
            }
        }
    }

}
