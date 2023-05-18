package com.example.resultmainactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.view.View
import android.util.Log
import android.widget.EditText
import java.io.FileOutputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class StoreActivity : AppCompatActivity() {

    private val fliename = "st.ser"
    private var st: Studnet? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)
    }

    private fun buildstudent() {
        st = Studnet("Tom", 100, 99)
        Log.d("@@@", st.toString())
    }

    private fun save() {
        try {
            val fos = openFileOutput(fliename, Context.MODE_PRIVATE)
            val oos = ObjectOutputStream(fos)
            oos.writeObject(st)
            oos.close()
            fos.close()
            Log.d("@@@", "存檔成功")
            Toast.makeText(this, "存檔成功", Toast.LENGTH_SHORT).show()
        } catch (e: FileNotFoundException) {
            Log.d("@@@ 檔案找不到", e.toString())

        } catch (e: IOException) {
            Log.d("@@@ 輸出發生問題", e.toString())
        }

    }

    fun click_save(view: View) {
        buildstudent()
        save()
    }

    private fun load() {
        try {
            val fis = openFileInput(fliename)
            val ois = ObjectInputStream(fis)
            st = ois.readObject() as Studnet?
            ois.close()
            fis.close()
            Log.d("@@@", "讀檔成功" +st.toString())
            Toast.makeText(this,"讀檔成功", Toast.LENGTH_SHORT).show()
        } catch (e: FileNotFoundException){
            Log.d("@@@ 檔案找不到", e.toString())
        }catch (e: IOException){
            Log.d("@@@ 輸出發生問題", e.toString())
        }
    }
    private fun show(){
        val tv_name = findViewById<EditText>(R.id.et_name)
        val tv_eng = findViewById<EditText>(R.id.et_eng)
        val tv_math = findViewById<EditText>(R.id.et_math)
        tv_name.setText(st?.name)
        tv_eng.setText(""+ st?.eng)
        tv_math.setText(""+ st?.math)
    }
    fun click_load(view: View){
        load()
        show()
    }
}



