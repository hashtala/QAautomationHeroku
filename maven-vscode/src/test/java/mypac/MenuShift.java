package mypac;


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;



public class MenuShift extends PageObject{


    @FindBy(xpath = "//*[@id='content']/div/ul/li[1]/a")
    private WebElement homeButton; 

    public MenuShift(WebDriver driver){
        super(driver);
    }

    public String getHomeButtonFontSize(){
        return this.homeButton.getCssValue("font-size");
    }

    public void hoverOverButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(homeButton, 0, 0).perform();
    }


    public void assertDesignChange(){

        String prevFontSize = getHomeButtonFontSize();
        hoverOverButton();
        String currentFontSize = getHomeButtonFontSize();
        Assert.assertNotEquals(prevFontSize, currentFontSize);
        System.out.println(currentFontSize);
        System.out.println("DESIGN CHANED");

    }




    
    


}