package com.example.appjam18.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.appjam18.Data.Register
import com.example.appjam18.Data.ResultRegister
import com.example.appjam18.R
import com.example.appjam18.Utils.Utils.service
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.pwText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_login.pwIm as pwIm1

class registerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerButton.setOnClickListener {
            if (emailText.text.toString().isNotEmpty() && pwText.text.toString().isNotEmpty()
                && nameText.text.toString().isNotEmpty() && ageText.text.toString().isNotEmpty()
            ) {
                join()
            } else {
                Toast.makeText(applicationContext, "필수 항목을 다 입력해주세요 !", Toast.LENGTH_LONG).show()
            }
        }

        nameText.addTextChangedListener(object : TextWatcher {


            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                reIm.visibility = View.GONE
                // 입력되는 텍스트에 변화가 있을 때

            }


            override fun afterTextChanged(arg0: Editable) {
                reIm.visibility = View.GONE
                // 입력이 끝났을 때

            }


            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                // 입력하기 전에

            }

        })

        emailText.addTextChangedListener(object : TextWatcher {


            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                emIm.visibility = View.GONE
                // 입력되는 텍스트에 변화가 있을 때

            }


            override fun afterTextChanged(arg0: Editable) {
                emIm.visibility = View.GONE
                // 입력이 끝났을 때

            }


            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                // 입력하기 전에

            }

        })
        ageText.addTextChangedListener(object : TextWatcher {


            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                ageIm.visibility = View.GONE
                // 입력되는 텍스트에 변화가 있을 때

            }


            override fun afterTextChanged(arg0: Editable) {
                ageIm.visibility = View.GONE
                // 입력이 끝났을 때

            }


            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                // 입력하기 전에

            }

        })
        pwText.addTextChangedListener(object : TextWatcher {


            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                pwIm.visibility = View.GONE
                // 입력되는 텍스트에 변화가 있을 때

            }


            override fun afterTextChanged(arg0: Editable) {
                pwIm.visibility = View.GONE
                // 입력이 끝났을 때

            }


            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                // 입력하기 전에

            }

        })
    }

    fun join() {
        var Age = Integer.parseInt(ageText.text.toString())
        var signup = Register(emailText.text.toString(), pwText.text.toString(), nameText.text.toString(), Age)
        val call: Call<ResultRegister> = service.register(signup)
        call.enqueue(object : Callback<ResultRegister> {
            override fun onResponse(call: Call<ResultRegister>, response: Response<ResultRegister>) {
                when (response.code()) {
                    200 -> {
                        finish()
                        Toast.makeText(applicationContext, "회원가입 성공 !", Toast.LENGTH_LONG).show()
                        startActivity(Intent(applicationContext, LoginActivity::class.java))
                    }
                    400 -> Toast.makeText(applicationContext, "이미 존재하는 아이디 입니다.", Toast.LENGTH_LONG).show()
                    409 -> Toast.makeText(applicationContext, "서버 오류 !", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ResultRegister>, t: Throwable) {

            }

        })
    }
}
