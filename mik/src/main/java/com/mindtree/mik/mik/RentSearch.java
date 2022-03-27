package com.mindtree.mik.mik;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentSearch {
	
	public static void rentSearch(WebDriver driver) throws InterruptedException {
		//
		WebDriverWait wdw = new WebDriverWait(driver, 20);
		String searchCity = "//div[@id='searchCity']//div/div/div";
		wdw.until(ExpectedConditions.elementToBeClickable(By.xpath(searchCity)));
		
		driver.findElement(By.xpath(searchCity)).click();
		
		Actions action = new Actions(driver);
		
		for(int i=0;i<5;i++) {
			action.sendKeys(Keys.DOWN).perform();
		}
		action.sendKeys(Keys.ENTER).perform();
		WebElement locality = driver.findElement(By.id("listPageSearchLocality"));
		locality.click();
		locality.sendKeys("Kondapur");
		Thread.sleep(2000);
		locality.sendKeys(Keys.UP);
		locality.sendKeys(Keys.UP);
		locality.sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='prop-search-options nb__1Ktnl']/div[1]/div")).click();
		action.sendKeys(Keys.DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
		
		driver.findElement(By.xpath("//div[@class='prop-search-options nb__1Ktnl']/div[3]/div")).click();
		action.sendKeys(Keys.DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class='prop-search-button btn btn-primary btn-lg']")).click();
		wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'List')]")));
		System.out.println("Rent Search Successfull..");
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://www.nobroker.in/");
        driver.manage().window().maximize();
        System.out.println("Script Started..");
        
        rentSearch(driver);
        
        driver.close();
	}

}
