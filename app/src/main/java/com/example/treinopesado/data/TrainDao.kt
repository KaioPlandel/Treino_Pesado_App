package com.example.treinopesado.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.treinopesado.model.Train
import kotlinx.coroutines.flow.Flow

@Dao
interface TrainDao {

    @Query("SELECT * FROM train_table")
    fun getTrains(): Flow<List<Train>>

    @Query("SELECT * FROM train_table WHERE id =:id")
    suspend fun getTrainById(id: String): Train

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTrain(train: Train)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTrain(train: Train)

    @Delete
    suspend fun deleteTrain(train: Train)
}