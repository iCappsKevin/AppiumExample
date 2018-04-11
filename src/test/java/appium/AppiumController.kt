package appium

import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidElement
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.ios.IOSElement
import org.openqa.selenium.remote.DesiredCapabilities
import java.io.File
import java.net.URL
import java.util.concurrent.TimeUnit

class AppiumController {

    companion object {
        private const val DEFAULT_LOCAL = "http://127.0.0.1:4723/wd/hub"

        const val PLATFORM_ANDROID = "android"
        const val PLATFORM_IOS = "ios"

        // Choose one of the above
        const val EXECUTION_OS = PLATFORM_IOS
    }

    var driver: AppiumDriver<*>? = null

    fun start() {
        if (driver != null) return

        val rootPath = File(System.getProperty("user.dir"))
        val appsDir = File(rootPath, "/apps")

        when (EXECUTION_OS) {
            PLATFORM_ANDROID -> {
                val app = File(appsDir, "Contacts.apk")
                val capabilities = createCapabilities(PLATFORM_ANDROID, "NotUsed", "UiAutomator2", app.absolutePath)
                driver = AndroidDriver<AndroidElement>(URL(DEFAULT_LOCAL), capabilities)
            }
            PLATFORM_IOS -> {
                val app = File(appsDir, "Contacts.app")
                val capabilities = createCapabilities(PLATFORM_IOS, "iPhone 5s", "XCUITest", app.absolutePath)
                driver = IOSDriver<IOSElement>(URL(DEFAULT_LOCAL), capabilities)
            }
        }
        driver?.manage()?.timeouts()?.implicitlyWait(20, TimeUnit.SECONDS)
    }

    fun stop() {
        driver?.quit()
        driver = null
    }

    private fun createCapabilities(platformName: String, deviceName: String, automationName: String, appPath: String): DesiredCapabilities {
        return DesiredCapabilities().apply {
            setCapability("platformName", platformName)
            setCapability("deviceName", deviceName)
            setCapability("automationName", automationName)
            setCapability("app", appPath)
        }
    }
}