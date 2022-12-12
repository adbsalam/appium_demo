package screens.mainactivity

import io.appium.java_client.android.AndroidDriver
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import utils.TestUtilities
import utils.findTextViewByText
import java.net.MalformedURLException

@RunWith(JUnit4::class)
class MainScreenTest {

    private lateinit var driver : AndroidDriver<WebElement>

    @Before
    @Throws(MalformedURLException::class)
    fun setUp() {
        driver = AndroidDriver<WebElement>(TestUtilities.APPIUM_SERVER_URL, TestUtilities.getAndroidCapabilities())
    }

    @Test
    fun testHomePageInitialState(){

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

    @Test
    fun testInputCurrencyAndFetch(){
        val tvAmount = driver.findElementById("com.salam.testapp:id/tv_amount")
        tvAmount.sendKeys("10")
        Thread.sleep(1000)


        val btnFetch = driver.findElementById("com.salam.testapp:id/btn_fetch")
        btnFetch.click()
        Thread.sleep(2000)

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

    @After
    fun endTesting(){
        driver.quit()
    }

}