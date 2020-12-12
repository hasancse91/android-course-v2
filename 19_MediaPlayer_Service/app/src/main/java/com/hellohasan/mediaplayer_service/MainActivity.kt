package com.hellohasan.mediaplayer_service

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hellohasan.mediaplayer_service.media.MediaService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var audioService: Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        audioService = Intent(this, MediaService::class.java)

        btn_play.setOnClickListener {
            audioService?.action = ACTION_PLAY
            startService(audioService)
        }

        btn_pause.setOnClickListener {
            audioService?.action = ACTION_PAUSE
            startService(audioService)
        }

        btn_resume.setOnClickListener {
            audioService?.action = ACTION_RESUME
            startService(audioService)
        }

        btn_stop.setOnClickListener {
            audioService?.action = ACTION_STOP
            stopService(audioService)
        }
    }
}