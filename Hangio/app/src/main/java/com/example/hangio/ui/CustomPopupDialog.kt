package com.example.hangio.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.TextView
import com.example.hangio.R

// Usage:
// val dialog = CustomPopupDialog(this)
// dialog.show()

class CustomPopupDialog(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.popup_dialog)
        val msg = findViewById<TextView>(R.id.msg)
        msg.text = "Jeste li sigurni?"
    }
}