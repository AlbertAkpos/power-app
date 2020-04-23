package com.example.power_app.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class PowerReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val intentAction = intent.action
        if (intentAction != null){
            val toastMessage = when(intentAction){
                Intent.ACTION_POWER_CONNECTED -> "Power connected"
                Intent.ACTION_POWER_DISCONNECTED -> "Power disconnected"
                else -> "Unknown intent action"
            }

            Toast.makeText(context, toastMessage, Toast.LENGTH_LONG).show()
        }

    }
}
