package betTestChallenge.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/* This class deposit the amount and then create a voucher and check the same in the statement along side maintain the account balance
 * This class handle for the test case scenario for sufficient amount for withdrawing the voucher and insufficient amount
 */

public class WithdrawalVoucher extends SuccessfulBet {
	
	public WithdrawalVoucher(WebDriver driver) {
			super(driver);
			this.driver=driver;	
			
	}

public void successfulDepositMethod() throws InterruptedException {
		
		Thread.sleep(2000);
		menubtn.click();

		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		depositmenubtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		depositfield.sendKeys(prop.getProperty("deposit_amount"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		depositbtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		accntBalVoucherMethod(prop.getProperty("deposit_amount"));
		if(depositnotify.isDisplayed()) {
			System.out.println("Amount has been deposited");
			System.out.println("Avail. Bal:"+accnt_bal_after_deposit);

			
		}
		
	}
	
	public boolean successfulWithdrawalMethod(String withdrawalAmount) throws InterruptedException {
		

		successfulDepositMethod();
		
		menubtn.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		withdrawbtn.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		withdrawvouchertab.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		withdrawvoucherfield.sendKeys(withdrawalAmount);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		createvoucherbtn.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		accntBalMethod(withdrawalAmount);
		Thread.sleep(2500);
		boolean flag=errorstatusmessagemethod(prop.getProperty("withdrawal_notify_error"));
		if(flag==false) {
		
		vouchernumber=vouchernumberlocation.getText();
		System.out.println("The voucher Number:"+vouchernumber);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		UserAccountStatement usraccntstatement=PageFactory.initElements(driver, UserAccountStatement.class);
		usraccntstatement.statementMethod();
		}else {
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			String notifyerrmessage= withnotifyerror.getText();
			System.out.println("Notify error message is:"+flag+" " +notifyerrmessage);
			
		}
		return flag;
	}
	
	
}
