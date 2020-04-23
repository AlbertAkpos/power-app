package com.example.power_app

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.power_app.receiver.PowerReceiver

class MainActivity : AppCompatActivity() {
    private val customReceiver = PowerReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED)
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        this.registerReceiver(customReceiver, intentFilter)
    }


    override fun onDestroy() {
        this.unregisterReceiver(customReceiver)
        super.onDestroy()

    }
}
