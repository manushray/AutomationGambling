package betTestChallenge.Automation.codeBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import betTestChallenge.Automation.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;

/*THIS IS MY BASE CLASS WHERE I AM INITITIALISING THE DRIVER, EXPLICIT WAIT METHOD,PATH OF CONFIG PROPERTIES
 * FINDING OF ELEMENT BY THEIR TAG NAME,CLASS IN DYNAMIC MANNER, WHERE USER CAN SEARCH ON TEXT BASIS
 * FINDING OF EVENT MATCH BY NAME CONFIGURED IN CONFIG.PROPERTIES USING SELECTION,TIME 
 */

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger log= LogManager.getLogger(Base.class);
	private static WebElement ele;
	public static EventFiringWebDriver eventFiring_driver;
	public static WebEventListener eventListener;
	
	@FindBy(id = "secondarySlot")
	WebElement loginlink;

	public  void initialisation() throws Exception {
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		
		try {
			prop =new Properties();
			
			FileInputStream ip= new FileInputStream("./src/main/java/betTestChallenge/Automation/Configuration/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}	
		
		String browserName=  prop.getProperty("browser");
		if(browserName.equals("chrome")) {

			driver= new ChromeDriver();	
		}else if(browserName.equals("FF")) {

			driver= new FirefoxDriver();
		}
		
		
		eventFiring_driver = new EventFiringWebDriver(driver);

		eventListener = new WebEventListener();

		eventFiring_driver.register(eventListener);

		driver = eventFiring_driver;
		
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		log.info("log is working fine and coming in base Class");
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		loginlink.click();
				
	}
	
	
	
	
	
	public void optionclickMethod(String Value) {
		List<WebElement> elements = driver.findElements(By.className("event-match"));
		for(WebElement wb : elements) {
			if(wb.getAttribute("href").contains(Value)) {
				wb.click();
				System.out.println("Code is coming optionclick method");
				break;
			}
		}
		
	}
	
	public void multibetMethod(String Value) throws InterruptedException {
		List<WebElement> elements = driver.findElements(By.tagName("span"));
		for(WebElement wb : elements) {
			Thread.sleep(2000);
			if(wb.getText().contains(Value)) {
				wb.click();
				System.out.println("Code is coming in multibet method");
				break;
			}
		}
		
	}
	
	
	public void leftmenulinkMethod(String Value) {
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		for(WebElement wb : elements) {

			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			if(wb.getAttribute("href").contains(Value)) {

				wb.click();
				
				System.out.println("Code is coming leftmenulink method");
				break;
			}
		}
		
	}
	
	public void betplaceMethod(String Value) {
		List<WebElement> elements = driver.findElements(By.className("event-match"));
		for(WebElement wb : elements) {
			if(wb.getAttribute("href").contains(Value)) {
				wb.click();
				
				System.out.println("Code is coing optionclick method");
				break;
			}
		}
		
	}
	
	public String wonamntmethod() throws InterruptedException {
		
		List<WebElement> elements = driver.findElements(By.tagName("div"));
		for(WebElement wb : elements) {
			if(wb.getAttribute("class").contains("msg")) {
				wb.click();
				Thread.sleep(2000);
				ele=wb.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[4]/div/div/div[2]"));
				
				break;
			}
		}
		return ele.getText();
	}
	
	public boolean errorstatusmessagemethod(String textmsg) {
		List<WebElement> elements = driver.findElements(By.tagName("div"));
		boolean flag=false;
		for(WebElement wb : elements) {
			if(wb.getText().contains(textmsg)) {
				
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	public void oneXTwoMethod() throws InterruptedException {
		Thread.sleep(2000);
		WebElement onxtwo=driver.findElement(By.xpath("//h3[contains(text(),'"+prop.getProperty("event")+"')]"));
		WebElement Fulltime=onxtwo.findElement(By.xpath("//h4[contains(text(),'"+prop.getProperty("which_time")+"')]"));
		waitMethod(Fulltime);
		Fulltime.click();
		Thread.sleep(2000);
		
		WebElement eventselection=Fulltime.findElement(By.xpath("//span[contains(text(),'"+prop.getProperty("event_selection")+"')]"));
		
		System.out.println("WebElement in onxtwo:"+onxtwo.getText());
		System.out.println("WebElement in Fulltime:"+Fulltime.getText());
		
		waitElementTobeClickMethod(eventselection);
		eventselection.click();
	}
	
	
	public void placingbetoptionMethod(String event,String eveselection) throws InterruptedException {
		Thread.sleep(3000);
		WebElement onxtwo=driver.findElement(By.xpath("//h3[contains(text(),'"+event+"')]"));
	
		WebElement Fulltime=onxtwo.findElement(By.xpath("//h4[contains(text(),'"+prop.getProperty("which_time")+"')]"));
		waitMethod(Fulltime);
		Fulltime.click();
		Thread.sleep(2000);
		
		WebElement eventselection=Fulltime.findElement(By.xpath("//span[contains(text(),'"+eveselection+"')]"));

		System.out.println("WebElement in onxtwo:"+onxtwo.getText());
		System.out.println("WebElement in Fulltime:"+Fulltime.getText());
		
		waitElementTobeClickMethod(eventselection);
		eventselection.click();
	}
	
	
	
	
	public void waitMethod(WebElement wb ) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(wb));
	}
	
	public void waitframeswitchtMethod(WebElement wb ) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(wb));
	}
	
	public WebElement waitElementTobeClickMethod(WebElement wb ) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		return wait.until(ExpectedConditions.elementToBeClickable(wb));
	}
	
	public void waitUrlContainMethod(String str ) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.urlContains(str));
	}


}
