package com.FDdetail.testscenario;

import java.io.FileInputStream;
import java.io.IOException;

import com.FDdetail.base.TestBase;
import com.FDdetail.dataprovider.DataSet;
import com.FDdetail.pages.Credential;
import com.FDdetail.pages.Detail;
import com.FDdetail.pages.OpenAccount;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CredentialTest extends TestBase {
	@BeforeClass
	public void setUp() {
		launchBrowser();
		navigateToURL();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void CredentialTest() {
		Credential cred = new Credential();

		String username = prop.getProperty("USER");
		String pwd = prop.getProperty("PASSWORD");
		cred.login(username, pwd);
		wait(4000);
	}

	// --------------------TASK 1
	@Test(priority = 2, enabled = true)
	public void printingAccountDetails() throws InterruptedException {
	    Detail detailPage = new Detail();
	    detailPage.AccountDetailsPrint();
	    Thread.sleep(1000);
	    detailPage.NavigateNextPage();
	    Thread.sleep(1000);
	    detailPage.AccountDetailsPrint();
	    Thread.sleep(1000);
	}

	
	//-------------------------TASK 2
	@Test(priority = 3, dataProvider = "testData",dataProviderClass=DataSet.class, enabled = true)
	public void creatingNewAcc(String AcType, String StateT, String CityT) throws InterruptedException, IOException {
	    OpenAccount openNewAccountPage = new OpenAccount();
	    openNewAccountPage.validatingNewAccount(AcType, StateT, CityT);
	}


}
