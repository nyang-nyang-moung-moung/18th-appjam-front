package com.example.appjam18.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.appjam18.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_more.*
import kotlinx.android.synthetic.main.activity_my_page.*
import org.jetbrains.anko.startActivity

class MoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)
        webView2.apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()

            webView2.loadUrl("https://determined-shirley-3e46c4.netlify.com/{\"labels\": [\"4.21\",\"5.13\",\"6.7\",\"7.21\",\"8.15\",\"9.20\",\"10.1\",\"11.23\",\"12.26\"],\"data\": [27, 10, 34, 34, 20, 30, 34, 49, 43]}")
        }

        myPage1.setOnClickListener {
            startActivity<MyPage>()
        }

        home1.setOnClickListener {
            startActivity<MainActivity>()
        }
    }
}
