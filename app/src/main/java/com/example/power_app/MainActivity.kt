package com.example.power_app

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.power_app.receiver.PowerReceiver

class MainActivity : AppCompatActivity() {
    private val powerReceiver = PowerReceiver()
    private val ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED)
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        intentFilter.addAction(ACTION_CUSTOM_BROADCAST)
        intentFilter.addAction(Intent.ACTION_HEADSET_PLUG)
        this.registerReceiver(powerReceiver, intentFilter)

    }


    override fun onDestroy() {
        this.unregisterReceiver(powerReceiver)
        super.onDestroy()

    }

    fun sendCustomBroadcast(view: View) {
        val customBroadcastIntent = Intent(ACTION_CUSTOM_BROADCAST)
        customBroadcastIntent.putExtra("num", 12)
        sendBroadcast(customBroadcastIntent)
    }
}
