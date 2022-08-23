package com.example.workoutapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Workout_Entries")
data class WorkoutEntity(

    @PrimaryKey(autoGenerate = true)
    var Id:Int=0,

    var date:String


)
