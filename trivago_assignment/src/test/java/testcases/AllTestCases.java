package testcases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Base_class;
import pages.Trivago_HomePage;
import pages.Trivago_contactform;


public class AllTestCases extends Base_class {
	
	public AllTestCases() {
		super();
	}
	
@BeforeClass // Initializing the driver and launching the application
	
	public void setup() throws InterruptedException {
		initialization();
	}

//@Test (priority=1)

public void SearchLocation_searchbar() throws InterruptedException {
	
	Trivago_HomePage.getPage()
	.SearchPlace()
	.ValidatetheResult();
}

@Test (priority=2)

public void Fill_ContactForm() throws InterruptedException {
	
	 
	Trivago_contactform.getPages()
	.ClickonContactlink()
	.FillContactForm();
	
}

//@Test (priority=3)

public void Subscribe_NewsLetter() throws InterruptedException {
Trivago_HomePage.getPage()
.subscribe_Newsletter();
}

@Test (priority=4)

public void Destination_Menu() throws InterruptedException  {
	Trivago_HomePage.getPage()
	.NavigateThrough_Menu();
}

@Test (priority=5)

public void ValidateAlltheLinks() {
	Trivago_HomePage.getPage()
	.ValidateLinks();
}



}
