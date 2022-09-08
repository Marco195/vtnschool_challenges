package com.marcoapm.challenge1_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtView = findViewById<EditText>(R.id.conteudo_text)
        val button = findViewById<Button>(R.id.enviar_button)

        //Challenge 1
        button.setOnClickListener {
            //Send the text to another activity or android component
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, txtView.text.toString())
                type = "text/plain"
            }

            sendIntent.getStringExtra(Intent.EXTRA_TEXT)

            //Challenge 2
            //Open Android ShareSheet and allows to share string
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}