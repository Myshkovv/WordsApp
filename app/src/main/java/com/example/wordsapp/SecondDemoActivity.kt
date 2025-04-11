package com.example.wordsapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wordsapp.databinding.ActivityFirstDemoBinding
import com.example.wordsapp.databinding.ActivitySecondDemoBinding

class SecondDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnOpenFirst.setOnClickListener {
                val intenet = Intent(this@SecondDemoActivity, FirstDemoActivity::class.java)
                startActivity(intenet)
            }

            val text = intent.getStringExtra("EXTRA_KEY_TEXT")
            val number = intent.getIntExtra("EXTRA_KEY_NUMBER", 0)

            tvText.text = text
            tvNumber.text = number.toString()

        }
    }
}