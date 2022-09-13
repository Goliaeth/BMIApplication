package com.nick.bmiapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nick.bmiapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.calculateButton.setOnClickListener {
            val weight = binding.weightEditText.text.toString().toFloat()
            val height = binding.heightEditText.text.toString().toFloat()

            val myBMI = weight / (height * height)

            binding.bmiTextView.text = myBMI.toString()

            if (myBMI < 18.5) {
                binding.bmiImageView.setImageResource(R.drawable.underweight)
            } else if (myBMI >= 18.5 && myBMI < 24.9) {
                binding.bmiImageView.setImageResource(R.drawable.healthy)
            } else if (myBMI >= 24.9 && myBMI < 29.9) {
                binding.bmiImageView.setImageResource(R.drawable.overweight)
            } else if (myBMI >= 29.9) {
                binding.bmiImageView.setImageResource(R.drawable.obesity)
            }
        }

    }
}