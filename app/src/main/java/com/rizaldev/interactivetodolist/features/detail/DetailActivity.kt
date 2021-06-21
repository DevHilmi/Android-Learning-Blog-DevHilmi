package com.rizaldev.interactivetodolist.features.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rizaldev.interactivetodolist.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}