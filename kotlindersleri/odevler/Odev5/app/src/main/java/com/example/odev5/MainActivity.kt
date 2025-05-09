package com.example.odev5

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.odev5.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var lastNumeric = false
    private var lastDot = false
    private var stateError = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {

        binding.btnZero.setOnClickListener { onDigit(it) }
        binding.btn1.setOnClickListener { onDigit(it) }
        binding.btn2.setOnClickListener { onDigit(it) }
        binding.btn3.setOnClickListener { onDigit(it) }
        binding.btn4.setOnClickListener { onDigit(it) }
        binding.btn5.setOnClickListener { onDigit(it) }
        binding.btn6.setOnClickListener { onDigit(it) }
        binding.btn7.setOnClickListener { onDigit(it) }
        binding.btn8.setOnClickListener { onDigit(it) }
        binding.btn9.setOnClickListener { onDigit(it) }


        binding.btnAdd.setOnClickListener { onOperator(it) }
        binding.btnSubtract.setOnClickListener { onOperator(it) }
        binding.btnMultiply.setOnClickListener { onOperator(it) }
        binding.btnDivide.setOnClickListener { onOperator(it) }


        binding.btnDecimal.setOnClickListener { onDecimalPoint(it) } // "." tuşu
        binding.btnClear.setOnClickListener { onClear() } // "C" tuşu
        binding.btnEquals.setOnClickListener { onEqual() } // "=" tuşu
        binding.btnBackspace.setOnClickListener { onBackspace() } // "DEL" tuşu
    }


    private fun onDigit(view: View) {
        if (stateError) {

            binding.tvDisplay.text = (view as Button).text
            stateError = false
        } else {

            if (binding.tvDisplay.text.toString() == "0" && (view as Button).text.toString() != "0" || binding.tvDisplay.text.isEmpty()) {
                binding.tvDisplay.text = (view as Button).text
            } else if (binding.tvDisplay.text.toString() != "0"){
                binding.tvDisplay.append((view as Button).text)
            }
        }
        lastNumeric = true
        lastDot = false
    }


    private fun onDecimalPoint(view: View) {

        if (lastNumeric && !lastDot) {
            binding.tvDisplay.append(".")
            lastNumeric = false
            lastDot = true
        } else if (!lastNumeric && !lastDot && binding.tvDisplay.text.isEmpty()){
            binding.tvDisplay.append("0.")
            lastNumeric = false
            lastDot = true
        }
    }
    private fun onOperator(view: View) {

        if (lastNumeric && !stateError) {
            binding.tvDisplay.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }
    }


    private fun onClear() {
        binding.tvDisplay.text = ""
        lastNumeric = false
        lastDot = false
        stateError = false
    }

    private fun onBackspace() {
        val currentText = binding.tvDisplay.text.toString()
        if (currentText.isNotEmpty()) {
            binding.tvDisplay.text = currentText.dropLast(1)

            val newText = binding.tvDisplay.text.toString()
            if (newText.isEmpty()) {
                lastNumeric = false
                lastDot = false
            } else {
                val lastChar = newText.last()
                lastNumeric = lastChar.isDigit()
                lastDot = lastChar == '.'
            }
        }
    }

    private fun onEqual() {
        if (lastNumeric && !stateError) {
            val txt = binding.tvDisplay.text.toString()
            try {
                val expression = ExpressionBuilder(txt).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    binding.tvDisplay.text = longResult.toString()
                } else {
                    binding.tvDisplay.text = result.toString()
                }
                stateError = false
                lastNumeric = true
                lastDot = false
            } catch (e: ArithmeticException) {
                binding.tvDisplay.text = "Hata: Sıfıra Bölme"
                stateError = true
                lastNumeric = false
            } catch (e: Exception) {
                binding.tvDisplay.text = "Geçersiz İfade"
                stateError = true
                lastNumeric = false
            }
        }
    }
}