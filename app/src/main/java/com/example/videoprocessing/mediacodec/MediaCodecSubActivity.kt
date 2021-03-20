package com.example.videoprocessing.mediacodec

import android.media.MediaCodecList
import android.media.MediaFormat
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.videoprocessing.R

class MediaCodecSubActivity : AppCompatActivity() {

    companion object {
        private const val MIME_AVC = "video/avc"
    }


    private var mainContainer: ConstraintLayout? = null


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_codec_sub)


        mainContainer = findViewById(R.id.main_container)

        mainContainer?.let {
            it.viewTreeObserver.addOnGlobalLayoutListener {
                Log.d("결과", "width : ${it.width} height : ${it.height} ")
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
            "찾을 수 없다."
        }
    }

}



