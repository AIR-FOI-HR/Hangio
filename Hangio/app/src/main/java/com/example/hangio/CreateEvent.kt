package com.example.hangio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_kreiraj_dogadaj.*

class CreateEvent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kreiraj_dogadaj)

        objavi_btn.setOnClickListener{
            Toast.makeText(this, "Uspješno odabran gumb objavi", Toast.LENGTH_SHORT).show()
        }

        odustni_btn.setOnClickListener {
            finish()
        }
    }
}