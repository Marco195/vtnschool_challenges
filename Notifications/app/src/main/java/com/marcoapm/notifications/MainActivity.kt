package com.marcoapm.notifications

import android.app.Notification
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myNotification = NotificationController()

        val notificationContent:EditText = findViewById(R.id.notificationContent_editText)
        val notificationTitle:EditText = findViewById(R.id.notificationTitle_editText)

        val sendNotificationButton:Button = findViewById(R.id.notification_button)


        sendNotificationButton.setOnClickListener {
            var content:String = notificationContent.text.toString()
            var title:String = notificationTitle.text.toString()

            Log.d("Marco","title: " + title + " Content: " + content)

            myNotification.createNotificationChannel(this)
            myNotification.showNotification(this, content, title)
        }
    }


}