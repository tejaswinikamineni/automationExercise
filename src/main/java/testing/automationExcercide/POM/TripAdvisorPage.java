package testing.automationExcercide.POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TripAdvisorPage {
	public WebDriver driver;
	private static Logger log=Logger.getLogger(TripAdvisorPage.class);
	
	public static final By div_Search=By.xpath("//div[@title='Search']");
	public static final By txt_MainSearch=By.id("mainSearch");
	public static final By btn_Search=By.id("SEARCH_BUTTON");
	public static final By div_FirstSearchResult=By.xpath("(//div[@class='result-title'])[1]");
	public static final By link_WriteAReview=By.linkText("Write a review");
	public static final By span_Rating=By.id("bubble_rating");
	public static final By txt_ReviewTitle=By.id("ReviewTitle");
	public static final By txt_ReviewText=By.id("ReviewText");
	public static final By table_HotelReview=By.className("ratingBubbleTable");
	public static final By rating_HotelService=By.xpath("//span[@id='qid12_bubbles']");
	public static final By rating_HotelCleanliness=By.xpath("//span[@id='qid13_bubbles']");
	public static final By rating_HotelValue=By.xpath("//span[@id='qid14_bubbles']");
	public static final By checkbox_submitReview=By.id("noFraud");
	public TripAdvisorPage(WebDriver browser){
		driver=browser;
	}
	
	
	public void clickOnSearch(){
		
		driver.findElement(div_Search).click();
		
	}
	
	public void enterSearchText(String searchText){
		
	driver.findElement(txt_MainSearch).sendKeys(searchText);
		
	}
	
public void clickOnSearchButton(){
		
		driver.findElement(btn_Search).click();
		
	}


public void clickOnFirstSearchResult(){
	
	driver.findElement(div_FirstSearchResult).click();
	
}

public void clickOnWriteAReviewLink(){
	
	WebDriverWait wait=new WebDriverWait(driver, 120);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(link_WriteAReview)));
	driver.findElement(link_WriteAReview).click();
	
}

public void mousehoverRating(){
	
	
	Actions action=new Actions(driver);
	WebElement element=driver.findElement(span_Rating);
	action.moveToElement(element).build().perform();
	element.click();
	
}


	public void enterReviewTitle(String reviewTitle){
	
	driver.findElement(txt_ReviewTitle).sendKeys(reviewTitle);
		
	}


	public void enterReviewText(String reviewText){
	
	driver.findElement(txt_ReviewText).sendKeys(reviewText);
		
	}


	
	public boolean isHotelReviewSectionPresent(){
		
		boolean flag=driver.findElement(table_HotelReview).isDisplayed();
		return flag;
	}
	
	
	public void mousehoverRating_HotelService(){
		
		
		Actions action=new Actions(driver);
		WebElement element=driver.findElement(rating_HotelService);
		action.moveToElement(element).build().perform();
		element.click();
		
	}
	
	
	public void mousehoverRating_HotelCleanliness(){
		
		
		Actions action=new Actions(driver);
		WebElement element=driver.findElement(rating_HotelCleanliness);
		action.moveToElement(element).build().perform();
		element.click();
		
	}
	
	
	public void mousehoverRating_HotelValue(){
		
		
		Actions action=new Actions(driver);
		WebElement element=driver.findElement(rating_HotelValue);
		action.moveToElement(element).build().perform();
		element.click();
		
	}


	public void clickOnSubmitReviewCheckBox(){
		driver.findElement(checkbox_submitReview).click();
	}

}
