package com.example.workoutapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.workoutapp.databinding.ExerciseDisplayNoBinding

class ExerciseAdapter(val List:ArrayList<exercisemodule>):RecyclerView.Adapter<ExerciseAdapter.ViewHolder>() {
    inner class ViewHolder(binding: ExerciseDisplayNoBinding):RecyclerView.ViewHolder(binding.root) {
        var item=binding.exerciseDisplayNumbers
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ExerciseDisplayNoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    // use to bind view data for the only item displaying on the screen
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items:exercisemodule=List[position]
        holder.item.text=items.getid().toString()

        when{

            items.getslected() ->{
                holder.item.background=ContextCompat.getDrawable(holder.itemView.context,R.drawable.background_for_exericse_selected)
            }

            items.getcompleted()->{
                holder.item.background=ContextCompat.getDrawable(holder.itemView.context,R.drawable.cirlce)
                holder.item.setTextColor(Color.parseColor("#FFFFFF"))

            }

            else ->{
                holder.item.background=ContextCompat.getDrawable(holder.itemView.context,R.drawable.background_for_exericse)
            }
        }


    }

    override fun getItemCount(): Int {
        return List.size
    }

}