package com.learn.notificationbasicandroidkt

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Notification Manager
        val nm:NotificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        //whenever we need to make and show notification we can do with the use of notification manager

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            nm.createNotificationChannel(NotificationChannel("first","default",NotificationManager.IMPORTANCE_DEFAULT))

            val headsupnotification:NotificationChannel=NotificationChannel("second","default",NotificationManager.IMPORTANCE_HIGH)
            headsupnotification.apply {
                enableLights(true)
                enableVibration(true)
            }
            nm.createNotificationChannel(headsupnotification)
        }

        button1.setOnClickListener({
            //notification compat is a class that is used to create notification
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                Notification.Builder(this,"second")
            }else{
                Notification.Builder(this)
                        .setPriority(Notification.PRIORITY_MAX)
                        .setDefaults(Notification.DEFAULT_VIBRATE or Notification.DEFAULT_LIGHTS)

            }

            val headsupNotification=NotificationCompat.Builder(this,"second")
                    .setContentTitle("simple  title")
                    //whenever we click on the notification it automatically dismiss the notification
                    .setAutoCancel(true)
                    .setContentText("this is a simple notification")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .build()

            nm.notify(8,headsupNotification)
        })


        button2.setOnClickListener({
            val i=Intent()
            i.action=Intent.ACTION_VIEW
            i.data= Uri.parse("https://google.com")
            //pending intent is an intent for future
            //we use pending intengt for notification

            val pi=PendingIntent.getActivity(this,123,i,PendingIntent.FLAG_UPDATE_CURRENT)

            val clickableNotification=NotificationCompat.Builder(this,"first")
                    .setContentTitle("simple clickable title")
                    //here we need to paas pending intent
                    .setContentIntent(pi)
                    //whenever we click on the notification it automatically dismiss the notification
                    .setAutoCancel(true)
                    .setContentText("this is a simple notification")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .build()

            nm.notify(2,clickableNotification)


        })


        button3.setOnClickListener({
            val i=Intent()
            i.action=Intent.ACTION_VIEW
            i.data= Uri.parse("https://google.com")
            //pending intent is an intent for future
            //we use pending intengt for notification

            val pi=PendingIntent.getActivity(this,123,i,PendingIntent.FLAG_UPDATE_CURRENT)

            val clickableNotification=NotificationCompat.Builder(this,"first")
                    .setContentTitle("simple clickable title")
                    .addAction(R.drawable.ic_launcher_background,"click me",pi)
                    .setAutoCancel(true)
                    .setContentText("this is a simple notification")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .build()

            nm.notify(2,clickableNotification)


        })
    }
}