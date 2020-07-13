package com.logapps.tourism_app.maps.suguestsplaces

import android.R.attr.data
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.logapps.tourism_app.Most_details
import com.logapps.tourism_app.R
import com.logapps.tourism_app.maps.model.placesmodel
import com.logapps.tourism_app.maps.route.route
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.data_raw.view.*


class suggestadapter(private val context: Context, private val mPlacesmodel:ArrayList<sumodel>) : RecyclerView.Adapter<mViewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewholder {
        return mViewholder(LayoutInflater.from(parent.context).inflate(R.layout.data_raw, parent, false))
    }

    override fun onBindViewHolder(holder: mViewholder, position: Int) {

        try {
            holder.itemView._title.setText(mPlacesmodel.get(position).name)
            holder.itemView._description.setText(mPlacesmodel.get(position).title.toString())
            Picasso.with(context).load(mPlacesmodel.get(position).img)
                    .into(holder.itemView._image)
            holder.itemView.textView.visibility=View.GONE

            holder.itemView._lin.setOnClickListener(View.OnClickListener {
                val intent =Intent(context,Most_details::class.java)
                intent.putExtra("name",mPlacesmodel.get(position).name)
                intent.putExtra("title",mPlacesmodel.get(position).title.toString())
                intent.putExtra("img",mPlacesmodel.get(position).img)
                intent.putExtra("video",mPlacesmodel.get(position).video)
                intent.putExtra("url",mPlacesmodel.get(position).url)


                context.startActivity(intent)


            })


        }
        catch (e:Exception)
        {

        }





    }
    override fun getItemCount(): Int {
        return mPlacesmodel.size
    }

}

class mViewholder(itemView: View) : RecyclerView.ViewHolder(itemView)