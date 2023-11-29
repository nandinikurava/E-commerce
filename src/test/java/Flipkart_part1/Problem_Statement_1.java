package Flipkart_part1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Problem_Statement_1 
{
	public static WebDriver  cDriver;
//here I am using this elements we use in all methods
// This is for Phones list
	List<WebElement> mobilePhones;
// This is for Prices list
    List<WebElement> mobilePrice;
    int list; //size of the list for number of phones or prices 
    @Test(priority = 1)
	public  void setup() throws InterruptedException, AWTException
	{
///Launch Chrome Browser
	    cDriver= new ChromeDriver();
//Get into the Flipkart URL "https://www.flipkart.com/ "
		cDriver.get("https://www.flipkart.com/");
		//specific wait time
		Thread.sleep(4000);
// Maximize the browser
		cDriver.manage().window().maximize();
// here i mention implicit wait for synchornization issue
		cDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	@Test(priority = 2)
    public void search() throws AWTException, InterruptedException 
    {
// Click on cross symbol  this will find the ✕ symbol
    	cDriver.findElement(By.xpath("//*[text()='✕']")).click();
    	Thread.sleep(4000);
// This will enter the mention 'Mobile Phone' in search box
    	cDriver.findElement(By.xpath("//*[@name='q']")).sendKeys("Mobile Phone");
    	Thread.sleep(4000);
    			
//Using java robot class
    			
    	 Robot r = new Robot();//Enter
    	 r.keyPress(KeyEvent.VK_ENTER);
    	 r.keyRelease(KeyEvent.VK_ENTER);
	}
   @Test(priority = 3)
   public void test_result()
   {
// Fetch all the mobile phones listed in the product listing
	     mobilePhones = cDriver.findElements(By.xpath("//div[@class = '_4rR01T']"));
	     System.out.println(mobilePhones+ "Size of phones");
	     list = mobilePhones.size();
	     for (int i=0;i<=mobilePhones.size()-1;i++)
         {
	    	 //Printing phones with names
		    System.out.println(mobilePhones.get(i).getText());
	     }   
// Fetch all the mobile phones listed in the product listing
        mobilePrice  = cDriver.findElements(By.xpath("//*[@class = '_30jeq3 _1_WHN1']"));
         list = mobilePrice.size();
         System.out.println(list);
         for (int i=0;i<list;i++)
         {
        	//Printing prices with cost
			System.out.println(mobilePrice.get(i).getText());
		 }  
	 }	
   @Test(priority = 4)
   public void WorkSheet_Data() throws IOException 
   {
	   //This is the path for storing data
	   File file = new File("C:\\E_Commerce_project\\src\\test\\resources\\Flipkart_data.xlsx");
	   //Getting a workbook
	   XSSFWorkbook w = new XSSFWorkbook();
	   //For worksheet
	   XSSFSheet sheet = w.createSheet("Flipkart_sheet");
	   //For row
	   XSSFRow r    = sheet.createRow(0);
	   r.createCell(0).setCellValue("phone");
	   r.createCell(1).setCellValue("prices");
	   for(int i=0;i<list-1;i++)
	   {
		   XSSFRow r1 = sheet.createRow(i+1);
		   r1.createCell(0).setCellValue(mobilePhones.get(i).getText());
		   r1.createCell(1).setCellValue(mobilePrice.get(i).getText());
	   }
	  //We have to use this one for output storing
	   FileOutputStream output = new FileOutputStream(file);
	   
	   w.write(output);
	   w.close();
   }
   
 @Test(priority = 5)
   public void tearDown()
   {
	
	   cDriver.close();
   }
}

