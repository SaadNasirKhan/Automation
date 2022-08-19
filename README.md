
package zaryab;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;


public class NewTest 
{

	WebDriver driver=null; //Initializing WebDriver with Null
	@BeforeSuite
	public void setup()//setting up chrome
	{
		System.out.println("Set up system property for chrom");
	}

	@BeforeClass// not
	public void LanuchBrowser()
	{
		System.out.println("Lanuch Browser");
		String tittle=driver.getTitle();
		Assert.assertEquals(tittle,"omayo (QAFox.com)","TEST FAILED, Site not opened");
	}

	@BeforeTest
	public void SetUp()
	{
		System.setProperty("webdriver.chrome.driver","C://Users//lenovo//Desktop//driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.in/");
	}
	// @BeforeMethod
	// void GoToWebsite()
	// {
		// driver.get("https://omayo.blogspot.in/");
	// }
	@Test(priority=1)
	void Textfield()
	{
		driver.findElement(By.id("ta1")).sendKeys("Zaryab ali Rana");
		WebElement text = driver.findElement(By.xpath("//textarea[contains(text(),'The cat')]"));
		System.out.println(text.getText());
		Assert.assertTrue(driver.findElement(By.id("ta1")).getText()!=null,"TEST FAILED, Name not entered");
		text.clear();
		text.sendKeys("I am a programmer");
	}
	@Test(priority=2)
	void TableAndLogin()
	{
		List <WebElement> table= driver.findElements(By.xpath("//div[@class='widget-content']//table"));
		for (WebElement element : table )
		{
			System.out.println(element.getText());
 
		}
		driver.findElement(By.xpath("//form[@name='form1']//child::input[1]")).sendKeys("Zaryan Rana");
		driver.findElement(By.xpath("//form[@name='form1']//child::input[2]")).sendKeys("12345678*$_90");	
		driver.findElement(By.xpath("//button[ @value='LogIn']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//form[@name='form1']//child::input[1]")).getText()!=null && driver.findElement(By.xpath("//form[@name='form1']//child::input[2]")).getText()!=null,"TEST FAILED, Username and Password can not be blank");
	}
	@Test(priority=3)
	void FrameAndLogin()
	{
		//Frame
		Actions act=new Actions(driver);
		driver.switchTo().defaultContent();
		WebElement frame1= driver.findElement(By.xpath("//div[@class=\"widget-content\"]/iframe[1]"));
		driver.switchTo().frame(frame1);
		//act.contextClick();
		driver.switchTo().defaultContent();
		WebElement frame2= driver.findElement(By.xpath("//div[@class=\"widget-content\"]/iframe[2]"));
		driver.switchTo().frame(frame2);
		//act.contextClick();
		driver.switchTo().defaultContent();
		//act.sendKeys(Keys.PAGE_DOWN).build().perform();
		//login
		driver.findElement(By.xpath("//input[@name=\"userid\"]")).sendKeys("Zaryab Ali Rana");
		driver.findElement(By.xpath("//input[@name=\"pswrd\"]")).sendKeys("12345678910");
		driver.findElement(By.xpath("//form[@name='login']//child::input[3]")).click();
		
		//Simple Alter after login
		Alert simple_alert=driver.switchTo().alert();
		Assert.assertTrue(simple_alert!=null, "TEST FAILED, ALERT NOT FOUND");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\lenovo\\Desktop");
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		WebElement DoubleClick = driver.findElement(By.xpath("//button[contains(text(),'Double click Here')]"));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(DoubleClick));
		act.doubleClick(DoubleClick).build().perform();
		Alert simple_alert2=driver.switchTo().alert();
		try
		{
			Thread.sleep(2000);
			simple_alert2.accept();
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[contains(text(),'Check this')]")).click();
		WebElement Elementtobeclicked =driver.findElement(By.xpath("//input[@id='dte']"));
		WebDriverWait wait_again= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait_again.until(ExpectedConditions.elementToBeClickable(Elementtobeclicked));
		Elementtobeclicked.click();
		Assert.assertTrue(Elementtobeclicked.isSelected(),"TEST FAILED, checkbox not checked");
	}

	@Test(priority=5)
	void RightSide() throws InterruptedException
	{
		Actions act=new Actions(driver);

		//Radio button
		driver.findElement(By.xpath("//input[@id='radio1']")).click();
		//Prompt Alert
		driver.findElement(By.xpath("//input[@id='prompt']")).click();
		Alert promptAlert=driver.switchTo().alert();
		System.out.println(promptAlert.getText());
		//promptAlert = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
		promptAlert.sendKeys("Zaryab");
		promptAlert.accept();
		System.out.println(driver.findElement(By.xpath("//input[@id='prompt']")).getText());

		//Confermation Alert
		driver.findElement(By.xpath("//input[@id='confirm']")).click();
		Alert ConfermationAlert=driver.switchTo().alert();
		Assert.assertTrue(ConfermationAlert!=null, "TEST FAILED, Alert not found");
		Thread.sleep(2000);
		ConfermationAlert.dismiss();
		WebElement readme=driver.findElement(By.xpath("//input[@value='ReadThisText']"));
		String readmeonly=readme.getAttribute("value");
		System.out.println("Text in Box is:"+readmeonly);
		driver.findElement(By.xpath("//input[@type='text' and @name=\"textboxn\"]")).sendKeys("By Attribue");
		driver.findElement(By.xpath("//input[@value='SameIDName']")).click();
		List <WebElement> code=driver.findElements(By.xpath("//input[@type='text' and @class='classone']"));
		for(WebElement send: code)
		{
			send.sendKeys("ABVCD");
		}
		//driver.findElement(By.xpath("//input[@type='text' and @class='classone']")).sendKeys("Zaryab" ,Keys.TAB,"Rana" );
		driver.findElement(By.xpath("//input[@id='sa']")).click();
		driver.findElement(By.xpath("//input[@name='vehicle'][3]")).click();

		driver.findElement(By.xpath("//input[@value='Book']")).click();
		driver.findElement(By.xpath("//input[@value='Bag']")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("//input[@value='Book']")).click();

		WebElement DB=driver.findElement(By.xpath("//p[contains(text(),'Double-click')]"));
		act.doubleClick(DB).build().perform();

		WebElement flipkart=driver.findElement(By.xpath("//a[contains(text(),'Flipkart')]"));
		act.moveToElement(flipkart).build().perform();
		flipkart.click();
	}
	@AfterTest
	void QuitBrowser()
	{
		//Quitting Driver
		driver.quit();
	}

}
