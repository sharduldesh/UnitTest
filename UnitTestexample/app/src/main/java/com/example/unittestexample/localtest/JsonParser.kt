package com.example.unittestexample.localtest


import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonSyntaxException


object JsonParser {
    private val gson = Gson()
    fun parseLocationFromJson(json: String?): Location {
        if (json == null || json.isEmpty()) {
            return Location()
        }
        try {
            val input = gson.fromJson(json, JsonObject::class.java)
            var cityName: String? = null
            var lat = 0.0
            var lng = 0.0
            val results = input.getAsJsonArray("results")
            if (results != null && results.size() > 0) {
                val firstItem = results[0].asJsonObject
                if (firstItem.has("formatted_address")) {
                    cityName = firstItem["formatted_address"].asString
                }
                if (firstItem.has("geometry")) {
                    val geometry = firstItem["geometry"].asJsonObject
                    if (geometry.has("location")) {
                        val location = geometry["location"].asJsonObject
                        if (location.has("lat")) {
                            lat = location["lat"].asDouble
                        }
                        if (location.has("lng")) {
                            lng = location["lng"].asDouble
                        }
                    }
                }
                return Location(cityName, lat, lng)
            }
        } catch (e: JsonSyntaxException) {
        }
        return Location()
    }
}
