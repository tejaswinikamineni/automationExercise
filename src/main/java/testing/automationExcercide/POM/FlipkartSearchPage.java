package testing.automationExcercide.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartSearchPage {
	public WebDriver driver;
	public static final By btn_CloseLoginPopup=By.xpath("//button[text()='✕']");
	public static final By txt_Search=By.name("q");
	public static final By btn_submit=By.xpath("//button[@type='submit']");
	public static final By div_SearchResult=By.xpath("//div[@class='_3wU53n']");
	public static final By div_Price=By.xpath("//div[@class='_1vC4OE _3qQ9m1']");
	public FlipkartSearchPage(WebDriver browser){
		driver=browser;
	}

public void closeLoginPopup(){
	driver.findElement(btn_CloseLoginPopup).click();
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
		
		List<WebElement> list=driver.findElements(div_SearchResult);
		
		return list;
		
	}
	
	
	
	public String getPrice(){
		
		String price=driver.findElement(div_Price).getText();
		return price;
	}

	

	
	
	


}
