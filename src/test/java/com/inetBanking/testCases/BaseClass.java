package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import freemarker.log.Logger;

public class BaseClass {

	ReadConfig readconf = new ReadConfig();
	private String baseURL = readconf.getApplicationURL();
	private String username = readconf.getUsername();
	private String password = readconf.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", "./Drivers//chromedriver.exe");	instead of system.getproperty("user.dir") can use ./ for home directory
			
			System.setProperty("webdriver.chrome.driver", readconf.getChromePath());
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconf.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", readconf.getIEPath());
			driver = new InternetExplorerDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//implicit wait
		driver.get(getBaseURL());
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

	public String getBaseURL() {
		return baseURL;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		logger.info("Screenshot taken");
	}
	
	public String randomString()
	{
		return RandomStringUtils.randomAlphabetic(8);
	}
	
	public String randomNumber()
	{
		return RandomStringUtils.randomNumeric(4);
	}

}
