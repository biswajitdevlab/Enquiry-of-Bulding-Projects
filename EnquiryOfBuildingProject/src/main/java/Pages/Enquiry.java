package Pages;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;
import Base.Base;

public class Enquiry extends Base{
	WebDriverWait wait;
	
	//To Open the URL
    public void OpenUrl(){
	driver.get("https://www.ishahomes.com/");
	}
    
        //Enquiry form fill up and pop up handle and check if enquiry button is working
	    public void projects() throws InterruptedException, IOException ,IndexOutOfBoundsException{
    	wait = new WebDriverWait(driver,30);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='close']")));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='myModal']"))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@class='close']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Enquire Now')]")));
        driver.findElement(By.xpath("//div[@class='ml-30 menu-btn enq-text']")).click();
    	driver.findElement(By.xpath("//a[@class='btn shadow-primary btn-primary property-btn blinking buy-enq-btn']")).click();
    	driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Narendra");
    	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("narendra234@gmail.com");
    	driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys("8765769082"); 
    	//Selecting the value from the drop down
		Select project = new Select(driver.findElement(By.name("sell_do[form][lead][project_id]")));
		project.selectByVisibleText("Isha Avni");
	  
		WebElement option_selected = project.getFirstSelectedOption();
	    System.out.println("The selected project in the enquiry form is : "+option_selected.getText());
	    //Selecting how you hear about us
	       
	    Select link = new Select(driver.findElement(By.name("sell_do[form][lead][sub_source]")));
		link.selectByVisibleText("Google");
		WebElement option_selected1 = link.getFirstSelectedOption();
	    System.out.println("How did you hear about us? : "+option_selected1.getText()); 

	    //extract number of projects in the form and number of platform where you got about the company?

	      Select scroll = new Select(driver.findElement(By.name("sell_do[form][lead][project_id]")));
	       List<WebElement> ss = scroll.getOptions();
	       Select scroll1 = new Select(driver.findElement(By.name("sell_do[form][lead][sub_source]")));
	       List<WebElement> ss1 = scroll1.getOptions();
	       System.out.print("The number of available projects in the form are : ");
	       System.out.println(ss.size());
	       System.out.print("Number of platform where you know about us : ");
	       System.out.println(ss1.size());
	    driver.findElement(By.xpath("//input[@value='Enquire Now']")).click();
	    //email address to contact
	    String text=driver.findElement(By.xpath("//div[@class='icon-bx-wraper left']//div[@class='icon-content']//p[@class='m-b0']//a[@href='mailto:marketing@ishahomes.com'][normalize-space()='marketing@ishahomes.com']")).getText();
	    Thread.sleep(5000);
	    System.out.println("Email info:" + text);
	    //Verification of contact info 
    	String text1=driver.findElement(By.xpath("//div[@class='row mt50']//h4[contains(text(),'Contact Info')]")).getText();
    	System.out.println( text1 +": Verified" );
    	
    	driver.findElement(By.xpath("//i[@class='fa fa-times side-close menu-close scale3']")).click();
    	Thread.sleep(3000);
    	//Navigate to completed project section and print of first five projects
    	driver.findElement(By.xpath("//span[normalize-space()='Completed Projects']")).click();
    	 //Screenshot of completed project section in the begin
    	TakesScreenshot capture = (TakesScreenshot) driver;
    	File srcFile = capture.getScreenshotAs(OutputType.FILE);
    	File destFile = new File(System.getProperty("user.dir")
    			+ "/Screenshot/completedprojectbeginningpage.png");
    	Files.copy(srcFile, destFile);
    	//scrolling of page in completed section
    	JavascriptExecutor jse=(JavascriptExecutor)driver;
    	jse.executeScript("window.scrollBy(0,5000)","");
    	//First five completed projects
    	System.out.println("List of first five completed projects are: ");
    		System.out.println("Project 1: " + driver.findElement(By.cssSelector("body > div:nth-child(2) > section:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h5:nth-child(1) > a:nth-child(1)")). getAttribute("textContent"));
    		String text2=driver.findElement(By.xpath("//a[contains(text(),'Isha Aarmabha')]")).getAttribute("textContent");
    		System.out.println("Project 2: " + text2);
    		String text3=driver.findElement(By.xpath("//a[normalize-space()='Isha Armonia']")).getAttribute("textContent");
    		System.out.println("Project 3: " + text3);
    		String text4=driver.findElement(By.xpath("//a[normalize-space()='Isha Aabhirupam']")).getAttribute("textContent");
    		System.out.println("Project 4: " + text4);
    		String text5=driver.findElement(By.xpath("//a[normalize-space()='Isha Aara']")).getAttribute("textContent");
    		System.out.println("Project 5: " + text5);
    		//Total number of completed projects
    		List<WebElement> apartments = driver.findElements(By.className("unit"));
    		int count = apartments.size();
    		System.out.println("Total completed projects:" +count);
    		//List of total units from each completed projects are
    		List<String> linkstext= new ArrayList<String>();
    		List<WebElement> comprj = driver.findElements(By.className("unit"));
    		for(WebElement webele :comprj ) {
    			linkstext.add(webele.getAttribute("textContent"));
        	}
    		System.out.println("The list of total units from each projects are  " + linkstext);
        //Screenshot of completed project section in the end
    	TakesScreenshot capture1 = (TakesScreenshot) driver;
    	File srcFile1 = capture1.getScreenshotAs(OutputType.FILE);
    	File destFile1 = new File(System.getProperty("user.dir")
    			+ "/Screenshot/completedprojectendpage.png");
    	Files.copy(srcFile1, destFile1);
    	driver.quit();
    	}
    	

    //To execute all methods
    public static void main(String[] args) throws InterruptedException, IndexOutOfBoundsException, IOException{
  		Enquiry s= new Enquiry();
  		s.driverSetup();
  		s.OpenUrl();
  		s.projects();
  		s.closeBrowser();
  	
 
  	
  	}

  	}

