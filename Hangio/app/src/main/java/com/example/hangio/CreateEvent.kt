package com.example.hangio

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.hangio.Spinner.EventCategory
import android.widget.EditText
import com.example.ws.Event
import com.example.ws.ResponseHandler
import com.example.ws.WebServiceProvider
import kotlinx.android.synthetic.main.activity_kreiraj_dogadaj.*
import java.text.SimpleDateFormat
import java.util.*

class CreateEvent : AppCompatActivity() {

    var format = SimpleDateFormat("YYYY-MM-dd")
    var timeFormat = SimpleDateFormat("hh:mm:ss")

    private val webServiceProvider = WebServiceProvider()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kreiraj_dogadaj)

        objavi_btn.setOnClickListener {
            Toast.makeText(this, "Uspješno odabran gumb objavi", Toast.LENGTH_SHORT).show()

            var inputNaziv = findViewById(R.id.input_naziv) as EditText
            //    var inputGrad = findViewById(R.id.input_grad) as EditText
            var inputAdresa = findViewById(R.id.input_adresa) as EditText
            var inputDatum = findViewById(R.id.input_datum) as EditText
            //   var inputVrijeme = findViewById(R.id.input_vrijeme) as EditText
            var inputOpis = findViewById(R.id.input_opis) as EditText
            var inputCategory: Spinner = findViewById(R.id.spinner_kategorija) as Spinner

            Toast.makeText(this, inputNaziv.text, Toast.LENGTH_SHORT).show()
            val event = Event(
                0,
                inputNaziv.text.toString(),
                inputDatum.text.toString(),
                inputAdresa.text.toString(),
                inputOpis.text.toString(),
                1,
                1,
                1,
                1,
                inputCategory.selectedItemPosition + 1
            )



            webServiceProvider.createEvent(event)


        }

        odustni_btn.setOnClickListener {
            finish()
        }

        val eventCategories = arrayOf<String>(
            "Sport", "Movies", "Coffee/Drink", "Concert", "Night out", "Walk",
            "Casual hanging out", "House party", "Theatre play", "Museum visit", "Other"
        )

        val spinner = findViewById(R.id.spinner_kategorija) as Spinner

        if (spinner != null) {
            val arrayAdapter =
                ArrayAdapter(this, android.R.layout.simple_spinner_item, eventCategories)
            spinner.adapter = arrayAdapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(
                        this@CreateEvent,
                        getString(R.string.selected_item) + " " + eventCategories[position],
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Code to perform some action when nothing is selected
                }
            }
        }

        //Kalendar

        input_datum.setOnClickListener {
            val now = Calendar.getInstance()
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(Calendar.YEAR,year)
                selectedDate.set(Calendar.MONTH,month)
                selectedDate.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                val date = format.format(selectedDate.time)
                input_datum.setText(date)
            },
                now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH))
            datePicker.show()
        }
        vrijeme_btn.setOnClickListener {
            val now = Calendar.getInstance()
            val timePicker = TimePickerDialog(
                this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    val selectedTime = Calendar.getInstance()
                    selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
                    selectedTime.set(Calendar.MINUTE, minute)
                    val time= timeFormat.format(selectedTime.time)
                    val sb = StringBuilder()
                    sb.append(input_datum.text).append(" ").append(time)
                    input_datum.setText(sb.toString())
                },
                now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), false
            )
            timePicker.show()
        }
    }
}