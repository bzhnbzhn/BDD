package com.cucumber.junit.steps;

import com.cucubber.junit.pages.HomePage;
import com.cucubber.junit.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MenuSteps {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

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

}
