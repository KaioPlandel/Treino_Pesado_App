package com.example.treinopesado.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import java.lang.reflect.Type


data class Exercise(
    val name: String,
    val peso: Int = 0,
    val session: Int = 0,
    val repetition: Int,
    val comment: String = "",
    val rating: Float = 0f
)

class Converters {

    @TypeConverter
    fun listToJson(value: List<Exercise>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<Exercise>::class.java).toList()
}