package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout

internal class SecondActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(TEXT_VIEW_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        findViewById<TextView>(R.id.myTextView2).apply {
            text = message
        }

        val backgroundColor = intent.getIntExtra(BACKGROUND_COLOR_MESSAGE, 0)
        val myConstraintLayout = findViewById<ConstraintLayout>(R.id.myConstraintLayout)
        myConstraintLayout.setBackgroundColor(backgroundColor)
    }
}