package com.logapps.tourism_app.maps.Adapter

import android.R.attr.data
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.logapps.tourism_app.R
import com.logapps.tourism_app.maps.model.placesmodel
import com.logapps.tourism_app.maps.route.route
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.data_raw.view.*


class adapter(private val context: Context, private val mPlacesmodel: placesmodel) : RecyclerView.Adapter<mViewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewholder {
        return mViewholder(LayoutInflater.from(parent.context).inflate(R.layout.data_raw, parent, false))
    }

    override fun onBindViewHolder(holder: mViewholder, position: Int) {

        try {
            if (mPlacesmodel.results.get(position).photos!=null) {
                if (mPlacesmodel.results.get(position).photos.size > 0) {
                    val url: String = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference="
                    val photoRef: String = mPlacesmodel.results.get(position).photos.get(0).photo_reference
                    val imageUrl: String = url + photoRef + "&key=AIzaSyBzqbRKzOsDOKwFVeKT36TFJuK5YecGYmk"

                    Picasso.with(context).load(imageUrl)
                            .into(holder.itemView._image);

                }
            }

            holder.itemView._title.setText(mPlacesmodel.results.get(position).name)
            holder.itemView._description.setText("Users rate "+mPlacesmodel.results.get(position).rating.toString())
            holder.itemView.textView.setText(mPlacesmodel.results.get(position).geometry.location.toString())

            holder.itemView._lin.setOnClickListener(View.OnClickListener {
                val intent =Intent(context, route::class.java)
                intent.putExtra("lat",mPlacesmodel.results.get(position).geometry.location.lat.toString())
                intent.putExtra("long",mPlacesmodel.results.get(position).geometry.location.lng.toString())
                context.startActivity(intent)


            })

        }
        catch (e:Exception)
        {

        }





    }
    override fun getItemCount(): Int {
        return mPlacesmodel.results.size
    }

}

class mViewholder(itemView: View) : RecyclerView.ViewHolder(itemView)