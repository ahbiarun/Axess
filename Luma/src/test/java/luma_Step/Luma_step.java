package luma_Step;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Luma_step {
	WebDriver driver;
	static Robot r;
	static Actions a;
	static JavascriptExecutor js;

	@Given("user will enter the url in chrome browser")
	public void user_will_enter_the_url_in_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
	}

	@When("user will click the sign in button")
	public void user_will_click_the_sign_in_button() {
		WebElement sign = driver.findElement(By.className("authorization-link"));
		sign.click();

	}

	@When("user will enter the emailaddress in the email id filed")
	public void user_will_enter_the_emailaddress_in_the_email_id_filed() {
		WebElement email = driver.findElement(By.name("login[username]"));
		email.sendKeys("abinayasenthilkumar1998@gmail.com");
	}

	@When("user will enter the password in the password field")
	public void user_will_enter_the_password_in_the_password_field() {
		WebElement pass = driver.findElement(By.name("login[password]"));
		pass.sendKeys("Abinaya@123");
	}

	@Then("user will click the signin button and we can continue the shopping")
	public void user_will_click_the_signin_button_and_we_can_continue_the_shopping() throws InterruptedException {
		WebElement sbutton = driver.findElement(By.xpath("(//span[text()='Sign In'])[1]"));
		sbutton.click();
		Thread.sleep(2000);
	}

	@When("user will click the category of women")
	public void user_will_click_the_category_of_women() throws AWTException {
		WebElement women = driver.findElement(By.xpath("//span[text()='Women']"));
		a = new Actions(driver);
		a.moveToElement(women).build().perform();
	}

	@When("user will select the tops option from the women category")
	public void user_will_select_the_tops_option_from_the_women_category() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	@When("user will select the jacket and it will display the collection of jacket")
	public void user_will_select_the_jacket_and_it_will_display_the_collection_of_jacket() throws InterruptedException {
		Thread.sleep(2000);
		WebElement jacket = driver.findElement(By.xpath("(//span[text()='Jackets'])[1]"));
		jacket.click();
	}

	@When("user will select the particular product")
	public void user_will_select_the_particular_product() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);
		WebElement jack = driver.findElement(By.xpath("(//strong[@class=\"product name product-item-name\"])[1]"));
		a.moveToElement(jack).build().perform();
		Thread.sleep(3000);
		WebElement add = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
		a.click(add).build().perform();

	}

	@When("user will select the size and color of the jacket")
	public void user_will_select_the_size_and_color_of_the_jacket() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@aria-label='S']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Blue']")).click();
	}

	@When("user will click the add to cart button")
	public void user_will_click_the_add_to_cart_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
		js.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(3000);
	}

	@When("once product is added user will click the cart")
	public void once_product_is_added_user_will_click_the_cart() {
		WebElement aa = driver.findElement(By.xpath("//div[@class='minicart-wrapper']"));
		aa.click();
	}

	@When("user will click the checkout button and it navigate to shipping page")
	public void user_will_click_the_checkout_button_and_it_navigate_to_shipping_page() {
		WebElement proceed = driver.findElement(By.id("top-cart-btn-checkout"));
		proceed.click();
	}

	@When("user  will check the shipping address and user will click next button")
	public void user_will_check_the_shipping_address_and_user_will_click_next_button() throws InterruptedException {
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
	}

	@When("it navigate to the payment page and user will check the payment method and click place order button")
	public void it_navigate_to_the_payment_page_and_user_will_check_the_payment_method_and_click_place_order_button()
			throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='action primary checkout']")).click();
	}

	@When("user will click mens category")
	public void user_will_click_mens_category() throws InterruptedException {
		Thread.sleep(3000);
		WebElement men = driver.findElement(By.xpath("//span[text()='Men']"));
		a.moveToElement(men).build().perform();

	}

	@When("user will click the tops from mens category")
	public void user_will_click_the_tops_from_mens_category() {
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	@When("user will click the jacket options from tops and it will show the collections of mens jacket")
	public void user_will_click_the_jacket_options_from_tops_and_it_will_show_the_collections_of_mens_jacket()
			throws InterruptedException {
		Thread.sleep(3000);
		WebElement jacket1 = driver.findElement(By.xpath("(//span[text()='Jackets'])[2]"));
		jacket1.click();
	}

	@When("user will select particular product from the mens jacket collection")
	public void user_will_select_particular_product_from_the_mens_jacket_collection() throws InterruptedException {
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)");
		WebElement tjacket = driver.findElement(By.xpath("//span[text()='$45.00']"));
		a.moveToElement(tjacket).build().perform();
		WebElement ad = driver.findElement(By.xpath("//button[@title='Add to Cart']"));

	}

	@When("user will select the size and color of the jacket men")
	public void user_will_select_the_size_and_color_of_the_jacket_men() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@aria-label='S']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Blue']")).click();
	}

	@When("user will click the add to cart buttonn")
	public void user_will_click_the_add_to_cart_buttonn() throws InterruptedException {
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
		js.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(3000);
	}

	@When("user will click the cart button")
	public void user_will_click_the_cart_button() throws InterruptedException {
		js.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(3000);
		WebElement bb = driver.findElement(By.xpath("//div[@class='minicart-wrapper']"));
		bb.click();
	}

	@When("user will click edit button but to edit the quantity")
	public void user_will_click_edit_button_but_to_edit_the_quantity() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@class='primary'])[2]")).click();
		Thread.sleep(3000);
		WebElement qt = driver.findElement(By.name("qty"));
		qt.clear();
		qt.sendKeys("2");
	}

	@When("once user done with edit and user will click the update options and it will navigate to shipping page")
	public void once_user_done_with_edit_and_user_will_click_the_update_options_and_it_will_navigate_to_shipping_page()
			throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Update Cart']")).click();
	}

	@When("user will check the shipping address and click next button and it will navigate to payment page")
	public void user_will_check_the_shipping_address_and_click_next_button_and_it_will_navigate_to_payment_page()
			throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Proceed to Checkout']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
	}

	@When("once user check the payment options and user will click the place oder button")
	public void once_user_check_the_payment_options_and_user_will_click_the_place_oder_button()
			throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='action primary checkout']")).click();
	}

	@When("user will click print receipt button and it navigate to next page page")
	public void user_will_click_print_receipt_button_and_it_navigate_to_next_page_page() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@rel='noopener'])[1]")).click();
		Thread.sleep(2000);
		Set<String> ww = driver.getWindowHandles();
		ArrayList<String> ab = new ArrayList<String>(ww);
		driver.switchTo().window(ab.get(1));

	}

	@When("in next page user will click print button")
	public void in_next_page_user_will_click_print_button() throws InterruptedException {
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_A);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_R);

	}

	@When("user will enter file name and user will click save button")
	public void user_will_enter_file_name_and_user_will_click_save_button() throws InterruptedException {
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		Set<String> ww = driver.getWindowHandles();
		ArrayList<String> ab = new ArrayList<String>(ww);
		driver.switchTo().window(ab.get(0));
		Thread.sleep(2000);
		driver.findElement(By.className("action switch")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("authorization-link")).click();

	}

}
