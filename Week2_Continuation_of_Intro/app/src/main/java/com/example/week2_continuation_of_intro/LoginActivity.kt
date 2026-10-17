package com.example.week2_continuation_of_intro

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity()
{
    lateinit var loginTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_layout)

        findViewById<TextView>(R.id.loginTextView_id).text = intent.getStringExtra("myKey")



    }

    public fun goBack (v: View)
    {
        finish()
    }

}


