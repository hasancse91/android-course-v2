package com.hellohasan.android_firebase_notification.notification

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.hellohasan.android_firebase_notification.ui.MessageShowActivity
import com.orhanobut.logger.Logger
import org.json.JSONException
import org.json.JSONObject

class MyFirebaseMessagingService: FirebaseMessagingService() {

    private var notificationUtils: NotificationUtils? = null

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)

        Logger.d("Firebase token: $p0")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        if (remoteMessage.data.isNotEmpty()) {
            Logger.d(remoteMessage.data.toString())

            try {
                val json = JSONObject(remoteMessage.data.toString())
                handleDataMessage(json)
            } catch (e: Exception) {
                Logger.e("Exception: ${e.message}")
            }

        }
    }

    private fun handleDataMessage(json: JSONObject) {

        try {
            val data = json.getJSONObject("data")

            val title = data.getString("title")
            val message = data.getString("message")
            val imageUrl = data.getString("image")
            val timestamp = data.getString("timestamp")
            val payload = data.getJSONObject("payload")

            val articleData = payload.getString("article_data")

            //Send notification data to MessageShowActivity class for showing
            val resultIntent = Intent(applicationContext, MessageShowActivity::class.java)
            resultIntent.putExtra("title", title)
            resultIntent.putExtra("timestamp", timestamp)
            resultIntent.putExtra("article_data", articleData)
            resultIntent.putExtra("image", imageUrl)

            // check for image attachment
            if (TextUtils.isEmpty(imageUrl)) {
                showNotificationMessage(applicationContext, title, message, timestamp, resultIntent)
            } else {
                // image is present, show notification with image
                showNotificationMessageWithBigImage(
                    applicationContext,
                    title,
                    message,
                    timestamp,
                    resultIntent,
                    imageUrl
                )
            }

        } catch (e: JSONException) {
            Logger.e(e.localizedMessage)
        } catch (e: Exception) {
            Logger.e(e.localizedMessage)
        }

    }

    /**
     * Showing notification with text only
     */
    private fun showNotificationMessage(
        context: Context,
        title: String,
        message: String,
        timeStamp: String,
        intent: Intent
    ) {
        notificationUtils = NotificationUtils(context)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        notificationUtils?.showNotificationMessage(title, message, timeStamp, intent)
    }

    /**
     * Showing notification with text and image
     */
    private fun showNotificationMessageWithBigImage(
        context: Context,
        title: String,
        message: String,
        timeStamp: String,
        intent: Intent,
        imageUrl: String
    ) {
        notificationUtils = NotificationUtils(context)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        notificationUtils?.showNotificationMessage(title, message, timeStamp, intent, imageUrl)
    }
}