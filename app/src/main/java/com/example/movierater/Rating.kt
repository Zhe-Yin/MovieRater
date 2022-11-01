package com.example.movierater

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movierater.databinding.ActivityRatingBinding

class Rating : AppCompatActivity() {
    private lateinit var binding: ActivityRatingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRatingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.apply{
//            var m = Movie()
//            name.text = m.title
        }
    }

}

