package com.learn.notificationbasicandroidkt.BroadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.learn.notificationbasicandroidkt.MainActivity

class LocaleChangedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
       Log.d("RCV","Locale")
        Toast.makeText(context,"Language Changed",Toast.LENGTH_SHORT).show()
        context.startActivity(Intent(context,MainActivity::class.java))

    }
}
