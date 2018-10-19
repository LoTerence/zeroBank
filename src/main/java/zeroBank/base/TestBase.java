package zeroBank.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import zeroBank.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	
	public static Properties prop;
	
protected static String path = System.getProperty("user.dir");
	
	public TestBase() {
		try {
			prop = new Properties();
			System.out.println(path);
			FileInputStream ip = new FileInputStream(path+"\\src\\main\\java\\zeroBank\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", path+"/driverResources/chromedriver.exe");
			// enable headless browsing if need be
//			ChromeOptions options = new ChromeOptions
//			options.addArguments("headless");
//	        options.addArguments("window-size=1200x600");
//			driver = new ChromeDriver(options);
			driver = new ChromeDriver();
		} else if(browserName.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", path+"/driverResources/geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equals("ie")){
        	String service = path+"/driverResources/IEDriverServer.exe";
        	System.setProperty("webdriver.ie.driver", service);
        	driver = new InternetExplorerDriver();
		}
		
//		e_driver = new EventFiringWebDriver(driver);
//		// Now create object of EventListerHandler to register it with EventFiringWebDriver
//		eventListener = new WebEventListener();
//		e_driver.register(eventListener);
//		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	

}
