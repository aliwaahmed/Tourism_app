package com.logapps.tourism_app

import android.content.Intent
import android.graphics.PixelFormat
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_most_details.*


class Most_details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_most_details)


        try {

            _more.setOnClickListener(View.OnClickListener {

                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(intent.getStringExtra("url")))
                startActivity(browserIntent)

            })
            Picasso.with(this).load(intent.getStringExtra("img"))
                    .into(image)
            _title.setText(intent.getStringExtra("name"))
            _desc.setText(intent.getStringExtra("title"))

            back_btn.setOnClickListener(View.OnClickListener {

                onBackPressed()

            })



            getWindow().setFormat(PixelFormat.TRANSLUCENT);

            val media:android.widget.MediaController = android.widget.MediaController(this)
            media.setAnchorView(_video);
            _video.setMediaController(media)

            _video.setVideoURI(Uri.parse(Uri.parse(intent.getStringExtra("video")).toString()));
            _video.requestFocus();
            _video.start();



        }
        catch (e:Exception)
        {

        }

    }
}