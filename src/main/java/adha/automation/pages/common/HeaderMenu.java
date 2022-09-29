package adha.automation.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractComponent  {

    @FindBy(className = "MuiToolbar-root")
    private WebElement menu_box;

    @FindBy(xpath = "//header//*[@alt='gravel']")
    private WebElement home;

    @FindBy(xpath = "//a[contains(@href,'/mitra')]")
    private WebElement mitra_lang_id;

    @FindBy(xpath = "//a[contains(@href,'en/mitra')]")
    private WebElement mitra_lang_en;

    @FindBy(xpath = "//a[contains(@href,'/blog')]")
    private WebElement inspirasi_lang_id;

    @FindBy(xpath = "//div[contains(@class,'MuiBox-root')] // a[contains(@href,'https://careers.smartrecruiters.com/gravel')]")
    private WebElement karir;

    @FindBy(xpath = "//div[contains(@class,'desktop')] // a[contains(@href,'https://play.google.com/store/apps/details?id=com.graveltechnology.owner')]")
    private WebElement google_desktop;

    @FindBy(xpath = "//div[contains(@class,'desktop')] // a[contains(@href,'https://apps.apple.com/id/app/gravel/id1586769860?l=id')]")
    private WebElement appstore_desktop;

    @FindBy(xpath = "//div[contains(@class,'MuiInput-root')]//a[text()='ID']")
    private WebElement language_id;

    @FindBy(xpath = "//a[contains(@href,'/en')]")
    private WebElement switch_en;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public void goToHome(){
        this.home.click();
    }

    public void goToMitra(){
        this.wait.until((driver -> this.mitra_lang_id.isDisplayed()));
        this.mitra_lang_id.click();
    }

    public void goToInspirasi(){
        this.inspirasi_lang_id.click();
    }

    public void goToKarir(){
        this.karir.click();
    }

    public void goToPlayStore(){
        this.google_desktop.click();
    }

    public void goToAppStore(){
        this.appstore_desktop.click();
    }

    public void clickLanguage(){
        this.language_id.click();
    }

    public void switchLanguage(){
        this.switch_en.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((driver -> this.menu_box.isDisplayed()));
    }

    public String MenuEnglish(){
        this.wait.until((driver -> this.mitra_lang_en.isDisplayed()));
        return mitra_lang_en.getText();
    }
}
