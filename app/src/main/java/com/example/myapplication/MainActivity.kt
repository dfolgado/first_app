package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout

const val TEXT_VIEW_MESSAGE = "com.example.myapplication.TEXT_VIEW_MESSAGE"
const val BACKGROUND_COLOR_MESSAGE = "com.example.myapplication.BACKGROUND_COLOR_MESSAGE"

class MainActivity : ComponentActivity() {
    private lateinit var myTextView : TextView
    private var color : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton = findViewById<Button>(R.id.myButton1)
        myTextView = findViewById(R.id.myTextView)

        myButton.setOnClickListener {
            myTextView.text = getString(R.string.btn_pressed)
            myTextView.textSize = 26.0f
        }
    }

    fun myButton2Clicked(view: View) {
        if (view.id == R.id.myButton2) {
            val myConstraintLayout = findViewById<ConstraintLayout>(R.id.myConstraintLayout)

            color = (Math.random() * 16777215).toInt() or (0xFF shl 24)
            myConstraintLayout.setBackgroundColor(color)
        }
    }

    fun myButton3Clicked(view: View) {
        if (view.id == R.id.myButton3) {

            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(TEXT_VIEW_MESSAGE, myTextView.text)
                putExtra(BACKGROUND_COLOR_MESSAGE, color)
            }
            startActivity(intent)
        }
    }
}