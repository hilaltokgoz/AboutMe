package com.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
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
        findViewById<TextView>(R.id.nicknameText).setOnClickListener {
            updateNickname(it)
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

        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            view.windowToken,
            0
        ) //butondan sonra klavye gizlenir.
    }

    private fun updateNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickNameEdit)
        val doneButton = findViewById<Button>(R.id.doneButton)

        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus()   //textView e basılınca editText görünür olsun ve klavye açılsın.

        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(editText, 0)

    }
}