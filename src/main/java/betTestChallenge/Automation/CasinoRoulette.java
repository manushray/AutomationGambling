package betTestChallenge.Automation;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

/*
 * This class handle the casio test case where user place a bet and he will either win or lose accordingly the amount should be updated accordingly
 */

public class CasinoRoulette extends SuccessfulBet {
	private static double amntchip;
	private static double camnt;
	
	public CasinoRoulette(WebDriver driver) {
			super(driver);
			this.driver=driver;		
	}
	
public void casinoMethod() throws ElementNotVisibleException,InterruptedException {
		
		Thread.sleep(2000);
		casinobtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		leftmenulinkMethod("/casino/lr");		
		Thread.sleep(2000);
		chipbtn.click();
		String currBal=odometerbalAccnt.getText();
		currBal=currBal.replace("\n", "").replace("\r", "");
		nineplacebtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		blackplacebtn.click();
		evenplacebtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		evenplacebtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		spinbtn.click();
		Thread.sleep(10000);
		String availBal=odometerbalAccnt.getText();
		availBal=availBal.replace("\n", "").replace("\r", "");
		System.out.println("The Balance before Bet was:"+currBal);
		System.out.println("The Available balance:"+availBal);
		
		double abal=Double.parseDouble(availBal);
		double cbal=Double.parseDouble(currBal);
		amntchip=Double.parseDouble(prop.getProperty("Amount_bet_casino"));
		abal=cbal-amntchip;
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
		try {
		String value =wonamntmethod();
		value=value.replace("\n", "").replace("\r", "").replaceAll(" ","");
		Thread.sleep(2000);
		System.out.println("The value from won method:"+value);
		System.out.println("Won/Lose value:"+value);
		
		if(value.isEmpty())
		{
			System.out.println("Bet Lost & Current Bal:"+abal);
		}
		else {

			System.out.println("The Cash Amount won:"+value);
			camnt=Double.parseDouble(value);
			System.out.println("You won & Current Bal:"+(abal+camnt));
			
		}}catch(Exception e) {
			System.out.println("Bet Lost & Current Bal:"+abal);
		}
		
		
	}

}
