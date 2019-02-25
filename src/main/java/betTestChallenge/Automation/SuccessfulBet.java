package betTestChallenge.Automation;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import betTestChallenge.Automation.codeBase.Base;

/* This class is used as a page object library where I am storing all the web element object
 * and code for placing single bet test scenario & multiple bet test scenario
 * Also I am maintaining the Account details method whenever there is debit or credit of amount comes into picture
 * 
 */

public class SuccessfulBet extends Base
{
	protected WebDriver driver;
	public static String Accnt_Bal;
	public static float account_balance;
	public static float accnt_bal_after_deposit;
	public static UserAccountStatement usraccntstatement;
	public static String vouchernumber;
	private boolean flag;
	
	
	
	@FindBy(id="input_phone")
	WebElement userphn;
	
	@FindBy(id="input_password")
	WebElement userpwd;
	
	@FindBy(id = "secondarySlot")
	WebElement loginlink;
	
	@FindBy(className="button-green-full")
	WebElement loginbtn;
	
	@FindBy(name="stake-input")
	WebElement yourstakebtn;
	
	@FindBy(id="Main-Menu-Button")
	WebElement menubtn;
	
	@FindBy(id="deposit-menu-top")
	WebElement depositmenubtn;
	
	@FindBy(id="deposit_init_amount")
	WebElement depositfield;
	
	@FindBy(name="Submit-Deposit-Request")
	WebElement depositbtn;
	
	@FindBy(className="button-green-full")
	WebElement depositnotify;
	
	@FindBy(id="withdraw-menu-top")
	WebElement withdrawbtn;
	
	@FindBy(id="withdraw-to-voucher")
	WebElement withdrawvouchertab;
	
	@FindBy(name="Input-Amount")
	WebElement withdrawvoucherfield;
	
	@FindBy(name="Submit-Payout")
	WebElement createvoucherbtn;
	
	@FindBy(css="#Payout-Form > div.notify.error")
	WebElement withnotifyerror;
	
	@FindBy(id="statement-menu-top")
	WebElement statmntbtn;
	
	@FindBy(css="#bet_initial > div.bp-slip-top.clearfix > div > span.count.bold")
	WebElement curr_bal;
	
	@FindBy(id="bp-place-bet")
	WebElement placebetbtn;
	
	@FindBy(id="Coupon-Status-Message")
	WebElement betplacednotifymsg;
	
	@FindBy(id="Bp-Bonus-Win-Amount")
	WebElement bonuswinper;
	
	@FindBy(xpath="//a[contains(text(),'bet details here')]")
	WebElement betdetaillink;
	
	@FindBy(className="center-box")
	WebElement notifysuccessmessage;
	
	@FindBy(css="body > div.main-container.bp-after-fixed > div > div.rightside-wide.clearfix > div.leftside > div.events-wrapper > div > div.content-wrapper > div.block-content > table > tbody > tr:nth-child(1)")
	WebElement statentry;
	
	@FindBy(id="home")
	WebElement homebtn;
	
	@FindBy(css="body > div.main-container.bp-after-fixed > div > div.rightside-wide.clearfix > div.leftside > div.events-wrapper > div > div.content-wrapper-down > div.table.summary")
	WebElement tablesummry;
	
	@FindBy(xpath="//table[contains(@class,'statement')]/tbody/tr[1]")
	WebElement statvoucherrow;
	
	@FindBy(xpath="//*[contains(@id,'1162')]/div[2]/div/span")
	WebElement vouchernumberlocation;
	
	@FindBy(css="body > div.main-container.bp-after-fixed > div > div.rightside-wide.clearfix > div.leftside > div.content-wrapper > div:nth-child(3) > h2")
	WebElement vouchervalidationmsg;
	
	@FindBy(id="input_voucher")
	WebElement inputvoucherfield;
	
	@FindBy(id="activateVoucher")
	WebElement activateVoucherbtn;
	
	@FindBy(xpath="//*[contains(@class,'notify error')]")
	WebElement notifyerrormesaage;
	
	@FindBy(css="#chip500 > picture > img")
	WebElement chipbtn;
	
	@FindBy(css="#hcell-33 > div > div")
	WebElement nineplacebtn;
	
	@FindBy(css="#black-sector-hor > div")
	WebElement blackplacebtn;
	
