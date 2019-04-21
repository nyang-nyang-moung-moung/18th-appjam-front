package com.example.appjam18.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appjam18.R
import kotlinx.android.synthetic.main.activity_my_page.*
import org.jetbrains.anko.startActivity

class MyPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        home.setOnClickListener {
            startActivity<MainActivity>()
        }
    }
}
