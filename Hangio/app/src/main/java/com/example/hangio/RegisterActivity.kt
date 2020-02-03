package com.example.hangio

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_register.*

private val TAG = "CreateAccountActivity"
private var ime: String? = null
private var prezime: String? = null
private var email: String? = null
private var lozinka: String? = null
private var ponovljena_lozinka: String? = null
private var godina: String? = null
private var grad: String? = null
private var uvjeti: Boolean? = null


class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initialise()
    }

    private var ime_txt: EditText? = null
    private var prezime_txt: EditText? = null
    private var korime_txt: EditText? = null
    private var lozinka_txt: EditText? = null
    private var ponovi_lozinku_txt: EditText? = null
    private var godina_txt: EditText? = null
    private var grad_autoc: AutoCompleteTextView? = null
    private var uvjeti_chb: CheckBox? = null
    private var registracija_btn: Button? = null
    private var mProgressBar: ProgressDialog? = null
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null

    private fun initialise() {
        ime_txt = findViewById<View>(R.id.ime_txt) as EditText
        prezime_txt = findViewById<View>(R.id.prezime_txt) as EditText
        korime_txt = findViewById<View>(R.id.korime_txt) as EditText
        lozinka_txt = findViewById<View>(R.id.lozinka_txt) as EditText
        ponovi_lozinku_txt = findViewById<View>(R.id.ponovi_lozinku_txt) as EditText
        godina_txt = findViewById<View>(R.id.godina_txt) as EditText
        grad_autoc = findViewById<View>(R.id.grad_autoc) as AutoCompleteTextView
        uvjeti_chb = findViewById<View>(R.id.uvjeti_chb) as CheckBox
        registracija_btn = findViewById<View>(R.id.registracija_btn) as Button
        mProgressBar = ProgressDialog(this)
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("Users")
        mAuth = FirebaseAuth.getInstance()
        registracija_btn!!.setOnClickListener { napraviNoviRacun()}
    }

    private fun updateUserInfoAndUI() {
        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun verifyEmail() {
        val mUser = mAuth!!.currentUser;
        mUser!!.sendEmailVerification()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this@RegisterActivity,
                        "Verifikacijski mail je poslan na " + mUser.getEmail(),
                        Toast.LENGTH_SHORT).show()
                } else {
                    Log.e(TAG, "sendEmailVerification", task.exception)
                    Toast.makeText(this@RegisterActivity,
                        "Verifikacijski mail neuspješno poslan. Pokušajte ponovno.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun napraviNoviRacun(){
        ime = ime_txt?.text.toString()
        prezime = prezime_txt?.text.toString()
        email = korime_txt?.text.toString()
        lozinka = lozinka_txt?.text.toString()
        ponovljena_lozinka = ponovi_lozinku_txt?.text.toString()
        godina = godina_txt?.text.toString()
        grad = grad_autoc?.text.toString()
        uvjeti=false
        if(uvjeti_chb!!.isChecked){
            uvjeti=true
        }

        if (!TextUtils.isEmpty(ime) && !TextUtils.isEmpty(prezime)
            && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(lozinka) && !TextUtils.isEmpty(ponovljena_lozinka)
            && !TextUtils.isEmpty(grad) && uvjeti==true && lozinka.toString() == ponovljena_lozinka.toString()) {

            mProgressBar!!.setMessage("Registracija korisnika...")
            mProgressBar!!.show()

            mAuth!!
                .createUserWithEmailAndPassword(email!!, lozinka!!)
                .addOnCompleteListener(this) { task ->
                    mProgressBar!!.hide()
                    if (task.isSuccessful) {
                        Log.d(TAG, "createUserWithEmail:success")
                        val userId = mAuth!!.currentUser!!.uid
                        verifyEmail();
                        val currentUserDb = mDatabaseReference!!.child(userId)
                        currentUserDb.child("Ime").setValue(ime)
                        currentUserDb.child("Prezime").setValue(prezime)
                        currentUserDb.child("Godina").setValue(godina)
                        currentUserDb.child("Grad").setValue(grad)
                        updateUserInfoAndUI()
                    } else {
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(this@RegisterActivity, "Registracija neuspješna. Molimo pokušajte ponovno!",
                            Toast.LENGTH_SHORT).show()
                    }
                }

        } else {
            Toast.makeText(this, "Molimo ispunite sva polja!", Toast.LENGTH_SHORT).show()
        }
    }

}

