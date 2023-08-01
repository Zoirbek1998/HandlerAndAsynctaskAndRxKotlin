package com.example.handlerandasynctaskandrxkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log

class HandlerActivity : AppCompatActivity() {
    private lateinit var handler: Handler
    private var gameOn = false
    private var startTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler)

        startTime = System.currentTimeMillis()
        handler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                if (gameOn) {
                    Log.d("Time", "${System.currentTimeMillis() - startTime}")

                    handler.sendEmptyMessageDelayed(0, 1000)
                }
                gameOn = true
                handler.sendEmptyMessage(0)
            }
        }



    }
}