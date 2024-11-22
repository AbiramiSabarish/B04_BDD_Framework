package com.vcentry.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static String propFile="src\\main\\resources\\config.properties";
    
	
public static Logger log=LogManager.getLogger(BaseClass.class);
	
	public static void initilize(String browser) {
		try {
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(getProp("wait"))));
		  log.info(browser +" browser launched");
		}catch (Exception e) {
			 log.error("Unable to launched "+browser+" browser");
			e.printStackTrace();
		}
	}
	
	public static void launchUrl(String url) {
		try {
			driver.get(url);
			log.info("naviageted to "+ url);
		}catch (Exception e) {
			log.error("Url is not launched");
			e.printStackTrace();
		}
	}
	
	public static String getProp(String data)  {
		String propValue=null;
		try {
		FileInputStream fi=new FileInputStream(propFile);
	     Properties prop=new Properties();
	     prop.load(fi);
	     propValue=prop.get(data).toString();
	     
		}catch (Exception e) {
			e.printStackTrace();
		}
		return propValue;
	}
	
	public void afterTest() {
		driver.quit();
	}

		public static void clickElement(WebElement element) {
			try {
				element.click();
			     log.info(element +" is clicked");
			}catch (Exception e) {
				e.printStackTrace();
				
			     log.info(element +" is not clicked");	
			}
		}
		
		public static void enterText(WebElement element,String data) {
			try {
				element.sendKeys(data);
				
			     log.info(data+"is enetered in"+element);
			}catch (Exception e) {
				e.printStackTrace();
			
			     log.info(data+"is not enetered in"+element);	
			}
		}
	
		public static String getText(WebElement element) {
			String text=null;
			try {
				text =element.getText();
				log.info(text+" is present");
			}catch (Exception e) {
				e.printStackTrace();
				log.info(element+" is not present");
				// TODO: handle exception
			}
			return text;
		}

		public static void selectByText(WebElement element,String text) {	
			try {
				Select s=new Select(element);
				s.selectByVisibleText(text);
				log.info(text+" is selected");
			}catch (Exception e) {
				e.printStackTrace();
				log.info(element+" is not selected");
				// TODO: handle exception
			}
		}

		public static void selectCheckBox(WebElement element) {
			
			try {
				if(element.isSelected()) {
					log.info(element+" checkbox already selected");	
				}else {
					clickElement(element);
					log.info(element+" checkbox is selected");
				}
				
			}catch (Exception e) {
				e.printStackTrace();
				log.info(element+" checkbox is not selected");
				// TODO: handle exception
			}
			
		}

		public static boolean elementDisplayed(WebElement element) {
			boolean display=false;
			try {
				display=element.isDisplayed();
			     log.info(element +" is displayed");
			}catch (Exception e) {
				e.printStackTrace();
				
			     log.info(element +" is not displayed");	
			}
		return display;
		}
	
}