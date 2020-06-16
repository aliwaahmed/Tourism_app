package com.logapps.tourism_app.maps

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.logapps.tourism_app.R
import com.logapps.tourism_app.maps.suguestsplaces.sugestplaces
import com.logapps.tourism_app.maps.ui.places


class placeslist : AppCompatActivity() {


    lateinit var sectionsPagerAdapter: SectionsPagerAdapter

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        // do your tasks
        requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 0)

        sectionsPagerAdapter = SectionsPagerAdapter(this, getSupportFragmentManager())
        val viewPager: ViewPager = findViewById(R.id.view_pager)


        sectionsPagerAdapter.addFrag(places(), "place nearby u")
        sectionsPagerAdapter.addFrag(sugestplaces(), "Sugest places")


        viewPager.adapter = sectionsPagerAdapter

        sectionsPagerAdapter.notifyDataSetChanged()
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)













    }



}