package com.logapps.tourism_app.maps.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.gson.Gson
import com.logapps.tourism_app.R
import com.logapps.tourism_app.maps.Adapter.adapter
import com.logapps.tourism_app.maps.model.placesmodel
import kotlinx.android.synthetic.main.fragment_places.view.*
import okhttp3.*
import java.io.IOException


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [places.newInstance] factory method to
 * create an instance of this fragment.
 */
class places : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    val PERMISSION_ID = 42
    lateinit var mFusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var  v:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        v=inflater.inflate(R.layout.fragment_places, container, false)

        mFusedLocationClient = context?.let { LocationServices.getFusedLocationProviderClient(it) }!!


        // do your tasks
        getLastLocation()

        return v
    }


    var client = OkHttpClient()

    @Throws(IOException::class)
    fun run(url: String?) {
        val request = Request.Builder()
                .url(url!!)
                .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                val s = response.body!!.string()
                Log.e("responsee", s)
                val gson = Gson()
                val  results = gson.fromJson(s, placesmodel::class.java)
                Log.e("size", results.results.size.toString())


                activity?.runOnUiThread(Runnable {
                    v.rec.setLayoutManager(LinearLayoutManager(context))

                    v.rec.setAdapter(context?.let { adapter(it,results) })


                })
            }
        })
    }





    companion object {
















        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                places().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }



    private fun getLastLocation() {
        if (checkPermissions()) {
            if (isLocationEnabled()) {

                if (context?.let { ActivityCompat.checkSelfPermission(it, Manifest.permission.ACCESS_FINE_LOCATION) } != PackageManager.PERMISSION_GRANTED && context?.let { ActivityCompat.checkSelfPermission(it, Manifest.permission.ACCESS_COARSE_LOCATION) } != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return
                }
                mFusedLocationClient.lastLocation.addOnCompleteListener(OnCompleteListener {

                    var location: Location? = it.result
                    if (location == null) {
                        requestNewLocationData()
                    } else {
                        location.latitude.toString()
                        location.longitude.toString()

                        Log.e("latali",location.latitude.toString())
                        Log.e("logali", location.longitude.toString())
                        try {
                            run("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+location.latitude.toString()+"," +
                                    location.longitude.toString()+"&radius=5000&types=*&key=AIzaSyBzqbRKzOsDOKwFVeKT36TFJuK5YecGYmk")
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }



                    }


                })
            } else {
                Toast.makeText(context, "Turn on location", Toast.LENGTH_LONG).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        } else {
            requestPermissions()
        }
    }


    private fun requestNewLocationData() {
        var mLocationRequest = LocationRequest()
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        mLocationRequest.interval = 0
        mLocationRequest.fastestInterval = 0
        mLocationRequest.numUpdates = 1

        mFusedLocationClient = context?.let { LocationServices.getFusedLocationProviderClient(it) }!!
        if (context?.let { ActivityCompat.checkSelfPermission(it, Manifest.permission.ACCESS_FINE_LOCATION) } != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context!!, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return
        }
        mFusedLocationClient!!.requestLocationUpdates(
                mLocationRequest, mLocationCallback,
                Looper.myLooper()
        )
    }

    private val mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            var mLastLocation: Location = locationResult.lastLocation
           mLastLocation.latitude.toString()
          mLastLocation.longitude.toString()


        }
    }












    private fun checkPermissions(): Boolean {
        if (context?.let { ActivityCompat.checkSelfPermission(it, Manifest.permission.ACCESS_COARSE_LOCATION) } == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(context!!, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            return true
        }
        return false
    }
    private fun requestPermissions() {
        activity?.let {
            ActivityCompat.requestPermissions(
                    it,
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSION_ID
        )
        }
    }
    private fun isLocationEnabled(): Boolean {
        var locationManager: LocationManager = activity!!.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
                LocationManager.NETWORK_PROVIDER
        )
    }
}