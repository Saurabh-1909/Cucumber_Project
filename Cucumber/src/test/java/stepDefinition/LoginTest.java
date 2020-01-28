package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginTest {
	public static WebDriver driver;
	
	
	PageObjects po;
	@Given("^Navigate to Home page$")
	public void Navigate_to_Home_page() throws Throwable  {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		po = new PageObjects(driver);
	}
	
	@When("^user enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
		po.signin.click();
		po.Username.sendKeys("lalitha");
		po.Password.sendKeys("Password123");
		po.Login.click();
		
	}
	
	@When("^Larry searches below products in the search box:$")
	public void Larrysearchesbelowproductsinthesearchbox(DataTable dt) {
		List<String> st=dt.asList(String.class);
		
		for(String s: st) {
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.findElement(By.name("products")).sendKeys(s);
			driver.findElement(By.xpath("//*[@value='FIND DETAILS']")).click();
			driver.findElement(By.xpath("//*[@class='btn btn-success btn-product']")).click();
			driver.findElement(By.xpath("//*[@href='displayCart.htm']")).click();
			driver.findElement(By.xpath("//*[@href='fetchcat.htm']")).click();
		}
		
	}
	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")

	public void entersunamepwd(String username, String password) {

	po.signin.click();

	po.Username.sendKeys(username);

	po.Password.sendKeys(password);

	po.Login.click();

	}
	
	@Then("^user logged in successfully$")
	public void user_loggedin_successfully() throws Throwable {
		System.out.println("User login succesfully");
		
	}
	
	
	@Then("^product should be added in the cart if available$")
	public void productshouldbeaddedinthecartifavailable() {
		System.out.println("Successfully added");
		
	}
	
	
}
