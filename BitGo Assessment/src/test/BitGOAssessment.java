package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.BlocksPage;
import Utils.TestListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.This;

import java.util.concurrent.TimeUnit;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

@Listeners(TestListener.class)
public class BitGOAssessment extends BrowserConfiguration{


	

	@Test
	void tagToggleEdit() throws InterruptedException {
		
		BlocksPage Bp = new BlocksPage(driver);
		
		getURL("https://blockstream.info/block/000000000000000000076c036ff5119e5a5a74df77abf64203473364509f7732");
		Bp.waitForBitcoin();
		driver.get("https://blockstream.info/block/000000000000000000076c036ff5119e5a5a74df77abf64203473364509f7732");
		Bp.isDisplayed();
		Bp.scrollToText("25 of 2875 Transactions");
		Bp.traverseInpOut();
		
	
	}
}
