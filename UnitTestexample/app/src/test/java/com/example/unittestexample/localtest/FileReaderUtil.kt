package com.example.unittestexample.localtest

import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.net.URISyntaxException
import java.util.*

object FileReaderUtil {
    fun readFile(classLoader: ClassLoader, fileName: String?): String {
        var result = ""
        try {
            val resource = classLoader.getResource(fileName)
            val f = File(resource.toURI())
            val `in` = Scanner(FileReader(f))
            val b = StringBuilder()
            while (`in`.hasNextLine()) {
                b.append(`in`.nextLine())
            }
            result = b.toString()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: URISyntaxException) {
            e.printStackTrace()
        }
        return result
    }
}
