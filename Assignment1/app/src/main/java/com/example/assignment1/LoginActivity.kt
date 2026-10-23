package com.example.assignment1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_layout)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        UserRepository.load(this)

        val usernameInput = findViewById<TextInputEditText>(R.id.username_id)
        val passwordInput = findViewById<TextInputEditText>(R.id.password_id)

        findViewById<Button>(R.id.login_button_id).setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString()

            val user = UserRepository.login(username, password)
            if (user != null) {
                SessionManager.currentUser = user
                finish()
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<ImageButton>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}