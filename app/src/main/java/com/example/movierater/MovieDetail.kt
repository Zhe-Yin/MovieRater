package com.example.movierater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import com.example.movierater.databinding.ActivityMovieDetailBinding

class MovieDetail : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.apply{
            //actionbar
            val actionbar = supportActionBar
            //set actionbar title
            actionbar!!.title = "MovieRater"

            var m = Movie("Venom","Overview","English","19-10-2018",true)
            title.text = m.title
            overview.text = m.desc
            language.text = m.language
            date.text = m.date
            if(m.below13 == true){
                below13.text = "Yes"
            }else{
                below13.text = "No"
            }


        }


    }




}






