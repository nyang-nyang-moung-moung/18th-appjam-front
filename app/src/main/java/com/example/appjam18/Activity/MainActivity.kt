package com.example.appjam18.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.appjam18.R
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.appjam18.Data.Result_image
import com.example.appjam18.Data.image
import com.example.appjam18.Utils.Utils
import com.example.appjam18.cameraActivity
import com.example.appjam18.dummy
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView.apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()

            webView.loadUrl("https://determined-shirley-3e46c4.netlify.com/{\"labels\": [\"4.21\",\"5.13\",\"6.7\",\"7.21\",\"8.15\",\"9.20\",\"10.1\",\"11.23\",\"12.26\"],\"data\": [27, 10, 34, 34, 20, 30, 34, 49, 43]}")
        }


        fab.setOnClickListener {
            //            selectCamera()s
            startActivity<cameraActivity>()
        }

        totalMore.setOnClickListener {
            startActivity<MoreActivity>()
        }

        myPage.setOnClickListener {
            startActivity<MyPage>()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        var picture = image(data)
        val res: Call<Result_image> = Utils.service.picture(picture)
        res.enqueue(object : Callback<Result_image> {
            override fun onFailure(call: Call<Result_image>, t: Throwable) {
            }

            override fun onResponse(call: Call<Result_image>, response: Response<Result_image>) {
                when (response.code()) {
                    200 -> {
                        Toast.makeText(applicationContext, "전송성공", Toast.LENGTH_LONG).show()
                        startActivity<dummy>()
                    }

                }
            }

        })


    }

//    //카메라 호출
//    private fun selectCamera() {
//        val state = Environment.getExternalStorageState()
//        // 외장 메모리 검사
//        if (Environment.MEDIA_MOUNTED.equals(state)) {
//            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//
//            if (takePictureIntent.resolveActivity(packageManager) != null) {
//                var photoFile: File? = null
//                try {
//                    photoFile = createImageFile()
//                } catch (ex: IOException) {
//                    Log.e("captureCamera Error", ex.toString())
//                }
//
//                if (photoFile != null) {
//                    // getUriForFile의 두 번째 인자는 Manifest provier의 authorites와 일치해야 함
//
//                    val providerUri = FileProvider.getUriForFile(this, packageName, photoFile!!)
//                    imageUri = providerUri
//
//                    // 인텐트에 전달할 때는 FileProvier의 Return값인 content://로만!!, providerURI의 값에 카메라 데이터를 넣어 보냄
//                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, providerUri)
//                    Log.i("SelectCamera", "providerUri: $providerUri")
//                    Log.i("SelectCamera", "imageUri: $imageUri")
//
//                    startActivityForResult(takePictureIntent, PICK_FROM_CAMERA)
//                }
//            }
//        } else {
//            Toast.makeText(this, "저장공간이 접근 불가능한 기기입니다", Toast.LENGTH_SHORT).show()
//            return
//        }
//    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("ToMeet")
        builder.setIcon(R.drawable.logo)
        builder.setMessage("정말로 종료하시겠습니까?")
        builder.setPositiveButton("확인") { _, _ -> finishAffinity() }
        builder.setNegativeButton("취소", null)
        val alertDialog = builder.create()
        alertDialog.show()
    }


}
