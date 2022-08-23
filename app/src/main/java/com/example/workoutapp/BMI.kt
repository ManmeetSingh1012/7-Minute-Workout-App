package com.example.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.workoutapp.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMI : AppCompatActivity() {
    var binding:ActivityBmiBinding?=null
    lateinit var visible:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // setting action bar
        setSupportActionBar(binding?.actionBar)

        // setting navigation bar 
        supportActionBar?.setDisplayHomeAsUpEnabled(true)




        binding?.actionBar?.setNavigationOnClickListener {
            onBackPressed()
        }





        makeMetric()
        // we use seton checked clicked listner for radio group
        binding?.radiogroup?.setOnCheckedChangeListener { _, checkedId:Int ->
            if(checkedId == R.id.matric)
            {
                makeMetric()
            }
            else
            {
                makeUs()
            }
        }

        binding?.calculate?.setOnClickListener {

            calculate()

        }



    }

    // this fun is use when we will click on calculate button on the basis of selected one
    private fun calculate()
    {
        if(visible == "Matric") {
            if (checkmatric()) {
                val hieght: Float = binding?.hieght?.text.toString().toFloat() / 100
                val weight: Float = binding?.weight?.text.toString().toFloat()

                val bmi = weight / (hieght * hieght)
                setvalue(bmi)
            } else {
                Toast.makeText(this, "Error occured", Toast.LENGTH_SHORT).show()
            }
        }

        else
        {
            if(checkus())
            {
                val hieghtIN=binding?.hieghtFoot?.text.toString().toFloat()*12
                val hieght2=binding?.hieghtInches?.text.toString().toFloat()
                val hieght_value=hieght2+hieghtIN

                val weight = binding?.weight?.text.toString().toFloat()*2.2
                val bmi:Any= 703*(weight/(hieght_value*hieght_value))

                setvalueUs(bmi as Double)


            }

            else {
                Toast.makeText(this, "Error occured", Toast.LENGTH_SHORT).show()
            }
        }
    }


    // setting value for matric system
    private fun setvalue(bmi: Float) {
        binding?.bmiValue?.visibility=View.VISIBLE
        binding?.text1?.visibility=View.VISIBLE
        binding?.texts?.visibility=View.VISIBLE
        binding?.text2?.visibility=View.VISIBLE

       var string1:String
       var string2:String

       if(bmi<16f)
       {
           string1="very Underweight"
           string2="Danger!Hey you start eating high calories food"
       }
       if( bmi >16f && bmi<18.5f)
       {
           string1="Underweight"
           string2="Opps!Your are underweight start eating high protien food"
       }

        else if( bmi > 18.5f && bmi < 25f)
       {
            string1="Normal"
           string2="Good!Your are a healthy person"
       }

        else if(bmi>25f && bmi<30f)
       {
            string1="overweight"
           string2="Caution!You are unhelthy person"
       }

        else
       {
           string1="Too overweight"
           string2="Emergency! Start exercise now your are too much overweihted"
       }

        val ans=BigDecimal(bmi.toDouble()).setScale(2,RoundingMode.HALF_EVEN).toString()
        binding?.bmiValue?.text=ans
        binding?.text1?.text=string1
        binding?.text2?.text=string2
        binding?.texts?.text="Your Body Mass Index is"

    }

    //setting value for us based system
    private fun setvalueUs(bmi: Double) {
        binding?.bmiValue?.visibility=View.VISIBLE
        binding?.text1?.visibility=View.VISIBLE
        binding?.texts?.visibility=View.VISIBLE
        binding?.text2?.visibility=View.VISIBLE

        var string1:String
        var string2:String

        if(bmi<16f)
        {
            string1="very Underweight"
            string2="Danger!Hey you start eating high calories food"
        }
        if( bmi >16f && bmi<18.5f)
        {
            string1="Underweight"
            string2="Opps!Your are underweight start eating high protien food"
        }

        else if( bmi > 18.5f && bmi < 25f)
        {
            string1="Normal"
            string2="Good!Your are a healthy person"
        }

        else if(bmi>25f && bmi<30f)
        {
            string1="overweight"
            string2="Caution!You are unhelthy person"
        }

        else
        {
            string1="Too overweight"
            string2="Emergency! Start exercise now your are too much overweihted"
        }

        val ans=BigDecimal(bmi.toDouble()).setScale(2,RoundingMode.HALF_EVEN).toString()
        binding?.bmiValue?.text=ans
        binding?.text1?.text=string1
        binding?.text2?.text=string2
        binding?.texts?.text="Your Body Mass Index is"

    }


    // it will set metric UI when we clicked on radio metric btton
    private fun makeMetric()
    {
        visible="Matric"
        binding?.hieghtFieldCm?.visibility=View.VISIBLE
        binding?.usystem?.visibility=View.INVISIBLE
        binding?.hieghtFieldFoot?.visibility=View.INVISIBLE

        binding?.weight?.text?.clear()
        binding?.hieght?.text?.clear()


        binding?.text1?.visibility=View.INVISIBLE
        binding?.texts?.visibility=View.INVISIBLE
        binding?.text2?.visibility=View.INVISIBLE
        binding?.bmiValue?.visibility=View.INVISIBLE

    }

    // it will make UI for Us when us radio btn is seleected
    private fun makeUs()
    {
        visible="Us"
        binding?.hieghtFieldCm?.visibility=View.INVISIBLE
        binding?.usystem?.visibility=View.VISIBLE
        binding?.hieghtFieldFoot?.visibility=View.VISIBLE

        binding?.weight?.text?.clear()
        binding?.hieghtFoot?.text?.clear()
        binding?.hieghtInches?.text?.clear()

        binding?.text1?.visibility=View.INVISIBLE
        binding?.texts?.visibility=View.INVISIBLE
        binding?.text2?.visibility=View.INVISIBLE
        binding?.bmiValue?.visibility=View.INVISIBLE
    }

    // it will check values are empty or not in metric
    private fun checkmatric():Boolean
    {
        val ans:Boolean=true
        if(binding?.hieght?.text.toString().isEmpty())
        {
            return false
        }

        else if(binding?.weight?.text.toString().isEmpty())
        {
            return false
        }

        return ans
    }

    // use to check the Us value are enterd or not
    private fun checkus():Boolean
    {
        val ans:Boolean=true
        if(binding?.hieghtInches?.text.toString().isEmpty())
        {
            return false
        }

        if(binding?.hieghtFoot?.text.toString().isEmpty())
        {
            return false
        }

        else if(binding?.weight?.text.toString().isEmpty())
        {
            return false
        }

        return ans
    }

    
}


