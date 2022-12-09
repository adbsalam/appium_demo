package screens.mainactivity

import io.appium.java_client.android.AndroidDriver
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import utils.TestUtilities
import utils.findTextViewByText

class MainScreenStepDefinition {

    private lateinit var driver : AndroidDriver<WebElement>

    @Given("App is running and home screen is shown")
    fun app_is_running_and_home_screen_is_shown() {
        driver = AndroidDriver<WebElement>(TestUtilities.APPIUM_SERVER_URL, TestUtilities.getAndroidCapabilities())
    }

    @Then("Check if all visible items are as expected")
    fun check_if_all_visible_items_are_as_expected() {

        val actionBar = driver.findElementById("com.salam.testapp:id/action_bar")
        Assert.assertEquals(actionBar.isDisplayed, true)

        val tvDefaultCurrency = driver.findTextViewByText("Default Currency")
        Assert.assertEquals(tvDefaultCurrency.isDisplayed, true)

        val tvSelectAmount = driver.findTextViewByText("Select amount")
        Assert.assertEquals(tvSelectAmount.isDisplayed, true)

        val tvAmount = driver.findElementById("com.salam.testapp:id/tv_amount")
        Assert.assertEquals(tvAmount.isDisplayed, true)

        val tvSelectedCurrency = driver.findElementById("com.salam.testapp:id/spinner_currency")
        Assert.assertEquals(tvSelectedCurrency.text, "EUR")

        val btnFetch = driver.findElementById("com.salam.testapp:id/btn_fetch")
        Assert.assertEquals(btnFetch.text, "FETCH")

    }

    @When("I add amount and click on fetch button")
    fun i_add_amount_and_click_on_fetch_button() {
        val tvAmount = driver.findElementById("com.salam.testapp:id/tv_amount")
        tvAmount.sendKeys("10")
        Thread.sleep(1000)


        val btnFetch = driver.findElementById("com.salam.testapp:id/btn_fetch")
        btnFetch.click()
        Thread.sleep(2000)
    }

    @Then("Check if table history loaded or not")
    fun check_if_table_history_loaded_or_not() {
        val rvCurrencyList = driver.findElementById("com.salam.testapp:id/rates_list_recycler")
        Assert.assertEquals(rvCurrencyList.isDisplayed, true)

        val rvItem = rvCurrencyList.findElements(By.id("com.salam.testapp:id/layout_parent_view"))
        val areItemsLoaded = rvItem.size > 2
        Assert.assertEquals(areItemsLoaded, true)

        rvItem[0].click()
        Thread.sleep(1000)

        rvItem[1].click()
        Thread.sleep(1000)

        val btnHistory = driver.findElementById("com.salam.testapp:id/btn_history")
        Assert.assertEquals(btnHistory.isDisplayed, true)
        btnHistory.click();

        Thread.sleep(3000)
    }
}