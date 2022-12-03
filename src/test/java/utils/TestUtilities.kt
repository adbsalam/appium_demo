package utils

import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL


fun AndroidDriver<WebElement>.findTextViewByText(text: String): WebElement {
    return this.findElementByXPath("//android.widget.TextView[@text='$text']")
}

object TestUtilities {

    val APPIUM_SERVER_URL = URL("http://localhost:4723/wd/hub")
    val appId = "com.salam.testapp"

    fun getCapabilities(): DesiredCapabilities {
        val desiredCapabilities = DesiredCapabilities()
        desiredCapabilities.setCapability("platformName", "Android")
        desiredCapabilities.setCapability("appium:platformVersion", "13.0")
        desiredCapabilities.setCapability("appium:deviceName", "Samsung Galaxy Note10")
        desiredCapabilities.setCapability("appium:automationName", "Appium")
        desiredCapabilities.setCapability("appium:appActivity", "$appId.activities.mainactivity.MainActivity")
        desiredCapabilities.setCapability("appium:appPackage", appId)
        desiredCapabilities.setCapability("appium:app", "app-debug.apk")
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true)
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true)
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600)
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true)
        return desiredCapabilities
    }
}