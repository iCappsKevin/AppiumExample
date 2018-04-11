package test

import org.junit.Assert
import org.junit.Test

class TestContactSearch : BaseTest() {

    @Test
    fun searchContact() {
        searchPage.search("Sara")

        val searchResult = searchPage.firstSearchResultName
        Assert.assertEquals("Sara Alston", searchResult.text)

        searchResult.click()

        Assert.assertEquals("Sara Alston", detailPage.contactName.text)
    }

    @Test
    fun testAddButtonPresent() {
        val addButton = searchPage.addButton

        Assert.assertTrue(addButton.isDisplayed)
    }
}