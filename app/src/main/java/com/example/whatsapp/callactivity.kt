package com.example.whatsapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class callactivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var img: ImageView
    lateinit var relativeLayout: RelativeLayout
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MyRecyclerViewAdapter
    var userList: List<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_callactivity)
        initview()
    }

    private fun initview() {
        img = findViewById(R.id.camera)
        viewPager = findViewById(R.id.viewPager)
        toolbar = findViewById(R.id.toolbar)
        tabLayout = findViewById(R.id.tablayout)
        tabLayout.addTab(tabLayout.newTab().setText("CHAT"))
        tabLayout.addTab(tabLayout.newTab().setText("STATUS"))
        tabLayout.addTab(tabLayout.newTab().setText("CALL"))
        toolbar.setTitle("WhatsApp")
        setSupportActionBar(toolbar)
        toolbar.showOverflowMenu()
        toolbar.showOverflowMenu()
    }
}