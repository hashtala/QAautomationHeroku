package mypac;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.awt.Point;


public class ImgShift extends PageObject{


    @FindBy(className = "shift")
    private WebElement image;

    @FindBy(xpath = "//*[@id='content']/div/p[3]/a")
    private WebElement shiftButton;
    

    public ImgShift(WebDriver driver){
        super(driver);
    }


    public int getXLocation(){
        return this.image.getLocation().getX();
    }

    public int getYLocation(){
        return this.image.getLocation().getY();
    }

    public void printLocation(){
        System.out.println(getXLocation());
        System.out.println(getYLocation());    // works correctly whatever
    }
    

    public void clickShift(){
        this.shiftButton.click();
    }

    public void asssertShift(){
        int xPrev = getXLocation();
        int yPrev = getYLocation();

        this.clickShift();

        int xCurr = getXLocation();
        int yCurr = getYLocation();

        Point prevLoc = new Point(xPrev, yPrev);
        Point currLoc = new Point(xCurr, yCurr);
        
        Assert.assertNotEquals(prevLoc, currLoc);
        System.out.println("ASSERTED NOT EQUAL SUCCESFULLY");
    }

    


}