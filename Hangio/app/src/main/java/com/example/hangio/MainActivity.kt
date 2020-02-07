package com.example.hangio

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import androidx.core.app.NotificationCompat
import com.example.db.data.AppDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            //implementirati kreiranje dogadaja Activity
            val intent=Intent(this, CreateEvent::class.java)
            startActivity(intent)
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_my_profile, R.id.nav_attending_events,
                R.id.nav_created_events, R.id.nav_settings, R.id.nav_logout
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        AppDatabase.invoke(this)

        //Kreiranje notifikacije
        createNotificationChannel()

        with(getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager) {
            // notifikacijski id mora biti jedinstven za svaku notifikaciju
            notify(1234, createNotification("Hangio", "Dobrodošli u Hangio aplikaciju"))
        }

    }

    private fun createNotification(title: String, body: String): Notification {
        return NotificationCompat.Builder(this, "APP")
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(android.R.drawable.arrow_down_float).build()
    }

    private fun createNotificationChannel() {
        // Kreira se  Notifikacijski kanal, ali samo na API 26+ verzijama
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "APP_CHANNEL"
            val descriptionText = "desc"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("APP", name, importance).apply {
                description = descriptionText
            }
            // Registracija kanala sa sustavom
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }



}
