package com.rajnish.androidnotification

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat

private val COMMENT_NOTIFICATION_ID = 100;
private val FRIEND_REQUEST_NOTIFICATION_ID = 101;
private val TAGS_NOTIFICATION_ID = 102;
private val BirthDay_NOTIFICATION_ID = 103;

fun NotificationManager.sendNotification(
    title: String,
    message: String,
    channel: String,
    applicationContext: Context
) {

    //TODO("Create Notification")
    val builder = NotificationCompat.Builder(
        applicationContext,
        channel
    )
        .setSmallIcon(R.mipmap.ic_launcher)
        .setContentTitle(title)
        .setContentText(message)

    when(channel){
        applicationContext.getString(R.string.comment_notification_channel_id) -> notify(
            COMMENT_NOTIFICATION_ID, builder.build())
    }



}

fun NotificationManager.cancelNotification() =  cancelAll()