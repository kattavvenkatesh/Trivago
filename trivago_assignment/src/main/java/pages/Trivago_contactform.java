package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static constants.Constants.MESSAGE;
import static constants.Constants.FIRSTNAME;
import static constants.Constants.EMAIL;
import static constants.Constants.SUCCESSMESSAGE;

import base.Base_class;

public class Trivago_contactform extends Base_class<Trivago_contactform> {
	 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	private static Trivago_contactform  A= new Trivago_contactform();
	private Trivago_contactform() {
		
	}
		
	public  static Trivago_contactform getPages() {
		if(A==null) {
			A = new Trivago_contactform();
		}
		return A;
	}
	
	private static WebElement Contctlink;
	private static WebElement YourMessage_Textfields;
	private static List<WebElement> FirstName_Email_fields;
	private static WebElement SuccessMessage;
	
	 private static final String contact_link = "//a[@href='https://magazine.trivago.com.au/contact/']";
	 private static final String message_field = "//textarea[@class='contact-msg']";
	 private static final String FirstName_emailfields = "//input[@class='contact-input']";
	 private static final String Success_message = "//p[@class='feedback']";
	 
	 public Trivago_contactform ClickonContactlink() throws InterruptedException {
		 Thread.sleep(5000);
		 Contctlink = driver.findElement(By.xpath(contact_link));
		   clickonView(Contctlink);
		   
		   return this;
	   }
	 
	 public Trivago_contactform FillContactForm() throws InterruptedException {
		 Thread.sleep(5000);
		 driver.switchTo().window(tabs2.get(1));
		 YourMessage_Textfields = driver.findElement(By.xpath(message_field));
		 enterText(YourMessage_Textfields, MESSAGE);
		 
		 FirstName_Email_fields = driver.findElements(By.xpath(FirstName_emailfields));
		 enterText(FirstName_Email_fields.get(0), FIRSTNAME);
		 
		 
		 FirstName_Email_fields = driver.findElements(By.xpath(FirstName_emailfields));
		 enterText(FirstName_Email_fields.get(1), EMAIL);
		 
	
		 SuccessMessage = driver.findElement(By.xpath(Success_message));
		   String actual_result = SuccessMessage.getText();
			Assertvalues(actual_result, SUCCESSMESSAGE);
		 driver.close();
		 Thread.sleep(5000);

		 driver.switchTo().window(tabs2.get(0));
		 
		 return this;
	 
	 }
	 
	 
	 
	 
}
