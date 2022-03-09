package com.cookandroid.dronecamapp2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var urlText : EditText
    lateinit var goBtn : Button
    lateinit var weburl : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        urlText = findViewById(R.id.urlText)
        goBtn = findViewById(R.id.goBtn)

        goBtn.setOnClickListener {
            goToURL()
        }
    }
    private fun goToURL() {
        weburl = urlText.text.toString()

        if(weburl.startsWith("http://")){
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("$weburl"))
            startActivity(intent)
        }
        else{
            weburl = "http://${weburl}"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("${weburl}"))
            startActivity(intent)
        }
    }
}