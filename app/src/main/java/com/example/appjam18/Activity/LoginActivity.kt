package com.example.appjam18.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.Toast
import com.example.appjam18.Data.Login
import com.example.appjam18.Data.ResultLogin
import com.example.appjam18.Utils.Utils
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.text.Editable
import android.view.View
import com.example.appjam18.R


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton.setOnClickListener {
            if (idText.text.toString().isNotEmpty() && pwText.text.toString().isNotEmpty()) {
                login()
            } else {
                Toast.makeText(applicationContext, "아이디와 비밀번호를 입력해주세요.", Toast.LENGTH_LONG).show()
            }
        }

        registerText.setOnClickListener {
            startActivity(Intent(applicationContext, registerActivity::class.java))
        }


        idText.addTextChangedListener(object : TextWatcher {


            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                idIm.visibility = View.GONE
                // 입력되는 텍스트에 변화가 있을 때

            }


            override fun afterTextChanged(arg0: Editable) {
                idIm.visibility = View.GONE
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

    private fun login() {
        var user = Login(idText.text.toString(), pwText.text.toString())
        val res: Call<ResultLogin> = Utils.service.login(user)
        res.enqueue(object : Callback<ResultLogin> {

            override fun onResponse(call: Call<ResultLogin>, response: Response<ResultLogin>) {
                when (response.code()) {
                    200 -> {
                        finish()
                        Toast.makeText(applicationContext, "로그인 성공 !", Toast.LENGTH_LONG).show()
                        startActivity(Intent(applicationContext, MainActivity::class.java))
                    }
                    400 -> Toast.makeText(applicationContext, "아이디 혹은 비밀번호가 틀렸습니다.", Toast.LENGTH_LONG).show()
                    500 -> Toast.makeText(applicationContext, "서버 오류 ~!", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ResultLogin>, t: Throwable) {

            }

        })

    }
}
