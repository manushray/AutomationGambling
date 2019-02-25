package betTestChallenge.Automation;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import betTestChallenge.Automation.codeBase.Base;


import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest extends Base
{
 
	public static SuccessfulBet sb;
	public static WithdrawalVoucher wv;
	public static InvalidWithdrawal iw;
	public static VoucherRedeem vr;
	public static FailedRedeemVoucher frv;
	public static CasinoRoulette cr;
	private static boolean flag;
	
	
    public AppTest()throws Exception
    {
    	super();
    	initialisation();
    	
    	sb=PageFactory.initElements(driver, SuccessfulBet.class);
    wv=PageFactory.initElements(driver, WithdrawalVoucher.class);
    iw=PageFactory.initElements(driver, InvalidWithdrawal.class);
    vr=PageFactory.initElements(driver, VoucherRedeem.class);
    frv=PageFactory.initElements(driver, FailedRedeemVoucher.class);
    cr=PageFactory.initElements(driver, CasinoRoulette.class);
    sb.loginMethod(prop.getProperty("user_uganda_bal"),prop.getProperty("user_pwd"));
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);    
    }

    @Before
    public void setup()  {
    	driver.manage().deleteAllCookies();
    	System.out.println("Code came to before method");
    }
   
    
	@Test
    public void testCase1() throws InterruptedException 
    {	

    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		String str=prop.getProperty("single_bet_match");
		flag=sb.betPlacedMethod(str.toLowerCase().replace(" ","-").replace("---","-").replace("-","-"));
		Assert.assertEquals(true, flag);
		
    }
    
    
	@Test
    public void testCase2() throws Exception  
    {	

    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    flag=sb.multibetPlacedMethod();
    Assert.assertEquals(true, flag);
    
    }
    
	
	@Test
    public void testCase3() throws Exception  
    {	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		flag=wv.successfulWithdrawalMethod(prop.getProperty("withdrawal_amount_success_vouhcer"));
		Assert.assertEquals(false, flag);
		
        
    }
    
    
	@Test
  public void testCase4() throws Exception  
  {	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		flag=wv.successfulWithdrawalMethod(prop.getProperty("withdrawal_amount_excess_amount_vouhcer"));
		Assert.assertEquals(true, flag);
		
      
  }
	
	
	@Test
    public void testCase5() throws Exception  
    {	
		Thread.sleep(2000);
		flag=iw.inValidAmntWithdrawalMethod();
		Assert.assertEquals(true, flag);
		
        
    }
    
	
	@Test
    public void testCase6() throws Exception  
    {	
		Thread.sleep(2000);
		boolean flag=vr.redeemVoucher(); 
		Assert.assertEquals(true, flag);
	
    }
	
	
	@Test
    public void testCase7() throws Exception  
    {	
		Thread.sleep(2000);
		flag=frv.failedredeemVoucher();
		Assert.assertEquals(true, flag);
	
    }
    
	@Test
    public void testCase8() throws Exception  
    {	

		cr.casinoMethod();
	
    }
	
	
    @After
    public void tearDown() {
    	driver.quit();
    }

   
}
