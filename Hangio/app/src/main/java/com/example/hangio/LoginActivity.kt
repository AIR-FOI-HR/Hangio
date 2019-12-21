package com.example.hangio

import android.app.ProgressDialog
import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import com.google.firebase.auth.FirebaseAuth

private val TAG = "LoginActivity"
//global variables
private var email: String? = null
private var password: String? = null
//UI elements


//Firebase references
private var mAuth: FirebaseAuth? = null

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initialise()

        }
    private var zab_lozinka_tv: TextView? = null
    private var korime_txt: EditText? = null
    private var lozinka_txt: EditText? = null
    private var prijava_btn: Button? = null
    private var registracija_btn: Button? = null
    private var mProgressBar: ProgressDialog? = null

    private fun initialise() {
        zab_lozinka_tv = findViewById<View>(R.id.zab_lozinka_tv) as TextView
        korime_txt = findViewById<View>(R.id.korime_txt) as EditText
        lozinka_txt = findViewById<View>(R.id.lozinka_txt) as EditText
        prijava_btn = findViewById<View>(R.id.prijava_btn) as Button
        registracija_btn = findViewById<View>(R.id.registracija_btn) as Button
        mProgressBar = ProgressDialog(this)
        mAuth = FirebaseAuth.getInstance()
        zab_lozinka_tv!!
            .setOnClickListener { startActivity(Intent(this@LoginActivity,
                ForgotPasswordActivity::class.java)) }
        registracija_btn!!
            .setOnClickListener { startActivity(Intent(this@LoginActivity,
                RegisterActivity::class.java)) }
        prijava_btn!!.setOnClickListener { loginUser() }
    }

    private fun loginUser() {
        email = korime_txt?.text.toString()
        password = lozinka_txt?.text.toString()

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            mProgressBar!!.setMessage("Prijava korisnika...")
            mProgressBar!!.show()
            Log.d(TAG, "Prijava korisnika.")
            mAuth!!.signInWithEmailAndPassword(email!!, password!!)
                .addOnCompleteListener(this) { task ->
                    mProgressBar!!.hide()
                    if (task.isSuccessful) {
                        // Sign in success, update UI with signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        updateUI()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.e(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(this@LoginActivity, "Korisničko ime ili lozinka su neispravni..",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(this, "Molimo ispunite e-mail i lozinku.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI() {
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}

