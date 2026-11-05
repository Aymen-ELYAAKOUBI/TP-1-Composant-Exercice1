package com.example.tp_1___composant

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val name = intent.extras?.getString(KEY_USER_NAME).orEmpty()
        tvWelcome.text = if (name.isBlank()) {
            "Bienvenue !"
        } else {
            "Bienvenue, $name !"
        }
    }

    private companion object {
        const val KEY_USER_NAME = "USER_NAME"
    }
}
