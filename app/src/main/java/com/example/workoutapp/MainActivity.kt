package com.example.workoutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.workoutapp.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    /*
    * View binding create a class for the xml layout related to activity
    * then the instance contains reference of all views and we can acess it using the id of the view
    * no nedd to create extra variable, it only valid for the acitvity for it is decleared
     */

    private var binding:ActivityMainBinding?=null // binding class for our main or this activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater) // creating instance to use the view of the layout
        setContentView(binding?.root) // setting the layout active on the screen

        //startButton=findViewById(R.id.flButton) // it works for all activity but view binding works only for the this activity
        binding?.flButton?.setOnClickListener {

            val intent=Intent(this, exercise_activity::class.java)
            startActivity(intent)
            

        }


        binding?.Bmi?.setOnClickListener {
            val intent=Intent(this,BMI::class.java)
            startActivity(intent)

        }

        binding?.history?.setOnClickListener {
            val intent=Intent(this,HIstory::class.java)
            startActivity(intent)

        }






    }




    override fun onDestroy() {
        super.onDestroy()

        binding =null
    }
}