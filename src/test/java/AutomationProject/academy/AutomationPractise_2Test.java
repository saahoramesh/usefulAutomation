package AutomationProject.academy;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.base;

public class AutomationPractise_2Test extends base {
	WebDriver driver;
	AutomationPractice_2 autoP;
	int index = 1;
	List <WebElement> countries=null;
	@BeforeTest(groups={"Smoke"})
	public void navigateToAtomationPractise2Page() throws IOException {

		driver = initializeDriver("chrome");
		autoP = new AutomationPractice_2(driver);
		authenticateTheURL(new Loginpage(driver));
		Actions act=new Actions(driver);
		WebElement ap=autoP.getAutomationPractise();
		
		/*
		Actions moveToElement=act.moveToElement(ap);
		for(int i=0;i<4;i++)
		{
		moveToElement.sendKeys(Keys.DOWN).build().perform();
		
		}
		moveToElement.click().build().perform();;
		*/
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", ap);
		
	}
		
		

	@Test
	public void validateRadioButton() {

		List<WebElement> buttons = autoP.getRadioButtons();

		for (int i = 0; i < buttons.size(); i++) {
			if (i == index) {
				buttons.get(i).click();
				break;
			}
		}
	}

	@Test(groups={"Smoke"},priority=0)
	public void validateCheckBox() {

		List<WebElement> chck = autoP.getCheckboxes();
		for (int i = 0; i < chck.size(); i++) {
			if (i == index) {
				chck.get(i).click();
				break;
			}
		}
	}

	@Test
	public void validateSimpleDropDown() {

		Select sl = new Select(autoP.getDropDownSelect());
		sl.selectByIndex(index);

	}

	@Test(dataProvider="getData", groups={"Smoke"},priority=1)
	public void validateAutoSuggest(String countryInput, String countrySelectedExpected ) throws InterruptedException {

		autoP.getAutoComplete().sendKeys(countryInput);
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//String countryInput = (String) js.executeScript("return arguments[0].value", autoP.getAutoComplete());
		System.out.println(countryInput);
		System.out.println(countrySelectedExpected);
		countries=autoP.getCountries();
		
		for (WebElement country:countries)
		{
			System.out.println(country.getText());
			if(country.getText().equalsIgnoreCase(countrySelectedExpected))
				{
				Thread.sleep(1000);
				country.click();
				
				String countrySelectedActual= (String) js.executeScript("return arguments[0].value", autoP.getAutoComplete());
				System.out.println(countrySelectedActual);
				Assert.assertEquals(countrySelectedActual, countrySelectedExpected);
				autoP.getAutoComplete().clear();
				//Thread.sleep(1000);
				break;
				}
			
		}
		
	}
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data=new Object[2][2];
		data[0][0]="in";
		data[0][1]="India";
		data[1][0]="ba";
		data[1][1]="Bahrain";		
		return data;
		
	}
	@AfterTest(groups={"Smoke"})
	public void tearDown(){
		driver.close();
	}
	

}
