import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Main {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Users//4078//Desktop/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://s1.demo.opensourcecms.com/wordpress");
		
		driver.findElement(By.id("weblog_title")).sendKeys("saad");
		Thread.sleep(2000);
		driver.findElement(By.id("user_login")).sendKeys("Saad Nasir Khan");
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[contains(@id,'pass1')]")).sendKeys("h#Q!8VUFCMma$198");
		 
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//div[@class='wp-pwd']/button[contains(@class , 'wp-hide-pw')]")).click();		

		 driver.findElement(By.xpath("//input[contains(@id,'admin_email')]")).sendKeys("iamsaadnk@gmail.com");
		 
		 driver.findElement(By.id("blog_public")).click();
		 
		 
		 driver.findElement(By.xpath("//p[@class='step']/input[contains(@class , 'button-large')]")).click();
		
	}

}
