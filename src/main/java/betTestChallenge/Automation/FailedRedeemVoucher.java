package betTestChallenge.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

/* This class handle the voucher generated in the Uganda currency and trying to redeem it in the Kenya site.
 */

public class FailedRedeemVoucher extends SuccessfulBet {
	
	public FailedRedeemVoucher(WebDriver driver) {
			super(driver);
			this.driver=driver;		
	}
	
	public boolean failedredeemVoucher() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url_ken"));
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		loginMethod(prop.getProperty("user_ken"),prop.getProperty("user_pwd"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		inputvoucherfield.sendKeys(vouchernumber);
		
		activateVoucherbtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean flag=errorstatusmessagemethod(prop.getProperty("invalid_currency_message"));
		if(flag==true) {
		System.out.println("Failed redeem voucher message showned");
		flag=true;
		}else {
			flag=false;
			System.out.println("Failed redeem voucher message not showned");
		}
		return flag;
	}
	

}
