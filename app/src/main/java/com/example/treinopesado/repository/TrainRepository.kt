package com.example.treinopesado.repository

import com.example.treinopesado.data.TrainDao
import com.example.treinopesado.model.Train
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class TrainRepository @Inject constructor(private val trainDao: TrainDao) {

    suspend fun addTrain(train: Train) = trainDao.addTrain(train)

    suspend fun deleteTrain(train: Train) = trainDao.deleteTrain(train)

    suspend fun updateTrain(train: Train) = trainDao.updateTrain(train)

    fun getAllTrains(): Flow<List<Train>> = trainDao.getTrains().flowOn(Dispatchers.IO).conflate()
}