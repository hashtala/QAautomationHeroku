package mypac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FileUpload extends PageObject{

   

    private final String fileLocation = "C:\\Users\\Giorgi\\Downloads\\Tsintsadze_CV.pdf";

    

    @FindBy(id = "file-upload")
    private WebElement inputPath;

    @FindBy(id = "file-submit")
    private WebElement submitButton;

    public  FileUpload(WebDriver driver){
        super(driver);
    }

    public void enterPath(){
        this.inputPath.sendKeys(fileLocation);
    }

    public void clickSubmit(){
        this.submitButton.click();
        String response = driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText();
        System.out.println(response);
        Assert.assertEquals(response, "File Uploaded!");
    }
 
}