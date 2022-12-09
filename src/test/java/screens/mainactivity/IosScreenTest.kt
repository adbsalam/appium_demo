package screens.mainactivity

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.openqa.selenium.WebElement
import utils.TestUtilities
import java.net.MalformedURLException

@RunWith(JUnit4::class)
class IosScreenTest {

    private lateinit var driver : IOSDriver<WebElement>

    @Before
    @Throws(MalformedURLException::class)
    fun setUp() {
        driver = IOSDriver<WebElement>(TestUtilities.APPIUM_SERVER_URL, TestUtilities.getIosCapabilities())
    }

    @Test
    fun waitAppLoad(){
        Thread.sleep(5000)
    }

}