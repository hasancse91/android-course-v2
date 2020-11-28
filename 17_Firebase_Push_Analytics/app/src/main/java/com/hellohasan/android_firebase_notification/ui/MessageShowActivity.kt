package com.hellohasan.android_firebase_notification.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.app.NavUtils
import com.bumptech.glide.Glide
import com.hellohasan.android_firebase_notification.R
import com.hellohasan.android_firebase_notification.core.BaseActivity
import kotlinx.android.synthetic.main.activity_message_show.*
import kotlinx.android.synthetic.main.toolbar.*

class MessageShowActivity : BaseActivity() {

    override fun setLayoutId(): Int {
        return R.layout.activity_message_show
    }

    override fun setToolbar(): Toolbar {
        toolbar.title = getString(R.string.title_notification_details_activity)
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showNotificationData()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val intent = NavUtils.getParentActivityIntent(this)
        startActivity(intent)
    }

    private fun showNotificationData() {
        //receive data from MyFirebaseMessagingService class
        val title = intent.getStringExtra("title")
        val timeStampString = intent.getStringExtra("timestamp")
        val articleString = intent.getStringExtra("article_data")
        val imageUrl = intent.getStringExtra("image")

        Glide.with(featureGraphics)
            .load(imageUrl)
            .error(R.drawable.image_placeholder)
            .into(featureGraphics)

        header.text = title
        timeStamp.text = timeStampString
        article.text = articleString
    }
}