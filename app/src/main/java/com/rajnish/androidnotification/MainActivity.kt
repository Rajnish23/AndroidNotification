package com.rajnish.androidnotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var notificationManager: NotificationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = ContextCompat.getSystemService(this,
            NotificationManager::class.java) as NotificationManager

        commentTogggleBtn.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if(isChecked){

                    //TODO(Create Channel for Comment in Post)
                    createChannel(getString(R.string.comment_notification_channel_id),
                        getString(R.string.comments))

                    val title = getString(R.string.comments)
                    val message = getString(R.string.comment_text)

                    //TODO(Send Notification using extention function)
                    notificationManager.sendNotification(
                        title,
                        message,
                        getString(R.string.comment_notification_channel_id),
                        applicationContext
                    )
                }
                else{
                    //TODO(Cancel Notification using extention function)
                    notificationManager.cancelNotification()
                }
            }

        })
    }

    private fun createChannel(channelId : String, channelName : String){
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.O){
            val notificationChannel = NotificationChannel(
                channelId,
                channelName,
                //TODO ("Change Importance as per requirement")
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                enableLights(true)
                enableVibration(true)
                lightColor = Color.GREEN
            }

            notificationManager.createNotificationChannel(notificationChannel)
        }
    }
}
