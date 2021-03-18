package com.example.videoprocessing.mediacodec

import android.graphics.Point
import android.media.MediaCodecList
import android.media.MediaFormat
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.videoprocessing.R

class MediaCodecActivity : AppCompatActivity() {

    companion object {
        private const val MIME_AVC = "video/avc"
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_codec)


        val point = Point()
        val display = display?.getRealSize(point)

        //찾지를 못한다...
//        val mediaFormat = MediaFormat.createVideoFormat(MIME_AVC, 1080, 2265)
        val mediaFormat = MediaFormat.createVideoFormat(MIME_AVC, 1080, 2283)

        val mediaCodecList = MediaCodecList(MediaCodecList.ALL_CODECS)
        val result = mediaCodecList.findDecoderForFormat(mediaFormat)

        Log.d("결과", result?:"찾을수 없다.")

    }


}



