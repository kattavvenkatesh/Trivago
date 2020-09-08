package base;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;






public  class Base_class <T> {
	public static WebDriver driver;
		 
		 
		 
			public T clickonView(WebElement Btn) { // This method can be used to click function
				WebDriverWait wait = new WebDriverWait(driver, 60);
				try {
				wait.until(ExpectedConditions.visibilityOf(Btn));
				Btn.click();
				}catch(Exception e) {
					System.out.println("Button not found");
				}
				return (T) this;
			}
			
			public T Assertvalues(String Actual, String Expected)  { // This method can be used for Asserts function
				WebDriverWait wait = new WebDriverWait(driver, 60);
				
				Assert.assertEquals(Actual, Expected);
				return (T) this;
			}
			
			public T ScrollDown() { // This Method can be used for scroll down function
			
				
				return (T) this;
			}
			
			public T enterText(WebElement fieldname, String Text) {  // This method can be used for type function
				WebDriverWait wait = new WebDriverWait(driver, 60);
				try {
				wait.until(ExpectedConditions.visibilityOf(fieldname));// To Enter Text
				fieldname.clear();
				fieldname.sendKeys(Text);
				}catch(Exception e) {
					System.out.println("Element not found");
					
				}
				
				return (T) this;
				
			}

	 
		public T initialization() throws InterruptedException { // To open the browser and URL

			System.setProperty("webdriver.chrome.driver","C:\\Users\\kattaven\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");	
			driver = new ChromeDriver(); 
			
			driver.manage().window().maximize();
			//driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("https://magazine.trivago.com/");
			
			return (T) this;

		}


	}

