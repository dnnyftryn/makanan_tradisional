package com.dannyfitriyana.makanan_tradisional

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvMakanan: RecyclerView
    private lateinit var btnAboutMe: Button

    private fun showRecycleGrid() {
        rvMakanan.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        val gridAdapter = GridFoodAdapter(MakananData.listData)
        rvMakanan.adapter = gridAdapter

        gridAdapter.setOnItemClickCallback(object : GridAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Makanan) {
                val moveIntent = Intent(this@MainActivity, DetailActivity::class.java)
                moveIntent.putExtra("namaMakanan", data.nama)
                moveIntent.putExtra("descMakanan", data.deskripsi)
                moveIntent.putExtra("imgMakanan", data.poster)
                startActivity(moveIntent)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAboutMe = findViewById<Button>(R.id.btn_about_me)
        btnAboutMe.setOnClickListener{
            val intent = Intent(this,AboutMeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}