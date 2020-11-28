package com.hellohasan.android_firebase_notification.analytics

import android.os.Bundle

interface AppAnalytics {
    fun logEvent(eventName: String, bundle: Bundle)
}