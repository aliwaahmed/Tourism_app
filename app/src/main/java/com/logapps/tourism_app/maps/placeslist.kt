package com.logapps.tourism_app.maps

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.logapps.tourism_app.MainActivity
import com.logapps.tourism_app.Profile_Activity
import com.logapps.tourism_app.R
import com.logapps.tourism_app.maps.most.mostplaces
import com.logapps.tourism_app.maps.suguestsplaces.sugestplaces
import com.logapps.tourism_app.maps.ui.places


class placeslist : AppCompatActivity() {


    lateinit var sectionsPagerAdapter: SectionsPagerAdapter
    val MyPREFERENCES = "MyPrefs"
    var sharedpreferences: SharedPreferences? = null
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE)

        // do your tasks
        requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 0)

        sectionsPagerAdapter = SectionsPagerAdapter(this, getSupportFragmentManager())
        val viewPager: ViewPager = findViewById(R.id.view_pager)


        sectionsPagerAdapter.addFrag(sugestplaces(), "suggest places")
        sectionsPagerAdapter.addFrag(mostplaces(), "most visited places")
         sectionsPagerAdapter.addFrag(places(), "place nearby u")

        viewPager.adapter = sectionsPagerAdapter

        sectionsPagerAdapter.notifyDataSetChanged()
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        return when (id) {
            R.id.item1 -> {
                val intent = Intent(this@placeslist, Profile_Activity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                true
            }
            R.id.item2 -> {

                val editor = sharedpreferences!!.edit()

                editor.putString("mail", "-1")
                editor.commit()
                val intent = Intent(this@placeslist, MainActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()



                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


}