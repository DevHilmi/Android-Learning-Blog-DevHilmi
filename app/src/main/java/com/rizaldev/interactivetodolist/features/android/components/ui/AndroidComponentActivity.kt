package com.rizaldev.interactivetodolist.features.android.components.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rizaldev.interactivetodolist.R

class AndroidComponentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_component)
    }
}