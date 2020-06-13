
import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebDriverGoogleLoginTest {

	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testManualGoogleLogin() {

		// email created for testing - mariana.selenium@gmail.com
		// password - Skill_8_M_3
		
		//go to google.com
		driver.navigate().to("https://google.com");
		
		//find Login button and click on it
		driver.findElement(By.xpath("//*[@id=\"gb_70\"]")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//type it email address
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("mariana.selenium@gmail.com");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//click Next button
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//enter password and click Next
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Skill_8_M_3");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		//click on the User's Avatar
		driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[2]/div[2]/div[1]/a/img")).click();
		
		//verify page contains correct email used for logging in
		String emailText = driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]")).getText();
		assertEquals("mariana.selenium@gmail.com", emailText);

	}

}
