package com.example.assignment1

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity()
{
    lateinit var iconImage_id: ImageButton

    public fun updateIconImage()
    {
        iconImage_id.setImageResource(
            if (SessionManager.isLogged) R.drawable.withprofile else R.drawable.noprofile)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home_layout)

        iconImage_id = findViewById(R.id.iconImage_id)

        updateIconImage()

        iconImage_id.setOnClickListener {
            if (SessionManager.isLogged) {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            } else {
                // not logged in: open the login screen
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        updateIconImage()
    }
}