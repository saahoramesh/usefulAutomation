package AutomationProject.academy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	
	public Loginpage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="name")
	WebElement name;
	@FindBy(id="email")
	WebElement email;
	@FindBy(id="agreeTerms")
	WebElement agreeTerms;
	
	@FindBy(xpath = "//h5[@class='section-title h1']")

	WebElement title;
	
	
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;

	public WebElement getTitle() {
		return title;
	}

	

	
	
	
	
	public WebElement getSubmit() {
		return submit;
	}
	public WebElement getName() {
		return name;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getAgreeTerms() {
		return agreeTerms;
	}
	

}
