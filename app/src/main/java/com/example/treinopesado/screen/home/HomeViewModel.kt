package com.example.treinopesado.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.treinopesado.model.Train
import com.example.treinopesado.repository.TrainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: TrainRepository) : ViewModel() {

    private val _trainList = MutableStateFlow<List<Train>>(emptyList())
    var trainList = _trainList.asStateFlow()

    var listOfTrain = emptyList<Train>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllTrains().distinctUntilChanged()
                .collectLatest {
                    if (it.isNotEmpty()) _trainList.value = it
                    listOfTrain = it
                }
        }
    }

    fun getTrainById(id: UUID): Train {
        val listTrain = mutableListOf<Train>()
        for (train in listOfTrain) {
            if (train.id == id) {
                listTrain.add(train)
            }
        }
        return listTrain[0]
    }

    fun addNewTrain(train: Train) = viewModelScope.launch { repository.addTrain(train) }
    fun deleteTrain(train: Train) = viewModelScope.launch { repository.deleteTrain(train) }

}