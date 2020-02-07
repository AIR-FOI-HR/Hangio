package com.example.hangio.ui.logout

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.content.Intent
import com.google.firebase.auth.FirebaseAuth
import kotlin.system.exitProcess


class LogoutFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val builder = AlertDialog.Builder(this.activity)
        builder.setTitle("Odjava")
        builder.setMessage("Jeste li sigurni da se želite odjaviti?")
        builder.setPositiveButton("Da"){
                dialog, which ->
            FirebaseAuth.getInstance().signOut()

            val intent =
                activity!!.baseContext.packageManager.getLaunchIntentForPackage(activity!!.baseContext.packageName)
            intent!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            android.os.Process.killProcess(android.os.Process.myPid())
            exitProcess(0)
        }
        builder.setNegativeButton("Ne"){
                dialog, which ->
            this.activity!!.onBackPressed()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()


        return null
    }
}