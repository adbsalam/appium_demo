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

    fun getAndroidCapabilities(): DesiredCapabilities {
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

    fun getIosCapabilities(): DesiredCapabilities{
        val desiredCapabilities =  DesiredCapabilities()
        desiredCapabilities.setCapability("platformName", "iOS")
        desiredCapabilities.setCapability("platformVersion", "14.5")
        desiredCapabilities.setCapability("deviceName", "appium")
        desiredCapabilities.setCapability("automationName", "XCUITest")
        desiredCapabilities.setCapability("appium:app", "app.app")
        desiredCapabilities.setCapability("bundleId", "com.salam.appiumdemo.appium-demo-app");
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600)
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true)
        return desiredCapabilities
    }
}