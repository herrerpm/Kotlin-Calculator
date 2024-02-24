package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var operator = ""
        var previous_value = ""
        val display = findViewById<TextView>(R.id.result)

        val digitListener = View.OnClickListener { view ->
            val buttonText = (view as Button).text.toString()
            display.text = display.text.toString() + buttonText


        }

        val operatorListener = View.OnClickListener { view ->
            val operation = (view as Button).text.toString()
            previous_value = display.text.toString()
            operator = operation
            display.text = ""
        }

        val digitButtons = arrayOf(
            findViewById<Button>(R.id.btn0),
            findViewById<Button>(R.id.btn1),
            findViewById<Button>(R.id.btn2),
            findViewById<Button>(R.id.btn3),
            findViewById<Button>(R.id.btn4),
            findViewById<Button>(R.id.btn5),
            findViewById<Button>(R.id.btn6),
            findViewById<Button>(R.id.btn7),
            findViewById<Button>(R.id.btn8),
            findViewById<Button>(R.id.btn9),
            findViewById<Button>(R.id.btnDecimal)
        )

        val operatorButtons = arrayOf(
            findViewById<Button>(R.id.btnMultiply),
            findViewById<Button>(R.id.btnDivide),
            findViewById<Button>(R.id.btnSubstract),
            findViewById<Button>(R.id.btnSum),
        )

        digitButtons.forEach { digitButton ->
            digitButton.setOnClickListener(digitListener)
        }

        operatorButtons.forEach { operatorButton ->
            operatorButton.setOnClickListener(operatorListener)
        }
        findViewById<Button>(R.id.btnEqual).setOnClickListener {
            var result = 0.0
            when (operator) {
                "+" -> result = previous_value.toDouble() + display.text.toString().toDouble()
                "-" -> result = previous_value.toDouble() - display.text.toString().toDouble()
                "/" -> result = previous_value.toDouble() / display.text.toString().toDouble()
                "*" -> result = previous_value.toDouble() * display.text.toString().toDouble()
            }
            display.text = result.toString()
        }
        findViewById<Button>(R.id.btnAc).setOnClickListener {
            display.text = ""
            previous_value = ""
            operator = ""
        }
    }
}