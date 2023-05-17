package com.example.resultmainactivity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        go2()
    }

    fun go2(){

        var intent = Intent(this, ResultMainActivity::class.java)
        startActivity(intent)
    }

    fun btn_go2(view: View){
        var intent = Intent(this, Result1Activity::class.java)

    }
}