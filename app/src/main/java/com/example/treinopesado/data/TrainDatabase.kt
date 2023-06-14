package com.example.treinopesado.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.treinopesado.model.Converters
import com.example.treinopesado.model.Train

@Database(entities = [Train::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class TrainDatabase: RoomDatabase() {
    abstract fun trainDao(): TrainDao
}