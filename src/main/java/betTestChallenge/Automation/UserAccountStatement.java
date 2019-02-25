package betTestChallenge.Automation;


import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/* THIS METHOD IS USED TO COVER ALL THE SCENARIO OF STATEMENT TAB
 * THAT INCLUDE BET,VOUCHER, & BET SLIP INFORMATION
 * 
 */

public class UserAccountStatement extends SuccessfulBet{
	
	private WebDriver driver;
	private String str;
	private String[] statstring;
	
	
	
	
	public UserAccountStatement(WebDriver driver) {
			super(driver);
			this.driver=driver;		
	}

	
	
	public void statementMethod() throws InterruptedException {
		menubtn.click();
		statmntbtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		List<WebElement> tableRows = statentry.findElements(By.tagName("td"));
		System.out.println(tableRows.size());
		Iterator<WebElement> itr=tableRows.iterator();
		while(itr.hasNext()) {
			WebElement anchor=itr.next();
			if(anchor.getText().contains("Voucher #") ) {
				
			str=	statvoucherrow.getText();

			statstring=str.split("(\\s\\D\\d)");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				System.out.println("The Statement entries are:"+str);
			
				if(str.contains("voucher #") && str.contains(prop.getProperty("withdrawal_amount_vouhcer"))) {
					String title=driver.getTitle();
					System.out.println("Statement redirecte to :"+title);
					
				}
			
		}
			}
		Thread.sleep(2200);
		
		
}
	
	
	public boolean betSlipstatementMethod() {
		menubtn.click();
		statmntbtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		boolean flag=false;
		
		List<WebElement> tableRows = statentry.findElements(By.tagName("a"));
		System.out.println(tableRows.size());
		Iterator<WebElement> itr=tableRows.iterator();
		while(itr.hasNext()) {
			WebElement anchor=itr.next();
			if(anchor.getText().contains("Bet")) {
				anchor.click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			str=	tablesummry.getText();

			statstring=str.split("(\\s\\D\\d)");

				
				System.out.println("The Statement entries are:"+str);
			
				if(str.contains("Potential winnings:") && str.contains(prop.getProperty("amnt_bet_placed"))) {
					String title=driver.getTitle();
					System.out.println("Statement redirecte to :"+title);
					flag=true;
					return flag;
					
					
				}
			
		}
			else {
				flag=false;
				return flag;
			}
			}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return flag;
		
		
}

	
}
