 package Test_Selenium.Building_a_Sample;
 
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class addcomputer  
{
  @Test
  public static void addnewcomputer()
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
        WebElement Com_Name=driver.findElement(By.id("name"));
      //sending the value to variable
        Com_Name.sendKeys("Lenova1.0");
      //assigning the value to the string variable to use later
        String comval=Com_Name.getAttribute("value");
      //printing the computer name 
        System.out.println("New computer name : " + comval);
      //capturing the element by element name
        WebElement Ind_date=driver.findElement(By.name("introduced"));
      //sending the value to variable
        Ind_date.sendKeys("2008-07-06");
      //capturing the element by element name
        WebElement Dis_date=driver.findElement(By.name("discontinued"));
      //sending the value to variable
        Dis_date.sendKeys("2009-06-04");
      //capturing the dropdown element by element id
        Select company=new Select(driver.findElement(By.id("company")));
      //selecting the dropdown vaule
        company.selectByIndex(3);
        //capturing element by xpath
        WebElement newcom=driver.findElement(By.xpath("//*[@id=\"main\"]/form/div/input"));
        newcom.click();  
        WebElement searchtext1=driver.findElement(By.id("searchbox"));
      //sending the variable(value already assigned) to the element
        searchtext1.sendKeys(comval);
        String sertx=searchtext1.getAttribute("value");
        //printing the search result
        System.out.println("searhing newly added computer : " +sertx);
        WebElement searchbut=driver.findElement(By.id("searchsubmit"));
        searchbut.click();
        //assigning the table row value to the string innerTExt - setting the expected value
        String innerText=driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr[1]/td[1]")).getText();
        System.out.println("Search result for saved computer : "+innerText);
      //set sleeping time within try catch exception
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//printing the test result
          System.out.println("*******Test Result*******");
        //comparing the expected and actual value and printing test status
          if(innerText.equals(comval))
        	//Assert.assertEquals(innerText, comval, "Assert Failed as the two string are NOT EQUAL");
             System.out.println("Test Passed");
          else
             System.out.println("Test Failed");
        driver.quit();
	}       
    
}
