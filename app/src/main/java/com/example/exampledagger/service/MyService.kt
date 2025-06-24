package com.example.exampledagger.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.http.Tag
import kotlin.concurrent.thread

class MyService: Service() {

    private val TAG ="MyService"

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG,"Service Started")
        CoroutineScope(Dispatchers.Default).launch {

            for(i in 1..100){
                Log.d(TAG,"Running rask $i")
                Thread.sleep(1000)
            }
            Log.d(TAG,"Service finished")
            stopSelf()
        }
        return START_NOT_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG,"Service Destroyed")
    }
}