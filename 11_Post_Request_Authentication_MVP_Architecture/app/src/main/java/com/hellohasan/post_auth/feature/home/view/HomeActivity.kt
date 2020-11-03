package com.hellohasan.post_auth.feature.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.hellohasan.post_auth.R
import com.hellohasan.post_auth.core.BaseActivity

class HomeActivity : BaseActivity() {

    override fun setLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun setToolbar(): Toolbar {
        TODO("Not yet implemented")
    }

    override val isHomeUpButtonEnable: Boolean
        get() = TODO("Not yet implemented")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}