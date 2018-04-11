package pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.pagefactory.iOSFindBy
import org.openqa.selenium.support.PageFactory

class ContactDetailPage(driver: AppiumDriver<*>) {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

    @AndroidFindBy(id = "detail_name")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Contacts\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    lateinit var contactName: MobileElement
}