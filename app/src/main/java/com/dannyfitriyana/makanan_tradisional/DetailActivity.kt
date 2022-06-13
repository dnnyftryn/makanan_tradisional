package com.dannyfitriyana.makanan_tradisional

import android.content.Intent
import android.graphics.text.LineBreaker
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var judul: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        judul = intent.getStringExtra("namaMakanan") as String

        supportActionBar?.title = judul

        val tvMakanan  = findViewById<TextView>(R.id.tv_makanan)
        val tvDescMakanan = findViewById<TextView>(R.id.tv_descmakanan)
        val ivImgMakanan = findViewById<ImageView>(R.id.iv_imgmakanan)

        tvMakanan.text = judul
        tvDescMakanan.text = intent.getStringExtra("descMakanan")
        Glide.with(this)
            .load(intent.getIntExtra("imgMakanan", 0))
            .into(ivImgMakanan)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            tvDescMakanan.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
        }

        val btnShare: Button = findViewById(R.id.btn_share)
        btnShare.setOnClickListener(this)

        val btnFavorite: Button = findViewById(R.id.btn_favorite)
        btnFavorite.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_share -> {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, "Baca $judul di Makanan Tradisional App")
                startActivity(Intent.createChooser(intent, "share with"))
            }
            R.id.btn_favorite -> {
                Toast.makeText(this, "makanan favourite anda adalah $judul", Toast.LENGTH_SHORT).show()
            }
        }
    }
}