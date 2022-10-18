package com.cucumber.junit.steps;

import com.cucubber.junit.pages.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.ContactPageTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MenuSteps {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    private final CartPage cartPage = new CartPage();
    private final CheckOutPage checkOutPage = new CheckOutPage();
    private final ContactPage contactPage = new ContactPage();
    private final ContactPageTest contactPageTest = new ContactPageTest();

    @When("the user open web site")
    public void theUserOpenWebSite() {
        homePage.openWebsite();
    }

    @When("the user clicks on the {string} section")
    public void clickOnSection(String section) {
        homePage.menuSection(section).click();
    }

    @When("I enter {string} in the {string} field")
    public void enterValueInField(String value, String field) {
        loginPage.setFieldValue(value, field);
    }

    @When("I press the {string} button")
    public void clickButton(String button) {
        loginPage.clickButton(button);
    }

    @Then("page with title {string} is displayed")
    public void verifyPageTitlePresence(String pageTitle) {
        assertThat(loginPage.isPageWithTitleDisplayed(pageTitle))
                .overridingErrorMessage("Page with title '%s' is not displayed", pageTitle)
                .isTrue();
    }

    @Then("{string} section is displayed")
    public void sectionIsDisplayed(String section) {
        assertThat(homePage.menuSection(section).isDisplayed())
                .overridingErrorMessage("Page with title '%s' is not displayed", section)
                .isTrue();
    }

    @When("the user open product {string} details page")
    public void openProductDetailsPage(String productIdOrName) {
        homePage.openProductDetailsPage(productIdOrName);
    }

    @When("the user clicks on {string} button in PDP")
    public void clickButtonInPDP(String button) {
        productDetailsPage.buttonInPDP(button).click();
    }

    @When("the user clicks on {string} button in PDP pop-up")
    public void clickOnButtonOnPDPPopUp(String button) {
        productDetailsPage.buttonInPDPPopUp(button).click();
    }

    @When("the user clicks on {string} button on Cart Page")
    public void theUserClicksOnButtonOnCartPage(String button) {
        cartPage.button(button).click();
    }

    @Then("basket {string} is equal to basket {string}")
    public void basketIsEqualToBasket(String firstValue, String secondValue) {
        assertThat(checkOutPage.value(firstValue).equalsIgnoreCase(checkOutPage.value(secondValue)))
                .withFailMessage("Values are not same");
    }

    @When("the user open EPAM web site")
    public void openEPAMWebSite() {
        homePage.openEPAMWebSite();
    }

    @Then("the company address displayed correctly")
    public void isStreetNumberShown() {
        String address = ContactPage.getAddress();
        Pattern pattern = Pattern.compile("(\\d{1,3}.\\w{3,20}.\\w{3,20})|([A-Za-z]{3,10} \\d{3})|((?<=\\n)[^,\\n]+(?=,))|([A-Z]{2}[ ]?\\d{5}?)|([A-Za-z0-9_-]{2,19}$)");
        Matcher matcher = pattern.matcher(address);
        assertThat(matcher.find()).isTrue()
                .withFailMessage("The company address displayed not correctly");

    }
}
