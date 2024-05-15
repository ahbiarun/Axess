package Axess_Technology.Dominos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dominos_PageObjectModel {
	WebDriver driver;
	@FindBy(linkText = "ORDER ONLINE NOW")
	private WebElement order_online;

	public WebElement getOrder_online() {
		return order_online;
	}

	@FindBy(xpath = "//button[@onclick='moeRemoveBanner()']")
	private WebElement dontallow;

	public WebElement getDontallow() {
		return dontallow;
	}

	@FindBy(xpath = "//input[@placeholder='Enter your delivery address']")
	private WebElement address;

	public WebElement getAddress() {
		return address;
	}

	@FindBy(xpath = "//input[@placeholder='Enter Area / Locality']")
	private WebElement pincode;

	public WebElement getPincode() {
		return pincode;
	}

	@FindBy(xpath = "(//li[@data-label='location_[object Object]'])[1]")
	private WebElement pin;

	public WebElement getPin() {
		return pin;
	}

//veg pizza
	@FindBy(xpath = "(//*[text()='VEG PIZZA'])[1]")
	private WebElement vegpizza;

	public WebElement getVegpizza() {
		return vegpizza;
	}

//Margherita pizza
	@FindBy(xpath = "//div[text()='VEG PIZZA']/../../following-sibling::div//span[text()='Margherita']/../following-sibling::div[contains(@class,'adCrt')]//button")
	private WebElement addtocart;

	public WebElement getAddtocart() {
		return addtocart;
	}

//Margherita addtocart
	@FindBy(xpath = "//span[text()='ADD']")
	private WebElement add;

	public WebElement getAdd() {
		return add;
	}

//Margherita count increase
	@FindBy(xpath = "(//div[@data-label='increase'])[3]")
	private WebElement plus;

	public WebElement getPlus() {
		return plus;
	}

//Peppy Paneer pizza
	@FindBy(xpath = "//div[text()='VEG PIZZA']/../../following-sibling:: div //span[text()='Peppy Paneer']/../following-sibling::div[contains(@class,'adCrt')]//button")
	private WebElement panner_pizza;

	public WebElement getPanner_pizza() {
		return panner_pizza;
	}

	@FindBy(xpath = "(//span[text()='Peppy Paneer'])[3]//following::div[7]")
	private WebElement panneer_plus;

	public WebElement getPanneer_plus() {
		return panneer_plus;
	}

	@FindBy(xpath = "//div[text()='VEG PIZZA']/../../following-sibling::div //span[text()='Primavera Gourmet-Pizza']/../following-sibling::div[contains(@class,'adCrt')]//button")
	private WebElement gourmentpizza;

	public WebElement getGourmentpizza() {
		return gourmentpizza;
	}

	@FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div/div[1]/div[3]/div/div/div[2]/div/div/div[2]/div")
	private WebElement gourmet_add;

	public WebElement getGourmet_add() {
		return gourmet_add;
	}

	@FindBy(xpath = "//span[text()='Subtotal']/../following-sibling::div//button[contains(@data-label,'miniCartCheckout')]")
	private WebElement check;

	public WebElement getCheck() {
		return check;
	}

	@FindBy(xpath = "//span[text()='BEVERAGES']")
	private WebElement beverages;

	public WebElement getBeverages() {
		return beverages;
	}

	@FindBy(xpath = "(//span[text()='Pepsi 475ml'])[2]//following::div[7]")
	private WebElement bev_increase;

	public WebElement getBev_increase() {
		return bev_increase;
	}

	@FindBy(xpath = "//span[text()='BEVERAGES']//../../following-sibling::div//span[text()='Pepsi 475ml']/../following-sibling::div//button")
	private WebElement bevAdd;

	public WebElement getBevAdd() {
		return bevAdd;
	}

	@FindBy(xpath = "(//div[@data-label='decrease'])[1]")
	private WebElement mar_decrease;

	public WebElement getMar_decrease() {
		return mar_decrease;
	}

	@FindBy(xpath = "(//div[@data-label='decrease'])[3]")
	private WebElement pesi_decrease;

	public WebElement getPesi_decrease() {
		return pesi_decrease;
	}

	@FindBy(xpath = "//span[text()='3613.67']")
	private WebElement grand;

	public WebElement getGrand() {
		
		return grand;
	}

	public Dominos_PageObjectModel(WebDriver dd) {
		driver = dd;
		PageFactory.initElements(driver, this);
	}

}
