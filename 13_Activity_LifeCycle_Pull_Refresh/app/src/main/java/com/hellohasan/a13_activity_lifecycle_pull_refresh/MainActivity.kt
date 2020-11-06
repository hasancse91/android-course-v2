package com.hellohasan.a13_activity_lifecycle_pull_refresh

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Logger.addLogAdapter(AndroidLogAdapter())
        showMessage("onCreate")

        btn_second_activity.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        btn_finish.setOnClickListener {
            finish()
        }

        swipe_refresh_layout.setOnRefreshListener {
            btn_stop_refreshing.visibility = View.VISIBLE
            showMessage("Refreshing started")
        }

        btn_stop_refreshing.setOnClickListener {
            swipe_refresh_layout.isRefreshing = false
            btn_stop_refreshing.visibility = View.GONE
        }
    }

    override fun onStart() {
        super.onStart()
        showMessage("onStart")
    }

    override fun onResume() {
        super.onResume()
        showMessage("onResume")
    }

    override fun onPause() {
        super.onPause()
        showMessage("onPause")
    }

    override fun onRestart() {
        super.onRestart()
        showMessage("onRestart")
    }

    override fun onStop() {
        super.onStop()
        showMessage("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        showMessage("onDestroy")
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, "MainActivity: $message", Toast.LENGTH_SHORT).show()
        Logger.d("MainActivity: $message")
    }

}