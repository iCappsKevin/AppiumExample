package test

import appium.AppiumController
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import pages.ContactDetailPage
import pages.ContactSearchPageAndroid
import pages.ContactSearchPageIOS

open class BaseTest {

    companion object {

        private val controller = AppiumController()

        @BeforeClass
        @JvmStatic
        fun beforeAll() { controller.start() }

        @AfterClass
        @JvmStatic
        fun afterAll() { controller.stop() }
    }

    protected val detailPage = ContactDetailPage(controller.driver!!)
    protected val searchPage = when (AppiumController.EXECUTION_OS) {
        AppiumController.PLATFORM_ANDROID -> ContactSearchPageAndroid(controller.driver!!)
        AppiumController.PLATFORM_IOS     -> ContactSearchPageIOS(controller.driver!!)
        else -> throw IllegalStateException("Execution OS should be PLATFORM_IOS or PLATFORM_ANDROID")
    }

    @Before
    fun setup() {
        controller.driver?.launchApp()
    }
}