package com.hellohasan.mediaplayer_service.media

import android.app.*
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.hellohasan.mediaplayer_service.*
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

class MediaService: Service(), MediaPlayer.OnPreparedListener {

    private var mediaPlayer: MediaPlayer? = null
    private var currentPosition: Int = 0

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        startForeground(ONGOING_NOTIFICATION_ID, NotificationBuilder.build(applicationContext))

        when (intent?.action) {
            ACTION_PLAY -> {

                mediaPlayer = MediaPlayer.create(applicationContext, R.raw.audio)
                mediaPlayer?.isLooping = true
                mediaPlayer?.setOnPreparedListener(this)
                mediaPlayer?.setOnCompletionListener {
                    Toast.makeText(applicationContext, "Audio completed", Toast.LENGTH_SHORT).show()
                    currentPosition = 0
                }
            }
            ACTION_PAUSE -> {
                mediaPlayer?.pause()
                mediaPlayer?.currentPosition?.let {
                    currentPosition = it
                }
                stopForeground(false)
            }
            ACTION_RESUME -> {
                if (currentPosition > 0) {
                    mediaPlayer?.seekTo(currentPosition)
                    mediaPlayer?.start()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Nothing to resume. Play the audio",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        return START_NOT_STICKY // if service is killed, OS won't restart it later
    }

    override fun onDestroy() {
        super.onDestroy()

        if (mediaPlayer?.isPlaying == true)
            mediaPlayer?.stop()
        mediaPlayer?.release()
    }

    override fun onPrepared(p0: MediaPlayer?) {
        mediaPlayer?.start()
    }

}