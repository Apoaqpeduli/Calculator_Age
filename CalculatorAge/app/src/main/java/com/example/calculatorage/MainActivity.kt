package com.example.calculatorage

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.time.LocalDateTime
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private var date: TextView? = null
    private var age: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDate : Button = findViewById(R.id.btnDate)
        date = findViewById(R.id.date)
        age = findViewById(R.id.age)

        btnDate.setOnClickListener{
            click()
        }
    }



    fun click(){
        val myCalneder= Calendar.getInstance()
        val year = myCalneder.get(Calendar.YEAR)
        val month = myCalneder.get(Calendar.MONTH)
        val day = myCalneder.get(Calendar.DAY_OF_MONTH)
        val currentYear = myCalneder.get(Calendar.YEAR)


        DatePickerDialog(this, DatePickerDialog.OnDateSetListener {view, year, month, dayOfMonth ->
            Toast.makeText(this, "$dayOfMonth / $month / $year", Toast.LENGTH_LONG).show()
            val selectedDate = "$dayOfMonth/$month/$year"
            val umur= currentYear - year
            date?.text=selectedDate
            age?.text=umur.toString()

        },
            year,
            month,
            day).show()

    }
}