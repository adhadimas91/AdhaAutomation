package adha.automation.pages.result;

import adha.automation.pages.common.AbstractComponent;
import adha.automation.pages.common.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GravelLandingResultPage extends AbstractComponent {

    public GravelLandingResultPage(final WebDriver driver){

        super(driver);
        this.headerMenu = PageFactory.initElements(driver, HeaderMenu.class);

    }

    private HeaderMenu headerMenu;

    @FindBy(css = ".container-slide")
    public WebElement carousel_box;

    @FindBy(css = ".desktop > .solution-list")
    public WebElement solution_list_box;

    @FindBy(xpath = "//p[contains(@class,'card-solution-title')]")
    public List<WebElement> solution_title;

    @FindBy(css = ".container-slide h2")
    public WebElement title_carousel;

    @Override
    public boolean isDisplayed() {
        return false;
    }

    public void goToCarousel(){
        this.actions.moveToElement(this.carousel_box);
        this.actions.perform();

    }

    public void goToSolution(){
        this.actions.moveToElement(this.solution_list_box);
        this.actions.perform();

    }

    public String getTitleSolution(){

        StringBuilder builder = new StringBuilder();
        for(WebElement e : solution_title) {
            builder.append(e.getAttribute("innerHTML"));
        }

        return builder.toString();
    }

    public int totalSolution(){

        return solution_title.size();
    }

    public String TitleCarousel(){
        return title_carousel.getText();
    }

    public String MenuEnglish(){

        return headerMenu.MenuEnglish();
    }

    public void GotoMitra(){
        headerMenu.goToMitra();
    }
    public void GotoCareer(){headerMenu.goToKarir();}
    public void GotoInspirasi(){headerMenu.goToInspirasi();}

    public void GotoPlayStore(){headerMenu.goToPlayStore();}

    public void GotoAppStore(){headerMenu.goToAppStore();}

    public void PageRefresh(){
        driver.navigate().refresh();
    }

}
