package adha.automation.pages.result;

import adha.automation.pages.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlayStoreResultPage extends AbstractComponent {

    public PlayStoreResultPage(final WebDriver driver){

        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Gravel - Gampang Cari Tukang')]")
    private WebElement titleAppOwner;

    @FindBy(xpath = "//h2[@class='product-header__subtitle app-header__subtitle']")
    private WebElement titleAppOwner_ios;

    @FindBy(xpath = "//span[contains(text(),'Gravel Dulur - Untuk Tukang')]")
    private WebElement titleAppTukang;

    @Override
    public boolean isDisplayed() {
        return false;
    }

    public String getTitleAppOwner(){

        this.wait.until((driver -> this.titleAppOwner.isDisplayed()));
        return titleAppOwner.getText();
    }

    public String getTitleAppOwnerIos(){

        this.wait.until((driver -> this.titleAppOwner_ios.isDisplayed()));
        return titleAppOwner_ios.getText();
    }

    public String getTitleAppTukang(){

        this.wait.until((driver -> this.titleAppTukang.isDisplayed()));
        return titleAppTukang.getText();
    }
}
