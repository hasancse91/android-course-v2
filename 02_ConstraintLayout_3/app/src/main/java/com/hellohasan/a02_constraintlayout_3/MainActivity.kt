package com.hellohasan.a02_constraintlayout_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_input_part.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_submit.setOnClickListener {

            submitButtonAction()
        }
    }

    private fun submitButtonAction() {
        val userName = et_name.text.toString()

        tv_output.text = userName

        Toast.makeText(this, userName, Toast.LENGTH_SHORT).show()

        group_input.visibility = View.GONE

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("user_name", userName)
        startActivity(intent)
    }
}