package com.example.week2_continuation_of_intro

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.jvm.java

// activity - Scene - Level 
class HomeActivity : AppCompatActivity()
{
    lateinit var  myTextView: TextView
    lateinit var myButton: Button
    lateinit var plainText: EditText

    
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home_layout)

        myTextView = findViewById<TextView>(R.id.myTextView_id)
        myButton = findViewById<Button>(R.id.myButton_id)
        plainText = findViewById<EditText>(R.id.plainText_id)



        plainText.setOnKeyListener { _, keycode, _ ->

            if (keycode == KEYCODE_ENTER)
            {
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("myKey", plainText.text.toString())


                startActivity(intent)
            }

            false
        }

    }
    public fun loginFun (v: View)
    {
         val valueToSend: String = plainText.text.toString()


        val intent = Intent(this, LoginActivity::class.java)

        intent.putExtra("myKey", valueToSend)


        startActivity(intent)
    }

    fun myInpFun (i: Int, j: Int): Int
    {
        return i * j
    }


}