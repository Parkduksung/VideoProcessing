package com.example.videoprocessing.mediacodec

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.videoprocessing.R

class MediaCodecMainActivity : AppCompatActivity() {
    
    private var routeButton : Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_media_codec_main)

        routeButton = findViewById(R.id.route_button)

        routeButton?.setOnClickListener {
            startActivity(Intent(this, MediaCodecSubActivity::class.java))
        }

    }
}