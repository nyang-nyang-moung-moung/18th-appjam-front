package com.example.appjam18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.ArrayList

class Onboard : AppCompatActivity() {

    private lateinit var arrayList : ArrayList<Int>

    lateinit var dummy : ArrayList<Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard)

        dummy.add(R.drawable.one)
        dummy.add(R.drawable.two)
        dummy.add(R.drawable.three)


    }


}
