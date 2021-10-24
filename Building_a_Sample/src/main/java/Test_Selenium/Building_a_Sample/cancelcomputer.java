package Test_Selenium.Building_a_Sample;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class cancelcomputer
	 {
	     @Test
	     public static void cancelcomp()
	     {
	    	 //WebDriver setup
	         System.setProperty("webdriver.chrome.driver", "C:\\Software\\Chrome driver\\94\\chromedriver.exe");
	         WebDriver driver=new ChromeDriver();
	         //Maximise the chrome browser
	         driver.manage().window().maximize();
	         //Launching the application url
	         driver.get("http://computer-database.herokuapp.com/computers");
	         //capturing the element by element id
	         driver.findElement(By.id("add")).click();
	         WebElement Com_Name1=driver.findElement(By.id("name"));
	         //sending the value to variable
	         Com_Name1.sendKeys("Dell4.0");
	         //assigning the value to the string variable to use later
	         String comval1=Com_Name1.getAttribute("value");
	         //printing the computer name 
	         System.out.println("New computer name : " +comval1);
	         //capturing the element by element name
	         WebElement Ind_date1=driver.findElement(By.name("introduced"));
	         //sending the value to the element
	         Ind_date1.sendKeys("2009-07-09");
	         //capturing the element by element name
	         WebElement Dis_date1=driver.findElement(By.name("discontinued"));
	         //sending the value to the element
	         Dis_date1.sendKeys("2010-06-04");
	         //capturing the dropdown element by element id
	         Select company1=new Select(driver.findElement(By.id("company")));
	         //selecting the dropdown vaule
	         company1.selectByIndex(3);
	         //set sleeping time within try catch exception
	         try {
	 			Thread.sleep(2000);
	 		} catch (InterruptedException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	         //capturing element by xpath
	         WebElement cancel1=driver.findElement(By.xpath("//*[@id=\"main\"]/form/div/a"));
	         cancel1.click();  
	         //printing the computername to confirm 
	         System.out.println("Cancelling the new computer : " +comval1);
	         //capturing element by id
	         WebElement searchtext2=driver.findElement(By.id("searchbox"));
	         //sending the variable(value already assigned) to the element
	         searchtext2.sendKeys(comval1);
	         String sertx1=searchtext2.getAttribute("value");
	         //printing the search result
	         System.out.println("Searching cancelled computer : " +sertx1);
	         WebElement searchbut1=driver.findElement(By.id("searchsubmit"));
	         searchbut1.click();
	         try {
	 			Thread.sleep(2000);
	 		} catch (InterruptedException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	         //setting the expected value
	         String Expectedsearch="No computers found";
	         //getting the header value and assigning to string
	         String heading=driver.findElement(By.xpath("//*[@id=\"main\"]/h1")).getText();
	         System.out.println("Search result : " +heading);
	         //printing the test result
	         System.out.println("*******Test Result*******");
	         //comparing the expected and actual value and printing test status
	         if(Expectedsearch.equalsIgnoreCase(heading))
	         {
	             System.out.println("Test Passed");
	         }
	         else
	         {
	         System.out.println("Test Failed");
	         }
	         driver.quit();
	     }
	 }


