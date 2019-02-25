package betTestChallenge.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/* Code is handling the Invalid Amount while creating the voucher 
 *  Code is validating the Error message which comes and returning the flag accordingly
 * 
 */

public class InvalidWithdrawal extends SuccessfulBet {
	
	public InvalidWithdrawal(WebDriver driver) {
			super(driver);
			this.driver=driver;		
	} 
	
public boolean inValidAmntWithdrawalMethod() throws InterruptedException {
		
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		menubtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		withdrawbtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		withdrawvouchertab.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		withdrawvoucherfield.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		createvoucherbtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		boolean flag=notifysuccessmessage.isDisplayed();
		if(accnt_bal_after_deposit>0)
		{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		UserAccountStatement usraccntstatement=PageFactory.initElements(driver, UserAccountStatement.class);
		usraccntstatement.statementMethod();
		}else {
			
			String notifyerrmessage= withnotifyerror.getText();
			System.out.println("Notify error message is:"+flag+" " +notifyerrmessage);
			
		}
		return flag;	
}
	
	

}
