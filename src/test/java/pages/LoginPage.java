package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='login_name']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='login_password']")
    private WebElement password;

    @FindBy(xpath = "//*[@id='login-validate']/div[@class='submit_sect']//button[@class='btn btn-beoro-1']")
    private WebElement loginButton;


    @FindBy(xpath = "//strong[@style='font-weight: bold;']")
    private WebElement errorInvalidLoginCredentials;

    public String getErrorTextOfLoginPage() {

        return errorInvalidLoginCredentials.getText();

    }

    @Step("Opening Login Page")
    public LoginPage openPage(String url) {
        driver.get(url);

        return this;
    }

    @Step("Fill username Field")
    public LoginPage fillInEmail(String keyEmail) {
        waitVisibilityOf(email).clear();
        email.sendKeys(keyEmail);
        return this;
    }

    @Step("Fill password Field")
    public LoginPage fillInPassword(String keyPassword) {
        password.clear();
        password.sendKeys(keyPassword);

        return this;
    }

    @Step("Click button Login")
    public void clickLoginButton() {

        waitElementToBeClickable(loginButton).click();
    }
}
