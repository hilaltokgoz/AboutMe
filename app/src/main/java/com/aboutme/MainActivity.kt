package com.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.MyName
import com.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val myName:MyName= MyName("Aleks Haecky")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //dataBinding
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        setContentView(binding.root) //xml ile kt yi bağla. R,kaynağa referanstır.
        binding.apply {
            doneButton.setOnClickListener { addNickname(it) }
            nicknameText.setOnClickListener { updateNickname(it) }
        }
        binding.myNameObject=myName //oluşturulan nesne objeye verildi
        //findViewById ile yapılışı
      /*  findViewById<Button>(R.id.doneButton).setOnClickListener {
            addNickname(it) //Butonu verir
        }
        findViewById<TextView>(R.id.nicknameText).setOnClickListener {
            updateNickname(it)
        }*/
    }
    //Butona basıldığında çalışacak fonksiyon
    private fun addNickname(view: View) {
        //findViewById
        /*   val editText = findViewById<EditText>(R.id.nickNameEdit)
           val nicknameText = findViewById<TextView>(R.id.nicknameText)
           nicknameText.text = editText.text //editText'e girilen text'i yerleştir.
           editText.visibility = View.GONE
           view.visibility = View.GONE
           nicknameText.visibility = View.VISIBLE*/
        //Binding
        binding.apply {
            myName.nickname=binding.nickNameEdit.text.toString()
            invalidateAll() //Nesneyi değiştirince UI yı update et
            doneButton.visibility=View.GONE
            nickNameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            view.windowToken,
            0
        ) //butondan sonra klavye gizlenir.
    }

    private fun updateNickname(view: View) {
        //findViewById
        /* val editText = findViewById<EditText>(R.id.nickNameEdit)
         val doneButton = findViewById<Button>(R.id.doneButton)
         editText.visibility = View.VISIBLE
         doneButton.visibility = View.VISIBLE
         view.visibility = View.GONE

         editText.requestFocus() */  //textView e basılınca editText görünür olsun ve klavye açılsın.
        binding.apply {
            nickNameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE

            nickNameEdit.requestFocus()
        }
        view.visibility = View.GONE


        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(binding.nickNameEdit, 0)

    }
}