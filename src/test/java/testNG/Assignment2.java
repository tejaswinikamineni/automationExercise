package testNG;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testing.automationExcercide.POM.TripAdvisorPage;
import testing.automationExcercise.BaseDriver;

public class Assignment2 {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws IOException{
		BaseDriver bd=new BaseDriver();
		 driver=bd.getDriver("chrome");
		 driver.get("https://www.tripadvisor.in/");
	}
	
	
	@Test
	public void assignment2(){
		
		TripAdvisorPage tap=new TripAdvisorPage(driver);
		tap.clickOnSearch();
		tap.enterSearchText("Club Mahindra");
		tap.clickOnSearchButton();
		tap.clickOnFirstSearchResult();
		
		String currentWindow=driver.getWindowHandle();
		
		Set<String> allWindows=driver.getWindowHandles();
		
		for(String eachWindow:allWindows){
			
			if(!eachWindow.equals(currentWindow)){
				driver.switchTo().window(eachWindow);
			}
		}
		
		tap.clickOnWriteAReviewLink();
		
		currentWindow=driver.getWindowHandle();
		
		 allWindows=driver.getWindowHandles();
		
		for(String eachWindow:allWindows){
			
			if(!eachWindow.equals(currentWindow)){
				driver.switchTo().window(eachWindow);
			}
		}
		
		tap.mousehoverRating();
		
		tap.enterReviewTitle("test");
		tap.enterReviewText("text");
		
		boolean isHotelReviewDisplayed=tap.isHotelReviewSectionPresent();
		
		if(isHotelReviewDisplayed==true){
			tap.mousehoverRating_HotelService();
		}
		
		tap.clickOnSubmitReviewCheckBox();
	}
	
	@AfterTest
	public void tearDown(){
		
		driver.quit();
		
	}

}
