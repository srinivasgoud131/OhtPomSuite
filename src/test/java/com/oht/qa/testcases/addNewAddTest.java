package com.oht.qa.testcases;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.oht.qa.base.TestBase;
import com.oht.qa.pages.HomePage;
import com.oht.qa.pages.LoginPage;
import com.oht.qa.pages.NewAddressPage;
import com.oht.qa.pages.PaymentPage;
import com.oht.qa.utils.TestUtil;

public class addNewAddTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	PaymentPage paymentPage;
	NewAddressPage newAddress;

	public addNewAddTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		newAddress = new NewAddressPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] getTestData() {
		Object[][] myData = TestUtil.getDataFromExcel();
		return myData;
	}

	@Test(priority = 1)
	public void openAddressPageTest() {
		newAddress = newAddress.openAddressPage();
	}

	@Test(priority = 2, dataProvider = "getTestData")
	public void addressFormTest(Hashtable<String, String> testData) {

		newAddress.openAddressPage();
		String ftname = testData.get("FirstName");
		newAddress.typeFirstname(ftname);
		String ltname = testData.get("LastName");
		newAddress.typeLastname(ltname);
		String email = testData.get("EmailAddress");
		newAddress.typeEmail(email);
		String mobile1 = testData.get("PhoneNumber");
		newAddress.typeMobile(mobile1);
		String dno = testData.get("DoorNumber");
		newAddress.typeDoorNo(dno);
		String Strname = testData.get("StreetName");
		newAddress.typeStreetName(Strname);
		String Lmark = testData.get("LandMark");
		newAddress.typeLandmark(Lmark);
		String cityOrTown = testData.get("TownCity");
		newAddress.typeCityname(cityOrTown);
		String Stname = testData.get("StateName");
		newAddress.selectState(Stname);
		String Pin = testData.get("PinCode");
		newAddress.typePinc(Pin);
		newAddress.clicOnHomeBtn();
		paymentPage = newAddress.clickOnSaveBtn();
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}
}