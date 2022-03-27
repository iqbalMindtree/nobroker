package com.mindtree.mik.mik;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App 
{
	// checking login module..
	public static void login(WebDriver driver) {
		driver.findElement(By.xpath("//div[contains(text(),'Log in')]")).click();
		WebDriverWait wdw = new WebDriverWait(driver, 20);
		wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"signUp-phoneNumber\"]")));
		
		driver.findElement(By.xpath("//input[@id=\"signUp-phoneNumber\"]")).sendKeys("7278608685");
		wdw.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),\"I've Password\")]/input")));
		WebElement passwordRadio = driver.findElement(By.xpath("//label[contains(text(),\"I've Password\")]/input"));
		passwordRadio.click();
		
		driver.findElement(By.id("login-signup-form__password-input")).sendKeys("iqbal1998");
		driver.findElement(By.id("signUpSubmit")).click();
		wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'iqbal khan')]")));
		System.out.println("login task Successfull.");
	}
	
	//checking sign up module..
	public static void signup(WebDriver driver) {
		driver.findElement(By.xpath("//div[contains(text(),'Sign up')]")).click();
		WebDriverWait wdw = new WebDriverWait(driver, 20);
		wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"signUp-phoneNumber\"]")));
		
		driver.findElement(By.xpath("//input[@id=\"signUp-phoneNumber\"]")).sendKeys("7278609801");
		
		wdw.until(ExpectedConditions.elementToBeClickable(By.id("login-signup-form__name-input")));
		
		driver.findElement(By.id("login-signup-form__name-input")).sendKeys("rahul singh");
		
		wdw.until(ExpectedConditions.elementToBeClickable(By.id("login-signup-form__email-input")));
		
		driver.findElement(By.id("login-signup-form__email-input")).sendKeys("rahulsinghpaka1001@gmail.com");
		
		driver.findElement(By.id("signUpSubmit")).click();
		
		wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Log in')]")));
		
		System.out.println("Signup task Successfull.");
	}
	
	public static void logout(WebDriver driver) {
		//
		WebDriverWait wdw = new WebDriverWait(driver, 20);
		wdw.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'rahul singh')]")));
		driver.findElement(By.xpath("//span[contains(text(),'rahul singh')]")).click();
		
		wdw.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Sign Out')]")));
		driver.findElement(By.xpath("//div[contains(text(),'Sign Out')]")).click();
		
		wdw.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Log in')]")));
		System.out.println("Log out task Successfull..");
	}

    public static void main( String[] args ) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://www.nobroker.in/");
        driver.manage().window().maximize();
        System.out.println("Script Started..");
        signup(driver);
        Thread.sleep(2000);
        logout(driver);
        Thread.sleep(2000);
        login(driver);
        
        driver.close();
    }
}
