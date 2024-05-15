package Axess_Technology.Dominos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_Class {
	public static WebDriver driver;

	public static void property_Setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\New User\\eclipse-workspace\\Automation_4pm\\Webdriver\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	public static void maxi() {
		driver.manage().window().maximize();

	}

	public static void Url(String u) {
		driver.get(u);
	}

	public static void input(WebElement a, String in) {
		a.sendKeys(in);

	}

	public static void button(WebElement c) {
		c.click();

	}

	public static void navigate(String uu) {
		driver.navigate().to(uu);
	}

	public static void back() {
		driver.navigate().back();
	}

	public static void forward() {
		driver.navigate().forward();
	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	// drop down
	public static void drop_down(String o, WebElement ele, String v) {
		Select s = new Select(ele);
		if (o.equalsIgnoreCase("a")) {
			s.selectByValue(v);
		} else if (o.equalsIgnoreCase("b")) {
			s.selectByVisibleText(v);
		} else if (o.equalsIgnoreCase("c")) {
			int p = Integer.parseInt(v);
			s.selectByIndex(p);
		}

	}

	public static void getoptions(WebElement e) {
		Select s = new Select(e);
		List<WebElement> oo = s.getOptions();
		for (WebElement w : oo) {
			String t = w.getText();
			System.out.println(t);
		}

	}

	public static void first(WebElement ee) {
		Select s = new Select(ee);
		WebElement ff = s.getFirstSelectedOption();
		String tt = ff.getText();
		System.out.println(tt);
	}

	public static void screenshot(String na) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File surce = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\New User\\eclipse-workspace\\" + "Automation_4pm\\Screenshot\\" + na + ".png");
		FileUtils.copyFile(surce, des);
	}

	// frames

	public static void frameindex(int inde) {
		driver.switchTo().frame(inde);
	}

	public static void frameid(String i) {
		driver.switchTo().frame(i);
	}

	public static void frameelement(WebElement e) {
		driver.switchTo().frame(e);
	}

	public static void defaultt() {
		driver.switchTo().defaultContent();
	}

	// alert
	public static void popup(String o) {
		if (o.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().accept();
		} else if (o.equalsIgnoreCase("cancel")) {
			driver.switchTo().alert().dismiss();
		}

	}

	public static void popup_input(String ss) {
		driver.switchTo().alert().sendKeys(ss);
	}

//window handling
	public static void Windoww(int i) {
		Set<String> ww = driver.getWindowHandles();
		ArrayList<String> a = new ArrayList<String>(ww);
		String tt = driver.switchTo().window(a.get(i)).getTitle();
		System.out.println(tt);
	}

	public static void Window_par(int i) {
		Set<String> ww = driver.getWindowHandles();
		ArrayList<String> a = new ArrayList<String>(ww);
		driver.switchTo().window(a.get(i));

	}

	public static void scroll(WebElement e) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", e);

	}

	public static void mouse(WebElement ee) {
		Actions a = new Actions(driver);
		a.doubleClick(ee).build().perform();
	}

}
