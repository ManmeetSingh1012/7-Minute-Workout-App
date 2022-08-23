package com.example.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workoutapp.databinding.ActivityHistoryBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HIstory : AppCompatActivity() {
    var binding:ActivityHistoryBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarHistory)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding?.toolbarHistory?.setNavigationOnClickListener {
            onBackPressed()
        }
       // val workoutdao=(application as WorkoutApp).db.workoutDao()




        //createAdapter(workoutdao)

    }

    /*private fun createAdapter(workoutDao: WorkoutDao) {

        lifecycleScope.launch {
            workoutDao.fetchalldata().collect {
                val lst=ArrayList(it)
                binding?.recyler?.layoutManager=LinearLayoutManager(this@HIstory)
                val adapter=WorkoutAdapter(lst)
                binding?.recyler?.adapter=adapter
                    /*allCompletedDatesList ->

                if (allCompletedDatesList.isNotEmpty()) {
                    binding?.recyler?.layoutManager = LinearLayoutManager(this@HIstory)

                    // History adapter is initialized and the list is passed in the param.
                    val dates = ArrayList<String>()
                    for (date in allCompletedDatesList) {
                        dates.add(date.date)
                    }
                    val workoutAdapter = WorkoutAdapter(ArrayList(dates))

                    // Access the RecyclerView Adapter and load the data into it
                    binding?.recyler?.adapter = workoutAdapter
                } else {
                        Toast.makeText(this@HIstory,"Nothing to show",Toast.LENGTH_SHORT).show()
                }*/

            }




        }
    }*/


}