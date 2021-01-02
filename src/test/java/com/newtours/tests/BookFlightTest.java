package com.newtours.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newtours.pages.FindFlightPage;
import com.newtours.pages.FlightConfirmationPage;
import com.newtours.pages.FlightDetailsPage;
import com.newtours.pages.RegistrationConfirmationPage;
import com.newtours.pages.RegistrationPage;
import com.tests.BaseTest;

public class BookFlightTest extends BaseTest{
	
	private String noOfPassengers;
	private String expectedPrice;
	
	@Test
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setupParameters(String noOfPassengers, String expectedPrice){
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;
    }
	
	@Test
	public void registrationPage(){
	RegistrationPage registrationPage= new RegistrationPage(driver);
	registrationPage.goTo();
	registrationPage.enterUserDetails("selenium", "docker");
	registrationPage.enterUsercredentials("selenium", "docker");
	registrationPage.submit();
	
	}
	
	@Test(dependsOnMethods="registrationPage")
	public void registrationConfirmationPage(){
		RegistrationConfirmationPage registrationConfirmationPage= new RegistrationConfirmationPage(driver);
		registrationConfirmationPage.goToFlightDetailsPage();
		
	}
	
	@Test(dependsOnMethods="registrationConfirmationPage")
	
	public void flightDetailsPage() throws InterruptedException{
	
	FlightDetailsPage flightDetailsPage= new FlightDetailsPage(driver);
	flightDetailsPage.selectPassengers("noOfPassengers");
	flightDetailsPage.goToFindFlightsPage();
		
	}
	
	@Test(dependsOnMethods="flightDetailsPage")
	public void findFlightPage(){
	FindFlightPage findFlightPage= new FindFlightPage(driver);
	findFlightPage.submitFindFlightPage();
	findFlightPage.goToFlightConfirmationPage();
	}
	
	@Test(dependsOnMethods="findFlightPage")
	public void flightConfirmationPage(){
	FlightConfirmationPage flightConfirmationPage= new FlightConfirmationPage(driver);
	String actualPrice=flightConfirmationPage.getPrice();
	Assert.assertEquals(actualPrice, expectedPrice);
	
	}
	
	

}
