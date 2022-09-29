package adha.automation.pages.result;

import adha.automation.pages.common.AbstractComponent;
import adha.automation.pages.common.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MitraResultPage extends AbstractComponent {

    public MitraResultPage(final WebDriver driver){

        super(driver);
    }

    @FindBy(xpath = "//button[@type='button' and contains(.,'Daftar Sekarang')]")
    public WebElement button_daftar;

    @FindBy(xpath = "//div[contains(@class,'desktop')]//div[contains(@class,'stacked-carousel-responsive-container')]")
    public WebElement carousel_box;

    public void clickDaftar(){
        this.wait.until((driver -> this.button_daftar.isDisplayed()));
        button_daftar.click();
    }
    @Override
    public boolean isDisplayed() {
        return false;
    }

    public void scrollToCarousel(){
        this.actions.moveToElement(this.carousel_box);
        this.actions.perform();
    }
}
