package com.example.wordsapp

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.versionedparcelable.VersionedParcelize
import com.example.wordsapp.databinding.ActivityFirstDemoBinding
import kotlinx.parcelize.Parcelize
import java.io.Serializable

class FirstDemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        

        binding = ActivityFirstDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val word  = ExtraWord(
            "galaxy",
            "галактика"
        )

        binding.btnOpenSecond.setOnClickListener {
            val intent = Intent(this@FirstDemoActivity, SecondDemoActivity::class.java).apply {
                putExtra("EXTRA_KEY_TEXT", "dont panic")
                putExtra("EXTRA_KEY_NUMBER", 42)
                putExtra("EXTRA_KEY_WORD", word)
            }


            val bundle = Bundle()
//            bundle.putString("EXTRA_KEY_TEXT", "dont panic")
//            bundle.putInt("EXTRA_KEY_NUMBER", 42)
//            bundle.putParcelable("EXTRA_KEY_WORD", word)
            intent.putExtras(
                bundleOf(
                    "EXTRA_KEY_TEXT" to "dont panic",
                    "EXTRA_KEY_NUMBER" to 42,
                    "EXTRA_KEY_WORD" to word,

                )
            )

            startActivity(intent)
        }
    }
    @Parcelize
    data class ExtraWord(
        val original: String,
        val translate: String,
        var learned: Boolean = false,
    ) : Parcelable

//    data class ExtraWord(
//        val original: String,
//        val translate: String,
//        var learned: Boolean = false,
//    ) : Parcelable {
//        override fun describeContents(): Int {
//            return 0
//        }
//
//        override fun writeToParcel(p0: Parcel, p1: Int) {
//            p0.writeString(original)
//            p0.writeString(translate)
//            p0.writeByte(if (learned) 1 else 0)
//
//        }
//
//        constructor(parcel: Parcel): this(
//            original = parcel.readString().toString(),
//            translate = parcel.readString().toString(),
//            learned = parcel.readByte() != 0.toByte()
//        )
//
//        companion object CREATOR : Parcelable.Creator<ExtraWord>{
//            override fun createFromParcel(source: Parcel): ExtraWord {
//                return ExtraWord(source)
//            }
//
//            override fun newArray(size: Int): Array<ExtraWord?> {
//                return arrayOfNulls(size)
//            }
//
//        }
//    }


//    data class ExtraWord(
//        val original: String,
//        val translate: String,
//        var learned: Boolean = false,
//    ) : Serializable



}