package com.hellohasan.android_firebase_notification.analytics

import android.os.Bundle
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class AppAnalyticsImpl : AppAnalytics {

    private val firebaseAnalytics = Firebase.analytics

    override fun logEvent(eventName: String, bundle: Bundle) {
        firebaseAnalytics.logEvent(eventName, bundle)
    }
}