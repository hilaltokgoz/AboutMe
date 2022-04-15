package com.aboutme

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //xml ile kt yi bağla. R,kaynağa referanstır.

        findViewById<Button>(R.id.doneButton).setOnClickListener {
            addNickname(it) //Butonu verir
        }
    }


    //Butona basıldığında çalışacak fonksiyon
    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickNameEdit)
        val nicknameText = findViewById<TextView>(R.id.nicknameText)

        nicknameText.text = editText.text //editText'e girilen text'i yerleştir.
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameText.visibility = View.VISIBLE
    }
}