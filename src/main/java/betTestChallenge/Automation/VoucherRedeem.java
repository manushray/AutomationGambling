package betTestChallenge.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
/* This class is used to redeem already generated valid voucher
 * 
 */

public class VoucherRedeem extends SuccessfulBet {
	
	public VoucherRedeem(WebDriver driver) {
			super(driver);
			this.driver=driver;		
	}
	
	public boolean redeemVoucher() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		menubtn.click();
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		withdrawbtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		withdrawvouchertab.click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		vouchernumber=vouchernumberlocation.getText();
		System.out.println("The voucher Number:"+vouchernumber);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url")+"voucher");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		inputvoucherfield.sendKeys(vouchernumber);
		activateVoucherbtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String activationmessage=vouchervalidationmsg.getText();
		boolean flag=false;
		if(activationmessage.contentEquals("Voucher activation")) {
		flag=true;
		accntBalVoucherMethod(prop.getProperty("withdrawal_amount_success_vouhcer"));
		UserAccountStatement usraccntstatement=PageFactory.initElements(driver, UserAccountStatement.class);
		usraccntstatement.statementMethod();
		}
		return flag;
	}
}
