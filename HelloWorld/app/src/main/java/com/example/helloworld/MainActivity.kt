package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

const val TAG: String = "hello"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        } else {1}
    }
}