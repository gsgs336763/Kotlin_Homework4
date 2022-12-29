package com.example.lab8

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.*

class MyService : Service() {
    override fun onCreate() {
        super.onCreate()
        val job: Job = GlobalScope.launch(Dispatchers.Main) {
            try {
                delay(5000)

                val intent = Intent(this@MyService, Main2Activity::class.java)

                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                this@MyService.startActivity(intent)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        job.start()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? {
        // TODO: Return the communication channel to the service.
        throw UnsupportedOperationException("Not yet implemented")
    }
}