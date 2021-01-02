package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name="firstName")
	private WebElement firstNametxt;
	
	@FindBy(name="lastName")
	private WebElement lastNametxt;
	
	@FindBy(name="email")
	private WebElement userNametxt;
	
	@FindBy(name="password")
	private WebElement passwordtxt;
	
	@FindBy(name="confirmPassword")
	private WebElement confirmPasswordtxt;
	
	@FindBy(name="register")
	private WebElement submitBtn;
	
	public RegistrationPage(WebDriver driver){
		this.driver=driver;
		this.wait= new WebDriverWait(driver, 30);
	}

	public void goTo(){
		this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
	//	
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserDetails(String firstName, String lastName){
		this.wait.until(ExpectedConditions.visibilityOf(this.firstNametxt));
		this.firstNametxt.sendKeys(firstName);
		this.lastNametxt.sendKeys(lastName);
	}
	
	public void enterUsercredentials(String username, String password){
		this.userNametxt.sendKeys(username);
		this.passwordtxt.sendKeys(password);
		this.confirmPasswordtxt.sendKeys(password);
	}
	
	public void submit(){
		this.submitBtn.click();
	}
}
