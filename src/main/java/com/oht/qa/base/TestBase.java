package com.oht.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.oht.qa.utils.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fp = new FileInputStream("E:\\srinivas131\\OurHomeTownTest\\src\\main\\java\\com\\oht\\qa\\config\\config.properties");
			prop.load(fp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\SeleniumLibs\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF")) {
			System.setProperty("webdriver.geko.driver", "D:\\SeleniumLibs\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.ie.driver", "D:\\SeleniumLibs\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Time, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
}
}