package com.example.tp_1___composant

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var tvWelcome: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etName)
        tvWelcome = findViewById(R.id.tvWelcome)
        val btnSend = findViewById<Button>(R.id.btnSend)

        savedInstanceState?.let { state ->
            etName.setText(state.getString(KEY_USER_NAME, ""))
            tvWelcome.text = state.getString(KEY_WELCOME, "")
        }

        btnSend.setOnClickListener {
            val name = etName.text.toString().trim()
            tvWelcome.text = if (name.isEmpty()) {
                "Veuillez entrer votre nom."
            } else {
                "Bienvenue, $name !"
            }

            val bundle = Bundle().apply {
                putString(KEY_USER_NAME, name)
            }
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtras(bundle)
            }
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(KEY_USER_NAME, etName.text.toString())
        outState.putString(KEY_WELCOME, tvWelcome.text.toString())
        super.onSaveInstanceState(outState)
    }

    private companion object {
        const val KEY_USER_NAME = "USER_NAME"
        const val KEY_WELCOME = "WELCOME_MESSAGE"
    }
}
