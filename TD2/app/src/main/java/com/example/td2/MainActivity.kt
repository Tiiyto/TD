package com.example.td2

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.meteo.*
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meteo_upgrade)
        val textTime = findViewById<TextView>(R.id.editText)
        val textDay = findViewById<TextView>(R.id.editText2)
        val calendar = Calendar.getInstance()
        textDay.setOnClickListener{
            val setDay = DatePickerDialog.OnDateSetListener{ datePicker1 , year, month , dayofMonth ->
                calendar.set(Calendar.YEAR,year)
                calendar.set(Calendar.MONTH,month)
                calendar.set(Calendar.DAY_OF_MONTH, dayofMonth)
                textDay.text = SimpleDateFormat("dd-MM-yyyy").format(calendar.time)
            }
            DatePickerDialog(this,setDay, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH) ).show()
        }
        textTime.setOnClickListener {
            val setTimer = TimePickerDialog.OnTimeSetListener{ timePicker, hour, minute ->
                calendar.set(Calendar.HOUR_OF_DAY, hour)
                calendar.set(Calendar.MINUTE, minute)
                textTime.text = SimpleDateFormat("HH:mm").format(calendar.time)
            }
            TimePickerDialog(this,setTimer,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),true).show()
        }
    }
}