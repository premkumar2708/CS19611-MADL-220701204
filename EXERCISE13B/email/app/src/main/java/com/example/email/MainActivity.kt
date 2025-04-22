package com.example.email

import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.et_email)
        val subject = findViewById<EditText>(R.id.et_subject)
        val body = findViewById<EditText>(R.id.et_text)
        val send = findViewById<Button>(R.id.bt_email)

        send.setOnClickListener{
            val em = email.text.toString()
            val sub = subject.text.toString()
            val bo = body.text.toString()
            val intent = Intent(ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL,em)
            intent.putExtra(Intent.EXTRA_SUBJECT,sub)
            intent.putExtra(Intent.EXTRA_TEXT,bo)
            startActivity(Intent.createChooser(intent,"sendmail"))
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}