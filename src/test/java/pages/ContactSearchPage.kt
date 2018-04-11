package pages

import io.appium.java_client.MobileElement

interface ContactSearchPage {

    var searchField: MobileElement

    var firstSearchResultName: MobileElement

    var addButton: MobileElement

    fun search(name: String)
}