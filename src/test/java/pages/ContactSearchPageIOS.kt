package pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class ContactSearchPageIOS(driver: AppiumDriver<*>) : ContactSearchPage {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

    @FindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Search for contact\"]")
    override lateinit var searchField: MobileElement

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"Search results\"]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText")
    override lateinit var firstSearchResultName: MobileElement

    @FindBy(id = "Add")
    override lateinit var addButton: MobileElement

    override fun search(name: String) {
        searchField.click()
        searchField.sendKeys(name)
    }
}