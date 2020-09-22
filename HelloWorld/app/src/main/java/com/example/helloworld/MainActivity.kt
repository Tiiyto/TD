package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Switch
import android.widget.Toast

const val TAG: String = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnClick = findViewById<Button>(R.id.button)
        btnClick?.setOnClickListener(){
            Toast.makeText(this@MainActivity, R.string.message,Toast.LENGTH_SHORT).show()
        }
        val switch = findViewById<Switch>(R.id.switch2)
        switch?.setOnCheckedChangeListener({ _ , isChecked ->
            val message = if (isChecked) "Switch1:ON" else "Switch2:OFF"
            Toast.makeText(this@MainActivity,message,Toast.LENGTH_SHORT).show()
        })
        val v = 54
        val n = v/9 - 2
        Log.i(TAG, "n = $n")
        val f = factorielle(n)
        Log.i(TAG, "$n! = $f")
    }
    private fun factorielle(n: Int): Int {
        return if (n>1) {
            val fnm1 = factorielle(n-1)
            n * fnm1
        } else 1
    }
}