package com.dannyfitriyana.makanan_tradisional

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AboutMeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)
        title = "About Me"
    }
}