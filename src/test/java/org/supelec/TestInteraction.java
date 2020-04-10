package org.supelec;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestInteraction {


		@Test
		public void monPremierTest () {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//ACTION 1
			driver.get("http://86.242.1.1/jpetstore/actions/Account.action?signonForm=");
			WebElement champ_login = driver.findElement(By.name("username"));
			champ_login.clear();
			champ_login.sendKeys("j2ee");
			
			WebElement champ_password = driver.findElement(By.name("password"));
			champ_password.clear();
			champ_password.sendKeys("j2ee");
			
			driver.findElement(By.name("signon")).click();
			
			//VERIF 1
			assertEquals("Welcome ABC!", driver.findElement(By.id("WelcomeContent")).getText());
			
			//ACTION 2
			driver.findElement(By.xpath("//area[@alt='Fish']")).click();
			
			//VERIF 2
			assertEquals("Fish",driver.findElement(By.tagName("h2")).getText());
			
			//ACTION 3
			driver.findElement(By.xpath("//a[.='FI-SW-01']")).click();
			
			//VERIF 3
			assertEquals("Add to Cart", driver.findElement(By.className("Button")).getText());
			
			//teardown
			driver.quit();
			

		}

}
