package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button_lance_d)
        val valueOfD: TextView = findViewById(R.id.valueofd)
        val valueofD2: TextView = findViewById(R.id.valueofd2)
        val valueofN: EditText = findViewById(R.id.numOfN)
        rollButton.setOnClickListener{
            val max = valueofN.text.toString().toInt()
            if(max > 0)
            {
                valueOfD.text = rollD(max).toString() /*The value of the TextView is the integer returned by rollD converted in a string*/
                valueofD2.text = rollD(max).toString() /*The value of the TextView is the integer returned by rollD converted in a string*/
            } else Toast.makeText(this,"Ce nest pas un nombre positif",Toast.LENGTH_SHORT).show()
        }
    }
    private fun rollD(n: Int): Int /*Return an integer between 1 and 6*/
    {
        return (1..n).random()
    }
}