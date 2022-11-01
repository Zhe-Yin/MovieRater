package com.example.movierater

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.movierater.databinding.ActivityAddMovieBinding
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class AddMovie : AppCompatActivity() {
    private lateinit var binding: ActivityAddMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMovieBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.apply{
            //actionbar
            val actionbar = supportActionBar
            //set actionbar title
            actionbar!!.title = "MovieRater"

            btnSubmit.setOnClickListener {
                validation()
            }
            below13.setOnClickListener{
                setvisibility()
            }

        }

    }

    private fun validation():Boolean{
        var haschk = true
        binding.apply {

            if(name.text.isEmpty()){
                name.error = "Name is empty"
                haschk = false
            }
            if(description.text.isEmpty()){
                description.error = "Description is empty"
                haschk = false
            }
            if(date.text.isEmpty()){
                date.error = "Date is empty"
                haschk = false

            }else{
                try{
                    val pattern = "yyyy-MM-dd"
                    val simpleDateFormat = SimpleDateFormat(pattern)
                    val date: String = simpleDateFormat.format(date.toString())
                    println(date)
                }catch(e:Exception){
                    date.error = "Date format is wrong (dd-mm-yyyy)"
                    haschk = false
                }
            }
            if(below13.isChecked == true){
                if(violence.isChecked == false && languageused.isChecked == false){
                    below13.error = "Please check either Violence / Language Used or Both"
                    haschk = false
                }
            }
            if(haschk == true){
                val language_grp:RadioGroup = findViewById(R.id.group_language)
                val language_button = language_grp.checkedRadioButtonId
                val message: ArrayList<String> = arrayListOf(
                    "Title = ${name.text}",
                    "Overview = ${description.text}",
                    "Language = ${language_button.toString()}",
                    "Date = ${date.text}",
                    "Not suitable for all ages = ${below13.isChecked}"
                )
                if(below13.isChecked == true){
                    if(violence.isChecked == true && languageused.isChecked == true){
                        message.add("Reason:\nViolence\nLanguage")
                    }
                    else if(violence.isChecked == true){
                        message.add("Reason: Violence")
                    }else if(languageused.isChecked == true){
                        message.add("Reason: Language")
                    }
                }

                Toast.makeText(applicationContext,message.joinToString("\n"),Toast.LENGTH_LONG).show()

            }

        }
        return haschk
    }


    private  fun setvisibility() {
        binding.apply {
            val linear:LinearLayout = findViewById(R.id.layout_reasons)
            if(below13.isChecked){
                linear.visibility = View.VISIBLE
            }else{
                linear.visibility = View.INVISIBLE
            }
        }
    }

}
