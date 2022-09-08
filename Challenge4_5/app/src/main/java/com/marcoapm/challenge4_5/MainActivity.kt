package com.marcoapm.challenge4_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
        private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = savedInstanceState?.getString("KEY_TEXT") ?: "0"
        textView = findViewById(R.id.textView_counter)
        textView.text = text //set the textView text with bundle content after device rotate

        var count = 0
        if(text != "0")
            count = text.toInt()

        findViewById<Button>(R.id.button_add).setOnClickListener {
            textView.text = count++.toString()
        }
    }

    //saves some activity data in a bundle wich can be read after in onCreate method
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        textView = findViewById(R.id.textView_counter)
        val text = textView.text.toString()
        outState.putString("KEY_TEXT", text)
    }
}