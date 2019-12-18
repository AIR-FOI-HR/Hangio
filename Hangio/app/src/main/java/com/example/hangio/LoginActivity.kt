package com.example.hangio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        prijava_btn.setOnClickListener{
            if(korime_txt.text.toString().equals("admin") && lozinka_txt.text.toString().equals("admin")){
                var log ="Uspješno ste se prijavili!"
                Toast.makeText(this, log, Toast.LENGTH_SHORT).show()

                val intent=Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else{
                var log = "Neuspješna prijava!"
                Toast.makeText(this, log, Toast.LENGTH_SHORT).show()
            }

        }
    }
}
