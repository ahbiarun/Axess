package com.luma;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Luma_Selenium {

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		// sign in
		Thread.sleep(2000);
		WebElement sign = driver.findElement(By.className("authorization-link"));
		sign.click();
		WebElement email = driver.findElement(By.name("login[username]"));
		email.sendKeys("abinayasenthilkumar1998@gmail.com");
		WebElement pass = driver.findElement(By.name("login[password]"));
		pass.sendKeys("Abinaya@123");
		WebElement sbutton = driver.findElement(By.xpath("(//span[text()='Sign In'])[1]"));
		sbutton.click();
		// Women
		WebElement women = driver.findElement(By.xpath("//span[text()='Women']"));
		Actions a = new Actions(driver);
		a.moveToElement(women).build().perform();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// jacket
		WebElement jacket = driver.findElement(By.xpath("(//span[text()='Jackets'])[1]"));
		jacket.click();
		// scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		WebElement jack = driver.findElement(By.xpath("(//strong[@class=\"product name product-item-name\"])[1]"));
		a.moveToElement(jack).build().perform();
		Thread.sleep(3000);
		WebElement add = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
		a.click(add).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@aria-label='S']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Blue']")).click();
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
		js.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(3000);
		// cart
		WebElement aa = driver.findElement(By.xpath("//div[@class='minicart-wrapper']"));
		aa.click();
		// proceed to order
		WebElement proceed = driver.findElement(By.id("top-cart-btn-checkout"));
		proceed.click();
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(5000);
		// next
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		// place order
		Thread.sleep(5000);
//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='action primary checkout']")).click();
		// takesscreenshot
		Thread.sleep(3000);
		TakesScreenshot s = (TakesScreenshot) driver;
		File source = s.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\Ax Technology\\Luma\\Screenshot\\luma.png");
		FileUtils.copyFile(source, des);
		// print

		// men
		WebElement men = driver.findElement(By.xpath("//span[text()='Men']"));
		a.moveToElement(men).build().perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		// men jacket
		WebElement jacket1 = driver.findElement(By.xpath("(//span[text()='Jackets'])[2]"));
		jacket1.click();
		js.executeScript("window.scrollBy(0,500)");
		WebElement tjacket = driver.findElement(By.xpath("//span[text()='$45.00']"));
		a.moveToElement(tjacket).build().perform();
		WebElement ad = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
		a.click(ad).build().perform();
//	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@aria-label='S']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Blue']")).click();
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
		js.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(3000);
		// cart
		WebElement bb = driver.findElement(By.xpath("//div[@class='minicart-wrapper']"));
		bb.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='primary'])[2]")).click();
		Thread.sleep(3000);
		WebElement qt = driver.findElement(By.name("qty"));
		qt.clear();
		qt.sendKeys("2");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Update Cart']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Proceed to Checkout']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='action primary checkout']")).click();
		driver.findElement(By.xpath("(//a[@rel='noopener'])[1]")).click();
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_A);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_D);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		Set<String> ww = driver.getWindowHandles();
		ArrayList<String> ab = new ArrayList<String>(ww);
		driver.switchTo().window(ab.get(0));
		Thread.sleep(2000);
		driver.findElement(By.className("action switch")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("authorization-link")).click();

	}
}
