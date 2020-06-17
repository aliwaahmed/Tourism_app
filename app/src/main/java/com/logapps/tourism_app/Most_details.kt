package com.logapps.tourism_app

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_most_details.*
import kotlinx.android.synthetic.main.data_raw.view.*

class Most_details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_most_details)


        try {

            Picasso.with(this).load(intent.getStringExtra("img"))
                    .into(image)
            _title.setText(intent.getStringExtra("name"))
            _desc.setText(intent.getStringExtra("title"))
            back_btn.setOnClickListener(View.OnClickListener {

                onBackPressed()

            })


        }
        catch (e:Exception)
        {

        }

    }
}