package com.example.unittestexample.localtest

class Location {
    var cityName: String? = null
    var latitude = 0.0
    var longitude = 0.0

    constructor() {}
    constructor(cityName: String?, latitude: Double, longitude: Double) {
        this.cityName = cityName
        this.latitude = latitude
        this.longitude = longitude
    }

}