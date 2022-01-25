package com.learn.notificationbasicandroidkt

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class OnChargerConnected : AppCompatActivity() {

    //in this activiy we will do on charger connect
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_charger_connected)

        val psr=PowerStateReceiver()
        val iFilter=IntentFilter().apply {
            addAction(Intent.ACTION_POWER_DISCONNECTED)
            addAction(Intent.ACTION_POWER_CONNECTED)
        }

        registerReceiver(psr,iFilter)
    }

    inner class PowerStateReceiver:BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            Toast.makeText(p0,"POWER STate Changed",Toast.LENGTH_SHORT).show()
        }

    }
}