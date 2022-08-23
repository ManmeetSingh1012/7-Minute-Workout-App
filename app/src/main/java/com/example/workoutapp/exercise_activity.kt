package com.example.workoutapp


import android.annotation.SuppressLint
import android.app.Application
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workoutapp.databinding.ActivityExerciseBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

public class exercise_activity  : AppCompatActivity(), TextToSpeech.OnInitListener {

    private var binding:ActivityExerciseBinding?=null

    private var timer:CountDownTimer?=null
    private var remaningTime=0

    private var timerExercise:CountDownTimer?=null
    private var remaningTimeExercise=0

    private  var ListExercise:ArrayList<exercisemodule>?=null
    private var currentposition=0

    private var textospeech:TextToSpeech?=null

    private var exerciseAdapter:ExerciseAdapter?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbar) // will set the toolbar as action bar for this activity

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // it  show back button or navigation button  when clicked go one step back


        // set navigation resoponds

        binding?.toolbar?.setNavigationOnClickListener{
            onBackPressed() // called when user want to go back
        }



        textospeech= TextToSpeech(this,this)
        ListExercise=Constraints.exerciselist()

        resttimer()



        setadapter()



    }

    override fun onBackPressed() {
backpressed()
    }

private fun backpressed()
    {
    val dialog=Dialog(this)
dialog.setContentView(R.layout.customdialog)

        val btn:Button=dialog.findViewById(R.id.ys)
        val btn2:Button=dialog.findViewById(R.id.No)

        btn?.setOnClickListener {
            this.finish()
            dialog.dismiss()
        }

        btn2?.setOnClickListener {
            dialog.dismiss()
        }
        dialog.setCancelable(false)
dialog.show()

}

    // here we are giving final touch to our recyler view
    // we will do two things first we will set the layout
    // secondly we will set our adpater
    private fun setadapter()
    {
        // setting layout of the layout
        binding?.recyler?.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        // adapter created
        exerciseAdapter= ExerciseAdapter(ListExercise!!)
        // adpater given to the recyler view
        binding?.recyler?.adapter=exerciseAdapter
    }


    // rest time
    private fun resttimer()
    {



        if(timer!=null)
        {
            timer!!.cancel()
            timer=null
            remaningTime = 0

        }


        settimer()
    }

    // setting rest timer screen

    @SuppressLint("SetTextI18n")
    private fun settimer()
    {
        binding?.flProgressExercise?.visibility=View.INVISIBLE
        binding?.imageview?.visibility=View.INVISIBLE
        binding?.readytext?.text="Get Ready for Exercise "+ListExercise!![currentposition+1].getexercisename()
        tts(binding?.readytext?.text.toString())
        binding?.flProgress?.visibility=View.VISIBLE

        binding?.progressBar?.progress=remaningTime
        timer=object : CountDownTimer(1000, 1000) {


            override fun onTick(millisUntilFinished: Long) {
                remaningTime++
                binding?.progressBar?.progress=10-remaningTime
                binding?.timer?.text=(millisUntilFinished/1000).toString()
            }

            override fun onFinish() {
                //Toast.makeText(this@exercise_activity,"Start the activity",Toast.LENGTH_SHORT).show()

                // this will set the selected circle
                ListExercise!![currentposition].setselected(true)

                exerciseAdapter!!.notifyDataSetChanged()
                setExerciesetimer()
            }
        }.start()
    }

    //exercise timer
    private fun setExerciesetimer()
    {
        if(timerExercise!=null)
        {
            timerExercise!!.cancel()
            timerExercise=null
            remaningTimeExercise=0
        }

        Exercisetimer()
    }

    // setting exercise timer
    private fun Exercisetimer()
    {
        currentposition++


        binding?.flProgressExercise?.visibility=View.VISIBLE
        binding?.imageview?.visibility=View.VISIBLE
        binding?.imageview?.setImageResource(ListExercise!![currentposition].getimage())
        binding?.readytext?.text=ListExercise!![currentposition].getexercisename()

        binding?.flProgress?.visibility=View.INVISIBLE


        binding?.progressBarExercise?.progress=remaningTimeExercise

        timerExercise=object : CountDownTimer(1000, 1000) {


            override fun onTick(millisUntilFinished: Long) {
                remaningTimeExercise++
                binding?.progressBarExercise?.progress=30-remaningTimeExercise
                binding?.timerExercise?.text=(millisUntilFinished/1000).toString()

            }

            override fun onFinish() {
                //Toast.makeText(this@exercise_activity,"Rest time",Toast.LENGTH_SHORT).show()
                if(currentposition< ListExercise!!.size) {

                    ListExercise!![currentposition-1].setcompleted(true)
                    ListExercise!![currentposition-1].setselected(false)

                    // when some changes occur then we have to explicitly tell the changes to reyclerview
                    exerciseAdapter?.notifyDataSetChanged()

                    resttimer()
                }
                if(currentposition  == 10)
                {
                    val intent=Intent(this@exercise_activity,End_Activity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }.start()
    }

    override fun onInit(status: Int) {
        if(status==TextToSpeech.SUCCESS) {
            var result = textospeech?.setLanguage(Locale.ENGLISH)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("tts", "Language is not supported")
            }
        }
            else
            {
                Log.e("tts","Error occured")
            }

    }

    private fun tts(text:String)
    {
        textospeech!!.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }


    override fun onDestroy() {
        super.onDestroy()
        if(timer!=null)
        {
            timer!!.cancel()
            remaningTime=0
            binding=null
        }

        if(timerExercise!=null)
        {
            timerExercise!!.cancel()
            remaningTimeExercise=0
            binding=null
        }

        if(textospeech!=null)
        {
            textospeech?.stop()
            textospeech?.shutdown()
            textospeech=null
        }
    }




}