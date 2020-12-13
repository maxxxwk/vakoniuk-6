package com.maxxxwk.familytree

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName


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
fun main() {
    val gson = Gson()
    val json = """
        {
            "name" : "Maksym",
            "age" : 18,
            "mother" : {
                    "name" : "Tetiana",
                    "age" : 50,
                    "mother" : {
                            "name" : "Maria",
                            "age" : 72,
                            "mother" : null,
                            "father" : null,
                            "numberOfRelatives" : 5,
                            "isAdult" : true
                        },
                    "father" : {
                            "name" : "Ivan",
                            "age" : 72,
                            "mother" : null,
                            "father" : null,
                            "numberOfRelatives" : 5,
                            "isAdult" : true
                        },
                    "numberOfRelatives" : 6,
                    "isAdult" : true
                },
            "father" : {
                    "name" : "Anatoliy",
                    "age" : 55,
                    "mother" : {
                            "name" : "Nadia",
                            "age" : 75,
                            "mother" : null,
                            "father" : null,
                            "numberOfRelatives" : 3,
                            "isAdult" : true
                        },
                    "father" : {
                            "name" : "Dmytro",
                            "age" : 78,
                            "mother" : null,
                            "father" : null,
                            "numberOfRelatives" : 3,
                            "isAdult" : true
                        },
                    "numberOfRelatives" : 2,
                    "isAdult" : true
                },
            "numberOfRelatives" : 9,
            "isAdult" : true
        }
    """
    val person = gson.fromJson(json, Person::class.java)
    println(person)
    println(gson.toJson(person))
}