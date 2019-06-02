package com.muhadif.kittyapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.muhadif.kittyapp.R

class SplashActivity : AppCompatActivity() {
    private val DELAY: Long = 3000
    private lateinit var handler: Handler

    internal val runnable: Runnable = Runnable{
        if(!isFinishing){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handler = Handler()

        handler.postDelayed(runnable, DELAY)
    }
}
