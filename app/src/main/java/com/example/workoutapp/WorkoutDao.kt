package com.example.workoutapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {

    @Insert
    suspend fun insert(workoutEntity: WorkoutEntity)

    @Query("SELECT*FROM 'Workout_Entries'")
    fun fetchalldata():Flow<List<WorkoutEntity>>




}