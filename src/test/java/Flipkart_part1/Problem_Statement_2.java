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
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.PublicEncryptionKey;
import org.checkerframework.checker.units.qual.s;
import org.checkerframework.checker.units.qual.t;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Problem_Statement_2 {
	public WebDriver cDriver;
    @Test(priority = 1)
     public void setup() throws InterruptedException, AWTException
      {
	  //Launch Firefox Browser
	  cDriver=new ChromeDriver();
	  //Open a flipkart Url"https://www.flipkart.com/"
	  cDriver.get("https://www.flipkart.com/");
	  Thread.sleep(4000);
	  //Maximize the browser
	  cDriver.manage().window().maximize();
	  cDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
      }
    @Test(priority = 2)
    public void search() throws AWTException 
    {
	//Click on x symbol
	  cDriver.findElement(By.xpath("//*[text()='✕']")).click();
	  cDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	  //Type iphone 12 in search box
	  cDriver.findElement(By.xpath("//*[@name='q']")).sendKeys("iPhone 12");
	  cDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	  //using java robot
	  //enter
	  Robot r = new Robot();
	  r.keyPress(KeyEvent.VK_ENTER);
	  r.keyRelease(KeyEvent.VK_ENTER);
    }
    @Test(priority = 3)
    public void select_Product() throws InterruptedException 
    {
		//select iphone 12
	  cDriver.findElement(By.xpath("//div[text()='APPLE iPhone 12 (Black, 64 GB)']")).click();
	  Set<String> set = cDriver.getWindowHandles();
	  System.out.println(set.size());
	  Iterator<String> i=set.iterator();
	  String parentWindow = i.next();
	  String childWindow = i.next();
	  cDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  cDriver.switchTo().window(childWindow);
	  //Adding into the cart
	  //cDriver.findElement(By.xpath("//*[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
	  //click on Add to cart button
	  cDriver.findElement(By.xpath("//button[text()='Add to cart']")).click();
	  cDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      //Click on login button
	  cDriver.findElement(By.xpath("//*[text()='Place Order']")).click();
	  cDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
	  /*fill email/phone numbers
	  cDriver.findElement(By.xpath("//*[@class='_2IX_2- VJZDxU']")).sendKeys("7382744933");
	  Thread.sleep(4000);
	  //Click on Request OTP
	  cDriver.findElement(By.xpath("//*[text()='Request OTP']")).click();*/
	  
	 
	  


		
