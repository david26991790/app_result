package com.example.resultmainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.View

const val 請求邊號_r1 = 1
const val 請求邊號_r2 = 2

class ResultMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_main)
    }
    fun btn1(view: View) {
        var intent = Intent(this, ResultMainActivity::class.java)
        startActivityForResult(intent, 請求邊號_r1)
    }
    fun btn2(view: View) {
        var intent = Intent(this, ResultMainActivity::class.java)
        startActivityForResult(intent, 請求邊號_r2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            請求邊號_r1 ->{
                if (resultCode == RESULT_OK){
                    var r1 =Intent?.getSerializableExtra(KEY_r1) as Result1
                    Log.d("@@@ 收結果", r1.toString())
                }
            }
            請求邊號_r2 ->{

            }
        }
    }
}