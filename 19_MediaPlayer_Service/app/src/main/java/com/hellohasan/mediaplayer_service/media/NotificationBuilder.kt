package com.hellohasan.mediaplayer_service.media

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import com.hellohasan.mediaplayer_service.MainActivity

object NotificationBuilder {

    val CHANNEL_ID = "AudioPlayerChannelID-2357"
    val REQUEST_CODE = 1658

    @RequiresApi(Build.VERSION_CODES.O)
    fun build(context: Context) : Notification {

        createNotificationChannel(context)
        val pendingIntent: PendingIntent =
            Intent(context, MainActivity::class.java).let { notificationIntent ->
                PendingIntent.getActivity(context, REQUEST_CODE, notificationIntent, 0)
            }

        return Notification.Builder(context, CHANNEL_ID)
            .setContentTitle("Media Player")
            .setContentText("Play - Pause - Resume - Stop")
            .setContentIntent(pendingIntent)
            .setOngoing(true)
            .build()
    }

    private fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = context.getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }
}