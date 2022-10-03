package com.marcoapm.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

internal class NotificationController {

    //Creates a Builder and send an Notification to User
    fun showNotification(context: Context, content:String, title:String) = with(context) {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher).setOngoing(true)
            .setContentTitle(title)
            .setContentText(content)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        NotificationManagerCompat.from(this).notify(NOTIFICATION_ID, builder.build())
    }

    fun createNotificationChannel(context: Context) = with(context) {
        //Channels are implemented in Android O, so we need to check version before create a channel.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.notification_channel_name) //Channel name
            val descriptionText = getString(R.string.notification_channel_description) // Channel description
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            //Creates a Notification Channel
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private companion object {
        private const val CHANNEL_ID:String = "channel_id"
        private const val NOTIFICATION_ID:Int = 999
    }
}

