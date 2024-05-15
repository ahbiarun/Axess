package Axess_Technology.Dominos;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.util.Times;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dominos_Test extends Base_Class {

	@Test(priority = 0)
	@Parameters("browser")
	public void testOnBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

	}

	@Test(priority = 1)
	private void dominos_Order() throws InterruptedException, IOException {
		maxi();
		Url("https://www.dominos.co.in/");
		Dominos_PageObjectModel model = new Dominos_PageObjectModel(driver);
		model.getOrder_online().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		model.getDontallow().click();
		model.getAddress().click();
		model.getPincode().sendKeys("600026");
		model.getPin().click();
		// • Section VEG PIZZA

		model.getVegpizza().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// • Section VEG PIZZA add following product 2Qty each Margherita

		model.getAddtocart().click();
		model.getAdd().click();
		model.getPlus().click();
		// • Section VEG PIZZA add following product 2Qty each peppy paneer

		model.getPanner_pizza().click();
		model.getAdd().click();
		model.getPanneer_plus().click();
		// • Section VEG PIZZA add following product 2Qty each Caprese Gourmet Pizza

		model.getGourmentpizza().click();
		scroll(model.getGourmet_add());
		model.getCheck().click();
		// • Assert Cart Subtotal Value with Sum of (Each Product Value *Qty)
		Dominos_SubTotal cart = new Dominos_SubTotal();
		/*
		 * cart.addProduct("Margherita", 314.00, 2); cart.addProduct("peppy paneer",
		 * 534.00, 2); cart.addProduct("Gourmet-Pizza", 549.00, 2);/*
		 * 
		 * /* double expectedSubtotal = (314.00 * 2) + (534.00 * 2) + (549.00 * 1);
		 * cart.assertCartSubtotal(expectedSubtotal);
		 */
		back();
		model.getBeverages().click();

		// • Section BEVERAGES add following product 12Qty each. Pepsi 475ml

		model.getBevAdd().click();
		int i;
		for (i = 2; i <= 12; i++) {
			scroll(model.getBev_increase());
		}
		model.getCheck().click();

		// • Assert Cart Subtotal Value with Sum of (Each Product Value *Qty)

		/*
		 * cart.addProduct("product c", 57.14, 12); double expectedSubtotal = (314.00 *
		 * 2) + (534.00 * 2) + (549.00 * 2) + (57.14 * 12);
		 * cart.assertCartSubtotal(expectedSubtotal);
		 */

		// • Remove following products from Cart Margherita – remove 1 Qty.

		model.getMar_decrease().click();

		// • Remove following products from Cart Pepsi 475ml – remove 6 Qty.
		int j;
		for (j = 11; j >= 6; j--) {
			scroll(model.getPesi_decrease());
			Thread.sleep(2000);

		}

		// • Assert Cart Subtotal Value with Sum of (Each Product Value *Qty)
		cart.addProduct("Margherita", 314.00, 1);
		cart.addProduct("pepsi", 57.14, 6);
		cart.addProduct("Gourmet-Pizza", 549.00, 2);
		cart.addProduct("peppy paneer", 534.00, 2);
		double expectedSubtotal = (314.00 * 1) + (534.00 * 2) + (549.00 * 2) + (57.14 * 6);
		cart.assertCartSubtotal(expectedSubtotal);

		// Use Excel for Products & Count
		File f = new File("D:\\excel\\axess.xlsx");
		FileInputStream in = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(in);
		// w.createSheet("order").createRow(0).createCell(0).setCellValue("product
		// name");
		w.getSheet("order").getRow(0).createCell(1).setCellValue("price");
		w.getSheet("order").getRow(0).createCell(2).setCellValue("count");
		w.getSheet("order").createRow(1).createCell(0).setCellValue("Margherita");
		w.getSheet("order").getRow(1).createCell(1).setCellValue(314.00);
		w.getSheet("order").getRow(1).createCell(2).setCellValue("2");
		w.getSheet("order").createRow(2).createCell(0).setCellValue("peppy paneer");
		w.getSheet("order").getRow(2).createCell(1).setCellValue(534.00);
		w.getSheet("order").getRow(2).createCell(2).setCellValue("2");
		w.getSheet("order").createRow(3).createCell(0).setCellValue("Gourmet-Pizza");
		w.getSheet("order").getRow(3).createCell(1).setCellValue(549.00);
		w.getSheet("order").getRow(3).createCell(2).setCellValue("2");
		FileOutputStream o = new FileOutputStream(f);
		w.write(o);
		System.out.println("completed");

	}

}
