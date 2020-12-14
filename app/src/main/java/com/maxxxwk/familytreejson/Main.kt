package com.maxxxwk.familytree

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.File
import java.lang.StringBuilder
import java.util.*


data class Person(
    @SerializedName("name")
    val name: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("mother")
    val mother: Person?,
    @SerializedName("father")
    val father: Person?,
    @SerializedName("numberOfRelatives")
    val numberOfRelatives: Int,
    @SerializedName("isAdult")
    val isAdult: Boolean
)
fun getJSONFromFile(): String{
    val file = File("file.json")
    val scanner = Scanner(file)
    var json = StringBuilder()
    while (scanner.hasNext()){
        json.append(scanner.nextLine())
    }
    scanner.close()
    return json.toString()
}
fun main() {
    val gson = Gson()
    val json = getJSONFromFile()
    val person = gson.fromJson(json, Person::class.java)
    println(person)
    println(gson.toJson(person))
}