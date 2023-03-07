package com.onelenyk.mybootcounterapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.onelenyk.mybootcounterapplication.data.model.BootEventEntity
import com.onelenyk.mybootcounterapplication.local.database.provider.DBProvider


class BootCompletedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

        // i'm not sure about context, if room will init properly.
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {

            val currentTimeMillis = System.currentTimeMillis()
            val bootEvent = BootEventEntity(timestamp = currentTimeMillis)
            DBProvider.getBootEventDao(context).insertBootEvent(bootEvent)
        }
    }
}