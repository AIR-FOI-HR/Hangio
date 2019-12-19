package com.example.hangio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        resetiraj_btn.setOnClickListener{
            Toast.makeText(this, "Uspješno ste resetirali lozinku. Provjerite e-mail!", Toast.LENGTH_SHORT).show()
        }
    }
}
