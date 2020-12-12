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

class MediaService: Service(), MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    private var mediaPlayer: MediaPlayer? = null
    private var currentPosition: Int = 0

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Logger.addLogAdapter(AndroidLogAdapter())

        startForeground(ONGOING_NOTIFICATION_ID, NotificationBuilder.build(applicationContext))

        when(intent?.action) {
            ACTION_PLAY -> {

                if (mediaPlayer != null && mediaPlayer?.isPlaying == true) {
                    Toast.makeText(applicationContext, "Already playing!", Toast.LENGTH_SHORT)
                        .show()
                    return START_NOT_STICKY
                }

                mediaPlayer = MediaPlayer.create(this, R.raw.song)
                mediaPlayer?.apply {
                    setOnPreparedListener(this@MediaService)
                    setOnCompletionListener(this@MediaService)
                }
            }
            ACTION_PAUSE -> {
                if (mediaPlayer == null)
                    Toast.makeText(applicationContext, "Nothing to pause", Toast.LENGTH_SHORT)
                else {
                    mediaPlayer?.pause()
                    mediaPlayer?.currentPosition?.let {
                        currentPosition = it
                    }
                    stopForeground(false)
                }
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
        mediaPlayer?.stop()
        mediaPlayer?.release()
        currentPosition = 0

        Logger.d("Service destroy")
    }

    override fun onPrepared(p0: MediaPlayer?) {
        mediaPlayer?.start()
        Logger.d("Audio Started")
    }

    override fun onCompletion(p0: MediaPlayer?) {
        Toast.makeText(applicationContext, "Audio completed", Toast.LENGTH_SHORT).show()
        currentPosition = 0
    }
}