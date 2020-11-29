package com.hellohasan.android_firebase_notification.ui

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.hellohasan.android_firebase_notification.R
import com.hellohasan.android_firebase_notification.analytics.AppAnalyticsImpl
import com.hellohasan.android_firebase_notification.core.BaseActivity
import com.hellohasan.android_firebase_notification.notification.TOPIC_GLOBAL
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity() {

    private val appAnalytics = AppAnalyticsImpl()

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun setToolbar(): Toolbar {
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btn_topic_subscription.setOnClickListener {
            subscribeGlobalTopic()
            logButtonClickEvent()
        }
    }

    private fun subscribeGlobalTopic() {
        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC_GLOBAL)
            .addOnCompleteListener { task ->

                if (task.isSuccessful)
                    showToast("Global topic subscription successful")
                else
                    showToast("Error: ${task.exception?.localizedMessage}")
            }
    }

    private fun logButtonClickEvent() {
        val bundle = Bundle()
        bundle.putString("activity", "MainActivity")
        bundle.putLong("timestamp", System.currentTimeMillis())
        appAnalytics.logEvent("button_clicked", bundle)
    }
}