package com.rahul.mynews

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object FileReader {
    fun readTestResourcesFile(fileName: String): String {
        val fileInputStream = javaClass.classLoader?.getResourceAsStream(fileName)
        return fileInputStream?.bufferedReader()?.readText() ?: ""
    }

    fun <T> parseTestResourceFile(fileName: String): T {
        val gson = Gson()
        val type = object : TypeToken<T>() {}.type
        return gson.fromJson(readTestResourcesFile(fileName), type)
    }
}