	@FindBy(css="#hcell-even > div")
	WebElement evenplacebtn;
	
	@FindBy(css="#app > div.main > div:nth-child(3) > div.footer > div.right > button.button.spin")
	WebElement spinbtn;
	
	@FindBy(id="Left-Side-Menu-Casino-Button")
	WebElement casinobtn;

	@FindBy(css="#app > div.main > div:nth-child(2) > div.header > div > div > div > span.balance.slow-up.instant-down.with-shadow.hide-last-digit.odometer.odometer-auto-theme > div")
	WebElement odometerbalAccnt;

	@FindBy(className="event-bet")
	WebElement betbtn;
	
	
	@FindBy(css="#tabs_scrollable > li:nth-child(2) > a")
	WebElement multibet2;
	
	@FindBy(xpath="//a[contains(text(),'BTTS')]")
	WebElement multibet3;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logoutbtn;
	
	@FindBy(xpath="//h2[contains(text(),'Upcoming events')]")
	WebElement sreetext;
	
	public SuccessfulBet(WebDriver driver) {
		
		this.driver=driver;
	    
	  
	}
	
	public void loginMethod(String username,String pwd) throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		userphn.clear();
		userphn.sendKeys(username);
		userpwd.clear();
		userpwd.sendKeys(pwd);
		loginbtn.click();
	//	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
	}
	
	
	public boolean betPlacedMethod(String match) throws InterruptedException  {
		Thread.sleep(1800);
		leftmenulinkMethod("upcoming");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
		betbtn.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		yourstakebtn.sendKeys(prop.getProperty("amnt_bet_placed"));
		placebetbtn.click();
		accntBalMethod(prop.getProperty("amnt_bet_placed"));
		betplacednotifymsg.isEnabled();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		UserAccountStatement usraccntstatement=PageFactory.initElements(driver, UserAccountStatement.class);
		 flag=usraccntstatement.betSlipstatementMethod();
		return flag;
		
	}
	
	
	
	public boolean multibetPlacedMethod() throws InterruptedException {
		String [] strmultievent=prop.getProperty("multi_bet_event").split(",");
		String [] streveselection=prop.getProperty("multi_bet_event_selection").split(",");
		String [] strmultibetmatch=prop.getProperty("multi_bet_match").split(",");
		
		Thread.sleep(2500);
		leftmenulinkMethod("upcoming");
		for(int i=0;i<strmultievent.length;i++) {
		Thread.sleep(2500);

		optionclickMethod(strmultibetmatch[i].toLowerCase().replace(" ","-").replace("---","-"));
		Thread.sleep(2500);
		
		placingbetoptionMethod(strmultievent[i],streveselection[i]);
		yourstakebtn.clear();
		yourstakebtn.sendKeys(prop.getProperty("amnt_bet_placed"));
		

		leftmenulinkMethod("upcoming");
		Thread.sleep(1500);

		}
		
		
		flag=false;
		if(bonuswinper.isDisplayed()) {
		placebetbtn.click();
		accntBalMethod(prop.getProperty("amnt_bet_placed"));
		betplacednotifymsg.isEnabled();
		Thread.sleep(2000);
		flag=true;
		accntBalMethod(prop.getProperty("amnt_bet_placed"));
		
		UserAccountStatement usraccntstatement=PageFactory.initElements(driver, UserAccountStatement.class);
		usraccntstatement.betSlipstatementMethod();
		
		Thread.sleep(2000);
		}
	return flag;	
	}
	
	
	public void accntBalVoucherMethod(String amnt)  {
		Accnt_Bal=curr_bal.getText();
		Accnt_Bal=Accnt_Bal.replaceAll("[^\\d.]", "");
		account_balance=Float.parseFloat(Accnt_Bal);
		float wi_amnt_voucher=Float.parseFloat(amnt);
		accnt_bal_after_deposit=account_balance+wi_amnt_voucher;
		


		  
	}
	
	public void accntBalMethod(String amnt)  {
		Accnt_Bal=curr_bal.getText();
		Accnt_Bal=Accnt_Bal.replaceAll("[^\\d.]", "");
		account_balance=Float.parseFloat(Accnt_Bal);
		float wi_amnt_voucher=Float.parseFloat(amnt);
		accnt_bal_after_deposit=account_balance-wi_amnt_voucher;
		
	}
	
}
