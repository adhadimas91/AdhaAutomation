package adha.automation.pages.result;

import adha.automation.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerResultPage extends AbstractComponent {

    public CareerResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "openings-title site-title")
    public WebElement title_page_job;

    @Override
    public boolean isDisplayed() {
        return false;
    }

    public String getTitlePageJob(){
        wait.until(driver -> title_page_job.isDisplayed());
        return this.title_page_job.getText();
    }
}
