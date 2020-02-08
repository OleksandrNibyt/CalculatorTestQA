package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class CalcStepdefs {
    @Given("I go to a {string} page")
    public void iGoToAPage(String arg0) {
        getDriver().get("http://www.calculator.net/");
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String option) {
        assertThat(getDriver().findElement(By.xpath(" //div[@id='logo']")).isDisplayed());
        getDriver().findElement(By.xpath("//ul[@id='hl1']//a[contains(text(),'"+ option +"')]")).click();

    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).clear();
        assertThat(getDriver().findElement(By.xpath("//input[@id='cloanamount']")).getText().isEmpty());

        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).clear();
        assertThat(getDriver().findElement(By.xpath("//input[@id='cloanterm']")).getText().isEmpty());

        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).clear();
        assertThat(getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).getText().isEmpty());

        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).clear();
        assertThat(getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).getText().isEmpty());

        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).clear();
        assertThat(getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).getText().isEmpty());

        getDriver().findElement(By.xpath("//input[@id='csaletax']")).clear();
        assertThat(getDriver().findElement(By.xpath("//input[@id='csaletax']")).getText().isEmpty());

        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).clear();
        assertThat(getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).getText().isEmpty());
    }

    @And("I calculate")
    public void iCalculate() {
        getDriver().findElement(By.xpath("//body//input[@value='Calculate']")).click();
    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String error) {
        assertThat(getDriver().findElement(By.xpath("//div[@id='content']//table//font[contains(text(),'"+ error +"')]")).isDisplayed());
    }

    @And("I enter {string} price, {string} months, {string} interest, {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String price, String month, String interest, String downpayment, String tradein, String state, String percenttax, String fees) {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).sendKeys(price);
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).sendKeys(month);
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).sendKeys(interest);
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).sendKeys(downpayment);
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).sendKeys(tradein);
        getDriver().findElement(By.xpath("//select[@name='cstate']")).sendKeys(state);
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).sendKeys(percenttax);
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).sendKeys(fees);
    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String result) {
        assertThat(getDriver().findElement(By.xpath("//h2[@class='h2result']")).getText().contains(result));
    }
}
