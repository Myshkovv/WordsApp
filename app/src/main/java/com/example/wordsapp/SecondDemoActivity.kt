package com.example.wordsapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wordsapp.FirstDemoActivity.*
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
//            val word : ExtraWord = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                intent.getSerializableExtra("EXTRA_KEY_WORD", ExtraWord::class.java) as ExtraWord
//            } else {
//                intent.getSerializableExtra("EXTRA_KEY_WORD") as ExtraWord
//            }

//            val word2 = intent.extras?.getSerializable("EXTRA_KEY_WORD", ExtraWord::class.java)

            val word = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getParcelableExtra("EXTRA_KEY_WORD", ExtraWord::class.java)
            } else {
                intent.getParcelableExtra("EXTRA_KEY_WORD")
            }

            tvText.text = text
            tvNumber.text = number.toString()
            tvWord.text = word?.original

        }
    }
}