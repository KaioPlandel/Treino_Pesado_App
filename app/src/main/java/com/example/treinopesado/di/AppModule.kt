package com.example.treinopesado.di

import android.content.Context
import androidx.room.Room
import com.example.treinopesado.data.TrainDao
import com.example.treinopesado.data.TrainDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideTrainDao(trainDatabase: TrainDatabase): TrainDao = trainDatabase.trainDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): TrainDatabase =
        Room.databaseBuilder(
            context = context,
            TrainDatabase::class.java,
            "train_db"
        ).fallbackToDestructiveMigration()
            .build()
}