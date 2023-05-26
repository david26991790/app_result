package com.example.resultmainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

const val 請求邊號_r1 = 1
const val 請求邊號_r2 = 2

class ResultMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_main)
    }

    fun btn1(view: View) {
        var intent = Intent(this, Result1Activity::class.java)
        startActivityForResult(intent, 請求邊號_r1)
    }
    fun click_clear2(view: View){
        val tv_name = findViewById<TextView>(R.id.et_name)
        val tv_eng = findViewById<TextView>(R.id.et_eng)
        val tv_math = findViewById<TextView>(R.id.et_math)
        tv_name.setText("")
        tv_eng.setText("")
        tv_math.setText("")
    }

    fun btn2(view: View) {
        var intent = Intent(this, Result2Activity::class.java)
        startActivityForResult(intent, 請求邊號_r2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            請求邊號_r1 -> {
                if (resultCode == RESULT_OK) {
                    var r1 = data?.getSerializableExtra(KEY_r1) as Result1
                    Log.d("@@@ 收結果", r1.toString())

                    var iv: ImageView = findViewById(R.id.iv)
                    iv.setImageResource(r1.圖片id)
                }
            }

            請求邊號_r2 -> {
                if (resultCode == RESULT_OK) {
                    var r2 = data?.getSerializableExtra(KEY_r2) as Result2
                    Log.d("@@@ 收結果", r2.toString())

                    var tv_name: TextView = findViewById(R.id.tv_name)
                    var tv_eng: TextView = findViewById(R.id.tv_eng)
                    var tv_math: TextView = findViewById(R.id.tv_math)

                    tv_name.text = r2.name
                    tv_eng.text = r2.eng.toString()
                    tv_math.text = r2.math.toString()

                }


            }
        }
    }

}