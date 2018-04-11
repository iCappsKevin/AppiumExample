package pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class ContactSearchPageAndroid(driver: AppiumDriver<*>) : ContactSearchPage {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

    @FindBy(id = "main_search")
    override lateinit var searchField: MobileElement

    @FindBy(id = "name")
    override lateinit var firstSearchResultName: MobileElement

    @FindBy(id = "fab")
    override lateinit var addButton: MobileElement

    override fun search(name: String) {
        searchField.sendKeys(name)
    }
}