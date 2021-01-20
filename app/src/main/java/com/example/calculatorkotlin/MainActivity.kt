package com.example.calculatorkotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var value1: Long = 0
    private var value2: Long = 0
    private var mAdd = false
    private var mSub = false
    private var mMul = false
    private var mDiv = false
    private var mPercent = false


    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num_0.setOnClickListener(this)
        num_1.setOnClickListener(this)
        num_2.setOnClickListener(this)
        num_3.setOnClickListener(this)
        num_4.setOnClickListener(this)
        num_5.setOnClickListener(this)
        num_6.setOnClickListener(this)
        num_7.setOnClickListener(this)
        num_8.setOnClickListener(this)
        num_9.setOnClickListener(this)
        num_percent.setOnClickListener(this)
        num_sub.setOnClickListener(this)
        num_mul.setOnClickListener(this)
        num_in_de.setOnClickListener(this)
        num_equal.setOnClickListener(this)
        num_dot.setOnClickListener(this)
        num_div.setOnClickListener(this)
        num_c.setOnClickListener(this)
        num_add.setOnClickListener(this)

    }


    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when (v) {
            num_0 -> text_input.editText!!.setText(text_input.editText!!.text.toString() + "0")
            num_1 -> {
                text_input.editText!!.setText(text_input.editText!!.text.toString() + "1")
            }
            num_2 -> {
                text_input.editText!!.setText(text_input.editText!!.text.toString() + "2")
            }
            num_3 -> {
                text_input.editText!!.setText(text_input.editText!!.text.toString() + "3")
            }
            num_4 -> {
                text_input.editText!!.setText(text_input.editText!!.text.toString() + "4")
            }
            num_5 -> {
                text_input.editText!!.setText(text_input.editText!!.text.toString() + "5")
            }
            num_6 -> {
                text_input.editText!!.setText(text_input.editText!!.text.toString() + "6")
            }
            num_7 -> {
                text_input.editText!!.setText(text_input.editText!!.text.toString() + "7")
            }
            num_8 -> {
                text_input.editText!!.setText(text_input.editText!!.text.toString() + "8")
            }
            num_9 -> {
                text_input.editText!!.setText(text_input.editText!!.text.toString() + "9")
            }
            num_dot -> text_input.editText!!.setText(text_input.editText!!.text.toString() + ".")
            num_div -> if (getOperation("/")) mDiv = true
            num_mul -> if (getOperation("*")) mMul = true
            num_sub -> if (getOperation("-")) mSub = true
            num_percent -> if (getOperation("%")) mPercent = true
            num_add -> if (getOperation("+")) mAdd = true
            num_c -> {
                text_input.editText!!.text.clear()
                text_view.text = ""
            }
            num_in_de -> {
                if (text_input.editText!!.text.isNotEmpty()) {
                    var num = text_input.editText!!.text.toString().toLong()
                    when {
                        num > 0 -> {
                            num *= (-1)
                        }
                        num < 0 -> {
                            num = -num * (-1)
                        }
                    }
                    text_input.editText!!.setText(num.toString())
                }
            }
            num_equal -> {
                when {
                    mDiv -> {
                        value2 = (text_input.editText!!.text.toString()).toLong()
                        text_input.editText!!.text.clear()
                        val x: Long = value1 / value2
                        text_view.text = text_view.text.toString() + value2 + "=" + x
                        text_input.editText!!.setText(x.toString())
                    }
                    mAdd -> {
                        value2 = (text_input.editText!!.text.toString()).toLong()
                        text_input.editText!!.text.clear()
                        val x: Long = value1 + value2
                        text_view.text = text_view.text.toString() + value2 + "=" + x
                        text_input.editText!!.setText(x.toString())
                    }
                    mSub -> {
                        value2 = (text_input.editText!!.text.toString()).toLong()
                        text_input.editText!!.text.clear()
                        val x: Long = value1 - value2
                        text_view.text = text_view.text.toString() + value2 + "=" + x
                        text_input.editText!!.setText(x.toString())
                    }
                    mMul -> {
                        value2 = (text_input.editText!!.text.toString()).toLong()
                        text_input.editText!!.text.clear()
                        val x: Long = value1 * value2
                        text_view.text = text_view.text.toString() + value2 + "=" + x
                        text_input.editText!!.setText(x.toString())
                    }
                    mPercent -> {
                        value2 = (text_input.editText!!.text.toString()).toLong()
                        text_input.editText!!.text.clear()
                        val x: Long = value1 % value2
                        text_view.text = text_view.text.toString() + value2 + "=" + x
                        text_input.editText!!.setText(x.toString())
                    }
                }
            }


        }
    }

    @SuppressLint("SetTextI18n")
    fun getOperation(typeOperation: String): Boolean {
        return if (text_input.editText!!.text.isEmpty()) {
            false
        } else {
            value1 = (text_input.editText!!.text.toString()).toLong()
            text_view.text = value1.toString() + typeOperation
            text_input.editText!!.setText(value1.toString() + typeOperation)
            text_input.editText!!.text.clear()
            true
        }
    }


}




