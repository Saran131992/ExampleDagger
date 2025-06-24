package com.example.exampledagger

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.exampledagger.databinding.ActivityMainBinding
import com.example.exampledagger.di.DaggerAppComponent
import com.example.exampledagger.service.ApiService
import com.example.exampledagger.service.MyService

import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var apiService: ApiService


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DaggerAppComponent.create().inject(this)
        Toast.makeText(this, userRepository.getUser(), Toast.LENGTH_SHORT).show()
        lifecycleScope.launch {

            val user = apiService.getUser()
            println("user-$user")
        }
     binding.btnStart.setOnClickListener {
         val intent = Intent(this,MyService::class.java)
         startService(intent)
     }
        binding.btnStop.setOnClickListener{

            val intent = Intent(this,MyService::class.java)
            stopService(intent)
        }

    }
}