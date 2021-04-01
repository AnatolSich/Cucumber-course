package learning.cucumbercourse.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import learning.cucumbercourse.BillCalculationHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class ScenarioOutlineSteps {

    int InitialBillAmount;
    double TaxRate;



    @Given("I have a Customer")
    public void i_have_a_Customer() {

    }

    @Given("user enters intial bill amount as {int}")
    public void user_enters_intial_bill_amount_as(Integer initialBillAmount) {
        this.InitialBillAmount = initialBillAmount;
        System.out.println("InitialBillAmount: " + initialBillAmount);
    }

    @Given("Sales Tax Rate is {double} Percent")
    public void sales_Tax_Rate_is_Percent(Double taxRate) {
        this.TaxRate = taxRate;
        System.out.println("Tax Rate: " + taxRate);
    }

    private void invokeWebPage(Double expectedValue) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/BasicServletSite/");

        //ids of web elements were gotten from index page->element->investigate
        WebElement billAmountTextBox = driver.findElement(By.id("billamount"));
        WebElement taxRateTextBox = driver.findElement(By.id("taxrate"));
        WebElement button = driver.findElement(By.id("mybutton"));

        //sending info to elements
        billAmountTextBox.sendKeys(Integer.toString(InitialBillAmount));
        taxRateTextBox.sendKeys(Double.toString(TaxRate));

        button.click();

        //find all h1 elements on result page
        WebElement Header1Element = driver.findElementByXPath("//h1");

        System.out.println(Header1Element.getText());

        //check if value of h1 element is as expected
        boolean matched = Header1Element.getText().contains("Final Bill Amount is: $" + expectedValue.toString());

        System.out.println(matched);

      //  driver.quit();
    }

    @Then("final bill amount calculated is {double}")
    public void final_bill_amount_calculate_is(Double expectedValue) {
        double SystemCalcValue =
                BillCalculationHelper.CalculateBillForCustomer(this.InitialBillAmount, this.TaxRate);
        System.out.println("Expected Value: " + expectedValue);
        System.out.println("Calculated Value: " + SystemCalcValue);
        System.out.println();
        assertEquals(expectedValue, SystemCalcValue, 0.0);
        invokeWebPage(expectedValue);
    }

}
