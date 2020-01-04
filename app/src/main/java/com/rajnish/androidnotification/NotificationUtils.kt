package com.rajnish.androidnotification

import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat

private val COMMENT_NOTIFICATION_ID = 100;
private val FRIEND_REQUEST_NOTIFICATION_ID = 101;
private val TAGS_NOTIFICATION_ID = 102;
private val BIRTHDAY_NOTIFICATION_ID = 103;
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
        .setPriority(NotificationCompat.PRIORITY_HIGH)

    when(channel){
        applicationContext.getString(R.string.comment_notification_channel_id) -> notify(
            COMMENT_NOTIFICATION_ID, builder.build())
        applicationContext.getString(R.string.friend_request_notification_channel_id) -> notify(
            FRIEND_REQUEST_NOTIFICATION_ID, builder.build()
        )
        applicationContext.getString(R.string.birthday_notification_channel_id) -> {
            val bitmap =
                BitmapFactory.decodeResource(applicationContext.resources, R.drawable.birthday)
            builder.setLargeIcon(bitmap)

            builder.setStyle(NotificationCompat.BigPictureStyle().bigLargeIcon(null).bigPicture(
                bitmap
            ))
            notify(BIRTHDAY_NOTIFICATION_ID, builder.build())
        }
        applicationContext.getString(R.string.tags_notification_channel_id) -> {
            builder.setStyle(NotificationCompat.BigTextStyle()
                .bigText(applicationContext.getString(R.string.tag_large_text))
                .setBigContentTitle("NotificationCompat.Style"))
            notify(TAGS_NOTIFICATION_ID, builder.build())
        }

    }

}

fun NotificationManager.cancelNotification() = cancelAll()