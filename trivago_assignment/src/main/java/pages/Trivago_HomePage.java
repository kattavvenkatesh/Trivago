package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.Base_class;
import static constants.Constants.PLACENAME;
import static constants.Constants.RESULTOFPLACES;
import static constants.Constants.EMAIL;
import static constants.Constants.SUBSCRIPTIONMESSAGE;
import static constants.Constants.DESTINATIONRESULT;

import java.util.ArrayList;
import java.util.List;

public class  Trivago_HomePage extends Base_class<Trivago_HomePage> {

	 			
			private static Trivago_HomePage  A= new Trivago_HomePage();
			private Trivago_HomePage() {
				
			}
				
			public  static Trivago_HomePage getPage() {
				if(A==null) {
					A = new Trivago_HomePage();
				}
				return A;
			}
			
			
			   private static WebElement Searchicon;
			   private static WebElement SearchField;
			   private static WebElement ResultString;
			   private static WebElement Closeicon;
			   private static WebElement email_textfield;
			   private static WebElement Inspire_Button;
			   private static WebElement Subscribe_Success_Message;
			   private static WebElement Navigationicon;
			   private static List<WebElement> MenuOptions;
			   private static List<WebElement> Destination;
			   private static WebElement SelectedDestination;
			   private static WebElement Logo_icon;
			
			   private static final String search_icon = "//div[@class='search-icon']";
			   private static final String search_field = "//input[@class='input search-input']";
			   private static final String search_result =  "//h3[@class='section-title']";
			   private static final String close_icon = "//div[@class='search-icon open']";
			   private static final String email_field = "//input[@name='email']";
			   private static final String inspire_btn = "//button[@type='submit']";
			   private static final String success_message = "//p[@class='submitted h1']";
			   private static final String navigation_icon = "//div[@class='nav-icon']";
			   private static final String menu_options = "//div[@class='menu-title']";
			   private static final String Destination_menu = "//div[@class='destination-menu']";
			   private static final String Selected_place = "//h1[@class='hero-main-title dest-2-main-title']";
			   private static final String logo = "//a[@class='logo']";
			   
			   public Trivago_HomePage SearchPlace() throws InterruptedException {
				  Thread.sleep(5000);
				 
				   Searchicon = driver.findElement(By.xpath(search_icon));
				  
				   clickonView(Searchicon);
				
				   SearchField = driver.findElement(By.xpath(search_field));
					enterText(SearchField,PLACENAME);
					
					Thread.sleep(5000);
					
					        
					SearchField.sendKeys(Keys.ENTER);
					
					return this;
					
				}
			   
			   public Trivago_HomePage ValidatetheResult() throws InterruptedException { // Validate the result
				   ResultString = driver.findElement(By.xpath(search_result));
				   String actual_result = ResultString.getText();
				   System.out.println(actual_result);
					Assertvalues(actual_result, RESULTOFPLACES);
				
				   Closeicon = driver.findElement(By.xpath(close_icon));
				   clickonView(Closeicon);
				   return this;
			   }
			   
			   
			   public Trivago_HomePage subscribe_Newsletter() throws InterruptedException { // Entering the Place name
				   email_textfield = driver.findElement(By.xpath(email_field));
					enterText(email_textfield,EMAIL);
					
					Inspire_Button = driver.findElement(By.xpath(inspire_btn));
					clickonView(Inspire_Button);
					
					Subscribe_Success_Message = driver.findElement(By.xpath(success_message));
					   String actual_result = Subscribe_Success_Message.getText();
						Assertvalues(actual_result, SUBSCRIPTIONMESSAGE);
					
					
					return this;
					
					
					
				}
			   
			   
			   
			   
			   public Trivago_HomePage NavigateThrough_Menu() throws InterruptedException {
				   Navigationicon = driver.findElement(By.xpath(navigation_icon));
				   clickonView(Navigationicon);
				   
				   MenuOptions = driver.findElements(By.xpath(menu_options));
				   clickonView(MenuOptions.get(0));
				   
				   Destination = driver.findElements(By.xpath(Destination_menu));
				   clickonView(Destination.get(0));
				   
				   SelectedDestination = driver.findElement(By.xpath(Selected_place));
				   String actual_result = SelectedDestination.getText();
				   Assertvalues(actual_result, DESTINATIONRESULT);
				   
				   Logo_icon = driver.findElement(By.xpath(logo));
				   clickonView(Logo_icon);
				   
				   return this;
				   
			   }
			
			
			   public Trivago_HomePage ValidateLinks() {
				   List<String> hrefs = new ArrayList<String>();
				   List<WebElement> anchors = driver.findElements(By.tagName("a"));
				   for ( WebElement anchor : anchors ) {
				       hrefs.add(anchor.getAttribute("href"));
				   }
				   for ( String href : hrefs ) {
				       driver.get(href);           
				   }
				   
				   return this;
}}
