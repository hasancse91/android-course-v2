package com.hellohasan.recyclerview.core

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity: AppCompatActivity() {

    abstract fun setLayoutId(): Int
    abstract fun setToolbar(): Toolbar
    abstract val isHomeUpButtonEnable: Boolean


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        setActionBar(setToolbar(), isHomeUpButtonEnable)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setActionBar(toolbar: Toolbar, isHomeUpButtonEnable: Boolean) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(isHomeUpButtonEnable)
        supportActionBar?.setHomeButtonEnabled(isHomeUpButtonEnable)
    }

    fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}