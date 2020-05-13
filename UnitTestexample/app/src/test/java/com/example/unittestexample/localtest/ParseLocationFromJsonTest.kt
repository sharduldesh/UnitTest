package com.example.unittestexample.localtest

import com.example.unittestexample.localtest.JsonParser.parseLocationFromJson
import org.hamcrest.CoreMatchers
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test


class ParseLocationFromJsonTest {
    companion object {
        private const val CORRECT_CITY_NAME = "Dallas, TX, USA"
        private const val CORRECT_LATITUDE = 32.7766642
        private const val CORRECT_LONGITUDE = -96.79698789999999
        private const val NULL_COORDINATE = 0.0
        // JSON inputs
        private var correctInput: String? = null
        private var emptyResults: String? = null
        private var noCity: String? = null
        private var noResults: String? = null
    }

    @Before
    fun readJsonFilesToStrings() {
        val classLoader = this.javaClass.classLoader
        correctInput = FileReaderUtil.readFile(classLoader!!, "correctInput.json")
        emptyResults = FileReaderUtil.readFile(classLoader!!, "emptyResults.json")
        noCity = FileReaderUtil.readFile(classLoader!!, "noCity.json")
        noResults = FileReaderUtil.readFile(classLoader!!, "noResults.json")
    }

    @Test
    fun parseLocationFromJson_NullInput_EmptyLocation() {
        val location: Location = parseLocationFromJson(null)
        assertThatLocationIsEmpty(location)
    }

    @Test
    fun parseLocationFromJson_EmptyInput_EmptyLocation() {
        val location: Location = parseLocationFromJson("")
        assertThatLocationIsEmpty(location)
    }

    @Test
    fun parseLocationFromJson_EmptyJson_EmptyLocation() {
        val location: Location = parseLocationFromJson("{}")
        assertThatLocationIsEmpty(location)
    }

    @Test
    fun parseLocationFromJson_NotAJsonInput_EmptyLocation() {
        val location: Location = parseLocationFromJson("Some words")
        assertThatLocationIsEmpty(location)
    }

    @Test
    fun parseLocationFromJson_fullInput_CorrectResult() {
        val location: Location = parseLocationFromJson(correctInput)
        assertThat( location.cityName,CoreMatchers.`is`(CORRECT_CITY_NAME))
        assertThat( location.latitude, CoreMatchers.`is`(CORRECT_LATITUDE))
        assertThat( location.longitude, CoreMatchers.`is`(CORRECT_LONGITUDE))
    }

    @Test
    fun parseLocationFromJson_NoResults_EmptyLocation() {
        val location: Location = parseLocationFromJson(noResults)
        assertThatLocationIsEmpty(location)
    }

    @Test
    fun parseLocationFromJson_EmptyResults_EmptyLocation() {
        val location: Location = parseLocationFromJson(emptyResults)
        assertThatLocationIsEmpty(location)
    }


    @Test
    fun parseLocationFromJson_NoCity_NullCity() {
        val location: Location = parseLocationFromJson(noCity)
        assertThat(location.cityName, CoreMatchers.`is`(CoreMatchers.nullValue()))
        assertThat( location.latitude, CoreMatchers.`is`(CORRECT_LATITUDE))
        assertThat(location.longitude,CoreMatchers.`is`(CORRECT_LONGITUDE))
    }

    private fun assertThatLocationIsEmpty(location: Location) {
        assertThat(location.cityName, CoreMatchers.`is`(CoreMatchers.nullValue()))
        assertThat( location.latitude, CoreMatchers.`is`(NULL_COORDINATE))
        assertThat( location.longitude, CoreMatchers.`is`(NULL_COORDINATE))
    }
}
