package com.example.send_sms

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val phone = findViewById<EditText>(R.id.et_phone)
        val message = findViewById<EditText>(R.id.et_msg)
        val sendmsg = findViewById<Button>(R.id.bt_send)
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS),1245)
        }

        sendmsg.setOnClickListener {
            val ph = phone.text.toString()
            val msg = message.text.toString()
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(ph,null,msg,null,null)
            Toast.makeText(this,"SMS SENT", Toast.LENGTH_LONG).show()

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}