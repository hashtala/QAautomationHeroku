package mypac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class WebForm extends PageObject{

    private final String USERNAME = "tomsmith";
    private final String PASSWORD = "SuperSecretPassword!";


    @FindBy(id = "username")
    private WebElement username;


    @FindBy(id = "password")
    private WebElement password;

    @FindBy(className = "fa-sign-in")
    private WebElement submit_button;

    public WebForm(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(){
        this.username.sendKeys(USERNAME);
    }

    public void enterLastName(){
        this.password.sendKeys(PASSWORD);
    }

    public void enterFalseName(){
        this.username.sendKeys("WRONG USERANEM");
    }

    public void pressSubmitButton(){
        this.submit_button.click();
       
       /*
        boolean isSuccess = driver.findElement(By.className("success")).isDisplayed();
        Assert.assertEquals(isSuccess, true);
        */

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "http://the-internet.herokuapp.com/secure");
        System.out.println(currentURL);
    }
}