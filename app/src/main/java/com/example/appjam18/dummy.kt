package com.example.appjam18

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.appjam18.Activity.LoginActivity
import com.example.appjam18.Activity.MainActivity

class dummy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dummy)
        val hander = Handler()
        hander.postDelayed({
            startActivity(Intent(this@dummy, MainActivity::class.java))
            finish()
        },3500)
    }
}
