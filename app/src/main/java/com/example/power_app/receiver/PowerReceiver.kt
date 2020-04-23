package com.example.power_app.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.power_app.BuildConfig

class PowerReceiver : BroadcastReceiver() {
    private val ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST"

    override fun onReceive(context: Context, intent: Intent) {
        val intentAction = intent.action
        if (intentAction != null){
            val toastMessage = when(intentAction){
                Intent.ACTION_POWER_CONNECTED -> "Power connected"
                Intent.ACTION_POWER_DISCONNECTED -> "Power disconnected"
                ACTION_CUSTOM_BROADCAST -> {
                    val num = intent.getIntExtra("num", 0)
                    num.toString()
                }
                else -> "Unknown intent action"
            }

            Toast.makeText(context, toastMessage, Toast.LENGTH_LONG).show()
        }

    }
}
