package testNG;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testing.automationExcercide.POM.AmazonSearchPage;
import testing.automationExcercide.POM.FlipkartSearchPage;
import testing.automationExcercise.BaseDriver;

public class Assignment1 {
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws IOException{
		BaseDriver bd=new BaseDriver();
		 driver=bd.getDriver("chrome");
		 driver.get("https://www.amazon.in/");
		 
	}
	
	
	@Test
	public void assignment1(){
		String searchItem="Apple iPhone XR (64GB) - Yellow";
		AmazonSearchPage asp=new AmazonSearchPage(driver);
		asp.enterSearchItem(searchItem);
		asp.click_SearchButton();
		
		List<WebElement> searchResult=asp.searchResultSet();
		
		for(WebElement e: searchResult){		
			if(e.getText().equals("Apple iPhone XR (64GB) - Yellow")){
				e.click();
				break;
			}
		}
		
		String currentWindow=driver.getWindowHandle();
		
		Set<String> allWindows=driver.getWindowHandles();
		
		for(String eachWindow:allWindows){
			
			if(!eachWindow.equals(currentWindow)){
				driver.switchTo().window(eachWindow);
			}
		}
		
		String amazonPrice=asp.getPrice();
		amazonPrice=amazonPrice.replace("₹", "").replace(",", "").trim();
		
		double amazonPrice_xr=Double.parseDouble(amazonPrice);
		System.out.println("AmazonPrice : "+amazonPrice_xr);
		driver.close();
		
		driver.switchTo().window(currentWindow);
		
		driver.navigate().to("https://www.flipkart.com/");
		
		FlipkartSearchPage fsp=new FlipkartSearchPage(driver);
		
		fsp.closeLoginPopup();
		
		fsp.enterSearchItem(searchItem);
		
		fsp.click_SearchButton();
		
	  searchResult=fsp.searchResultSet();
	  for(WebElement e: searchResult){		
			if(e.getText().equals("Apple iPhone XR (Yellow, 64 GB)")){
				e.click();
				break;
			}
		}
		
		 currentWindow=driver.getWindowHandle();
		
		 allWindows=driver.getWindowHandles();
		
		for(String eachWindow:allWindows){
			
			if(!eachWindow.equals(currentWindow)){
				driver.switchTo().window(eachWindow);
			}
		}
		
		String flipkartPrice=fsp.getPrice().replace("₹", "").replace(",", "").trim();
		double flipkartPrice_xr=Double.parseDouble(flipkartPrice);
		System.out.println("FlipKart Price : "+flipkartPrice_xr);
		
		if(amazonPrice_xr>flipkartPrice_xr){
			System.out.println("Flipkart have lesser price than Amazon ");
		}else{
			System.out.println("Amazon have lesser price than Flipkart ");
		}
		
		
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
