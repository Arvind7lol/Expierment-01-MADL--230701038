package com.example.experiment_01madl

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textViewSample: TextView
    private lateinit var buttonChangeFont: Button
    private lateinit var buttonChangeColor: Button
    private lateinit var buttonShowToast: Button

    private var currentFontIndex = 0
    private var currentColorIndex = 0

    private val colors = intArrayOf(
        Color.BLACK,
        Color.RED,
        Color.BLUE,
        Color.GREEN,
        Color.MAGENTA,
        Color.rgb(255, 140, 0) // Dark Orange
    )

    private val colorNames = arrayOf(
        "Black", "Red", "Blue", "Green", "Magenta", "Orange"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        textViewSample = findViewById(R.id.textViewSample)
        buttonChangeFont = findViewById(R.id.buttonChangeFont)
        buttonChangeColor = findViewById(R.id.buttonChangeColor)
        buttonShowToast = findViewById(R.id.buttonShowToast)

        // Set click listeners
        buttonChangeFont.setOnClickListener { changeFont() }
        buttonChangeColor.setOnClickListener { changeColor() }
        buttonShowToast.setOnClickListener { showToastMessage() }
    }

    private fun changeFont() {
        when (currentFontIndex % 4) {
            0 -> {
                textViewSample.setTypeface(Typeface.DEFAULT, Typeface.BOLD)
                Toast.makeText(this, "Font changed to Bold", Toast.LENGTH_SHORT).show()
            }
            1 -> {
                textViewSample.setTypeface(Typeface.DEFAULT, Typeface.ITALIC)
                Toast.makeText(this, "Font changed to Italic", Toast.LENGTH_SHORT).show()
            }
            2 -> {
                textViewSample.setTypeface(Typeface.DEFAULT, Typeface.BOLD_ITALIC)
                Toast.makeText(this, "Font changed to Bold Italic", Toast.LENGTH_SHORT).show()
            }
            3 -> {
                textViewSample.setTypeface(Typeface.MONOSPACE, Typeface.NORMAL)
                Toast.makeText(this, "Font changed to Monospace", Toast.LENGTH_SHORT).show()
            }
        }
        currentFontIndex++
    }

    private fun changeColor() {
        val colorIndex = currentColorIndex % colors.size
        textViewSample.setTextColor(colors[colorIndex])
        Toast.makeText(this, "Color changed to ${colorNames[colorIndex]}",
            Toast.LENGTH_SHORT).show()
        currentColorIndex++
    }

    private fun showToastMessage() {
        Toast.makeText(this, "Hello! This is a Toast Message",
            Toast.LENGTH_LONG).show()
    }
}
