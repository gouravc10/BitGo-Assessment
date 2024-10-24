package PageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlocksPage {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse;
	
	
	public BlocksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		jse = (JavascriptExecutor)driver;
		
	}
	
	
	@FindBy(xpath = "//*[@id=\"Bitcoin\"]")
	WebElement settingMenuArrow;
	public void waitForBitcoin() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Bitcoin")));
		settingMenuArrow.click();
	}
		
	
	
	
	public void isDisplayed() {
		WebElement texttag = driver.findElement(By.xpath("//*[@class=\"transactions\"]/h3"));
		if(texttag.isDisplayed()) {
			
			System.out.println(texttag.getText());
		}
		else
			System.out.println("Not displayed");
	
	}
	
	
	
	public void scrollToText(String text) {
		WebElement texttag = driver.findElement(By.xpath("//*[contains(text(),'"+text +"')]"));
		jse.executeScript("arguments[0].scrollIntoView(true);", texttag);
	
	}
	
	public void traverseInpOut() {
		
		
		for(int i =1; i<26; i++) {
		int size = driver.findElements(By.xpath("//*[@id='transaction-box']["+i+"]/div[2]/div[1]/div")).size();
		int size2 = driver.findElements(By.xpath("//*[@id='transaction-box']["+i+"]/div[2]/div[3]/div")).size();
		String hash = driver.findElement(By.xpath("//*[@id='transaction-box']["+i+"]/div[1]/div[1]/a")).getText();
	
		
		if(size==1 && size2==2) {
			System.out.println(size);
			System.out.println(size2);
			System.out.println(hash);
			break;
		}
		
		}
	
	}
	
	
	
}
