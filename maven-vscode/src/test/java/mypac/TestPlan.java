
package mypac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
            System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test            
    public static void submitForm(){
        driver.get(Utils.BASE_URL_FORM);
        WebForm webForm = new WebForm(driver);
        webForm.enterFirstName();
        webForm.enterLastName();
        webForm.pressSubmitButton();
    }


    
    @Test
    public static void submitWrongForm(){
        driver.get(Utils.BASE_URL_FORM);
        WebForm webForm = new WebForm(driver);
        webForm.enterFalseName();
        webForm.enterLastName();
        webForm.pressSubmitButton();
    }

    @Test
    public static void uploadFile(){
        driver.get(Utils.BASE_URL_FILEUPLOAD);
        FileUpload fileUpload = new FileUpload(driver);
        fileUpload.enterPath();
        fileUpload.clickSubmit();
    }     
    
    @Test
    public static void checkImage(){
        driver.get(Utils.BASE_URL_IMGSHIFT);
        ImgShift imgShift = new ImgShift(driver);
        imgShift.asssertShift();
    }


    @Test
    public static void checkDesignChange(){
        driver.get(Utils.BASE_URL_MENU);
        MenuShift menuObj = new MenuShift(driver);
        menuObj.assertDesignChange();
    }

    @Test
    public static void checkTableDOM(){
        driver.get(Utils.BASE_URL_TABLEDOM);
        TableDOM tableDOM = new TableDOM(driver);
        tableDOM.getContentRow();
    }

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}