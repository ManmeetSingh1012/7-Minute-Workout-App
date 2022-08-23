package com.example.workoutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class End_Activity : AppCompatActivity() {
    var bttn:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        bttn=findViewById(R.id.finish_button)

        val workoutdao=(application as WorkoutApp).db.workoutDao()
        insertData(workoutdao)
        bttn?.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
    private fun insertData( workoutDao: WorkoutDao)
    {
        val c= Calendar.getInstance()
        val dateTime=c.time

        val sdf= SimpleDateFormat("dd /MM/yyyy HH:mm:ss", Locale.getDefault())
        val date=sdf.format(dateTime)
        Log.e("Format",""+date)

        /*lifecycleScope.launch {
            workoutDao.insert(WorkoutEntity(date=date))
        }*/
    }
}