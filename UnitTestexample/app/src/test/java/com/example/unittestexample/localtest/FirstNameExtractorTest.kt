package com.example.unittestexample.localtest

import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import com.example.unittestexample.localtest.FirstNameExtractor.extractFirstName


class FirstNameExtractorTest {
    private val Shardul = "Shardul"

//assertThat is junit method to check if specific value match to expected one
    @Test
    fun extractFirstName_NullInput_ReturnEmptyString() {
        Assert.assertThat(
            extractFirstName(null),
            CoreMatchers.`is`("")     //core matcher is matcher which matches the return value
        )
    }

    @Test
    fun extractFirstName_EmptyString_ReturnEmptyString() {
        Assert.assertThat(
            extractFirstName(""),
            CoreMatchers.`is`("")
        )
    }

    @Test
    fun extractFirstName_FullName_ReturnsCorrect() {
        Assert.assertThat<String>(
            extractFirstName("Shardul Deshpande"),
            CoreMatchers.`is`<String>(Shardul)
        )
    }

    @Test
    fun extractFirstName_FullNameAroundWhiteSpaces_ReturnsCorrect() {
        Assert.assertThat<String>(
            extractFirstName("Shardul Deshpande "),
            CoreMatchers.`is`<String>(Shardul)
        )
        Assert.assertThat<String>(
            extractFirstName(" Shardul Deshpande"),
            CoreMatchers.`is`<String>(Shardul)
        )
        Assert.assertThat<String>(
            extractFirstName("Shardul   Deshpande"),
            CoreMatchers.`is`<String>(Shardul)
        )
        Assert.assertThat<String>(
            extractFirstName("   Shardul Deshpande   "),
            CoreMatchers.`is`<String>(Shardul)
        )
        Assert.assertThat<String>(
            extractFirstName(" Shardul Deshpande  "),
            CoreMatchers.`is`<String>(Shardul)
        )
    }

    @Test
    fun extractFirstName_FirstName_ReturnsCorrect() {
        Assert.assertThat<String>(
            extractFirstName("Shardul"),
            CoreMatchers.`is`<String>(Shardul)
        )
    }

    @Test
    fun extractFirstName_FirstNameAroundWhiteSpaces_ReturnsCorrect() {
        Assert.assertThat<String>(
            extractFirstName("Shardul "),
            CoreMatchers.`is`<String>(Shardul)
        )
        Assert.assertThat<String>(
            extractFirstName(" Shardul"),
            CoreMatchers.`is`<String>(Shardul)
        )
        Assert.assertThat<String>(
            extractFirstName(" Shardul "),
            CoreMatchers.`is`<String>(Shardul)
        )
        Assert.assertThat<String>(
            extractFirstName("  Shardul   "),
            CoreMatchers.`is`<String>(Shardul)
        )
    }
}