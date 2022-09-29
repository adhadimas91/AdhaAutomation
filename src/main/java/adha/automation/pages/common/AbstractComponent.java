package adha.automation.pages.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {

    protected Actions actions;
    protected WebDriverWait wait;

    protected WebDriver driver;

    protected JavascriptExecutor js;

    public AbstractComponent(final WebDriver driver){
        this.js = (JavascriptExecutor)driver;
        this.wait = new WebDriverWait(driver, 30);
        this.actions = new Actions(driver);
        this.driver = driver ;
        PageFactory.initElements(driver, this);

    }
    public abstract boolean isDisplayed();
}
