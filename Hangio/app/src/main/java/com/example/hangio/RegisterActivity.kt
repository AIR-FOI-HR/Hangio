package com.example.hangio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registracija_btn.setOnClickListener{
            Toast.makeText(this, "Uspješno ste se registrirali", Toast.LENGTH_SHORT).show()
        }
    }
}
