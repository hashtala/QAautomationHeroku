package mypac;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class TableDOM extends PageObject{


    @FindBy(xpath = "//*[@id='content']/div/div/div/div[2]/table/tbody/tr[1]")
    private WebElement row;


    public TableDOM(WebDriver driver){
        super(driver);
    }

    public void getContentRow(){

         int cols = 6; 
         char assertValue = '0';
         String contentRow = this.row.getText(); // Apparently, this gets whole row ... 
         String[] splitedRow = contentRow.split("\\s+");
         for(int i = 0; i < cols; i++)
         {
            char tempChar = splitedRow[i].charAt(splitedRow[i].length() - 1);
            Assert.assertEquals(tempChar, assertValue);
            System.out.println(tempChar);
         }

    }

}