package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_0.setOnClickListener { setTextFields("0") }
        button_1.setOnClickListener { setTextFields("1") }
        button_2.setOnClickListener { setTextFields("2") }
        button_3.setOnClickListener { setTextFields("3") }
        button_4.setOnClickListener { setTextFields("4") }
        button_5.setOnClickListener { setTextFields("5") }
        button_6.setOnClickListener { setTextFields("6") }
        button_7.setOnClickListener { setTextFields("7") }
        button_8.setOnClickListener { setTextFields("8") }
        button_9.setOnClickListener { setTextFields("9") }

        button_minus.setOnClickListener { setTextFields("-") }
        button_plus.setOnClickListener { setTextFields("+") }
        button_multiply.setOnClickListener { setTextFields("*") }
        button_divide.setOnClickListener { setTextFields("/") }
        button_open_bracket.setOnClickListener { setTextFields("(") }
        button_close_bracket.setOnClickListener { setTextFields(")") }

        button_c.setOnClickListener {
            result_text.text=""
            math_operation.text=""
        }

        button_back.setOnClickListener {
            val str = math_operation.text.toString()
            if (str.isNotEmpty())
                math_operation.text=str.substring(0, str.length-1)
            result_text.text=""
        }

        button_equals.setOnClickListener {
            try {
                val ex=ExpressionBuilder(math_operation.text.toString()).build()
                val result=ex.evaluate()
                val longRes=result.toLong()
                if (result==longRes.toDouble())
                    result_text.text=longRes.toString()
                else
                    result_text.text=result.toString()
            } catch (e:Exception) {
                Log.d("Error","Message: ${e.message}")
            }
        }

    }
    fun setTextFields(str:String) {
        if(result_text.text!=""){
            math_operation.text=result_text.text
            result_text.text=""
        }
        math_operation.append(str)
    }

}