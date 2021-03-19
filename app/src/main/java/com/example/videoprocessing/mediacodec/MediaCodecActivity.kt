package com.example.videoprocessing.mediacodec

import android.graphics.Point
import android.media.MediaCodecList
import android.media.MediaFormat
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.videoprocessing.R
import java.lang.Exception

class MediaCodecActivity : AppCompatActivity() {

    companion object {
        private const val MIME_AVC = "video/avc"
    }


    private var mainContainer: ConstraintLayout? = null


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_codec)


        mainContainer = findViewById(R.id.main_container)

        mainContainer?.let {
            it.viewTreeObserver.addOnGlobalLayoutListener {
                Log.d("결과", "높이 : ${it.height} 폭 : ${it.width}")
                Log.d("결과", "코덱결과 : ${mediaCodecResult(it.width, it.height)}")
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun mediaCodecResult(width: Int, height: Int): String {
        return try {
            val mediaFormat = MediaFormat.createVideoFormat(MIME_AVC, width, height)
            val mediaCodecList = MediaCodecList(MediaCodecList.ALL_CODECS)
            mediaCodecList.findDecoderForFormat(mediaFormat)
        } catch (e: Exception) {
            throw Exception("찾을 수 없다.")
        }
    }

}



