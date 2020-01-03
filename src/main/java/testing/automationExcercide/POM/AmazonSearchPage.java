package testing.automationExcercide.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonSearchPage {
	public WebDriver driver;
	public static final By txt_Search=By.id("twotabsearchtextbox");
	public static final By btn_submit=By.xpath("//input[@type='submit' and @value='Go']");
	public static final By span_SearchResult=By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	public static final By span_Price=By.xpath("//span[@id='priceblock_ourprice']");
	public AmazonSearchPage(WebDriver browser){
		driver=browser;
	}

	public void enterSearchItem(String item){
		
		try{
		driver.findElement(txt_Search).sendKeys(item);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void click_SearchButton(){
		try{
			driver.findElement(btn_submit).click();;
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	
	
	public List<WebElement> searchResultSet(){
		
		List<WebElement> list=driver.findElements(span_SearchResult);
		
		return list;
		
	}
	
	
	public String getPrice(){
		
		String price=driver.findElement(span_Price).getText();
		return price;
	}


}
