package com.example.workoutapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workoutapp.databinding.ActivityHistoryBinding
import com.example.workoutapp.databinding.WorkoutHistoryLayoutBinding

class WorkoutAdapter(val lst:ArrayList<WorkoutEntity>):RecyclerView.Adapter<WorkoutAdapter.ViewHolder>(){

    class ViewHolder(binding: WorkoutHistoryLayoutBinding):RecyclerView.ViewHolder(binding.root)
    {
        //var time=binding.Time
        var date=binding.Date
        var number=binding.number
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(WorkoutHistoryLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itms=lst[position]
        holder.number.text= (position+1).toString()
        holder.date.text=itms.date
        //holder.time.text=itms.time

        /*holder.date.text=itms
        holder.number.text=(position+1).toString()*/

    }

    override fun getItemCount(): Int {
        return lst.size
    }
}