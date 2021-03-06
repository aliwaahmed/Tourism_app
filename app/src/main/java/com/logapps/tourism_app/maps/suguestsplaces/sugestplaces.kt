package com.logapps.tourism_app.maps.suguestsplaces

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsClient.getPackageName
import androidx.recyclerview.widget.LinearLayoutManager
import com.logapps.tourism_app.R
import com.logapps.tourism_app.maps.Adapter.adapter
import kotlinx.android.synthetic.main.fragment_places.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [sugestplaces.newInstance] factory method to
 * create an instance of this fragment.
 */
class sugestplaces : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var v: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_sugestplaces, container, false)

        val arrayList: ArrayList<sumodel> = java.util.ArrayList()

        val sumodel = sumodel()
        sumodel.name = "Alexandria"
        sumodel.title = " is the second-largest city in Egypt and a major economic center. With a population of 5,200,000, Alexandria is the largest city on the Mediterranean, the sixth-largest city in the Arab world and the ninth-largest in Africa"
        sumodel.img = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Stanly_Bridge_-_Alexandria.jpg/209px-Stanly_Bridge_-_Alexandria.jpg"
        sumodel.url = "https://tourflag.com/%D9%85%D8%B5%D8%B1/%D8%A7%D9%84%D8%B3%D9%8A%D8%A7%D8%AD%D8%A9-%D9%81%D9%8A-%D8%A7%D9%84%D8%A5%D8%B3%D9%83%D9%86%D8%AF%D8%B1%D9%8A%D8%A9/"
        sumodel.video="android.resource://" + context!!.getPackageName() + "/" + R.raw.alexandria;


        val sumodel1 = sumodel()
        sumodel1.name = "Cairo"
        sumodel1.title = "as the famous Giza pyramid complex and the ancient city of Memphis are located in its geographical area"
        sumodel1.img = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Muizz_Street_-_Egypt.jpg/194px-Muizz_Street_-_Egypt.jpg"
        sumodel1.video="android.resource://" + context!!.getPackageName() + "/" + R.raw.cairo;
        sumodel1.url = "https://tourflag.com/%D9%85%D8%B5%D8%B1/%D8%A7%D9%84%D8%B3%D9%8A%D8%A7%D8%AD%D8%A9-%D9%81%D9%8A-%D8%A7%D9%84%D9%82%D8%A7%D9%87%D8%B1%D8%A9/"


        val sumodel2 = sumodel()
        sumodel2.name = "Aswan"
        sumodel2.title = "Aswan is a busy market and tourist centre located just north of the Aswan Dam on the east bank of the Nile at the first cataract. The modern city has expanded and includes the formerly separate community on the island of Elephantine."
        sumodel2.img = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/Aswan_Philae_temple_pavilion.jpg/420px-Aswan_Philae_temple_pavilion.jpg"
        sumodel2.video="android.resource://" + context!!.getPackageName() + "/" + R.raw.aswan;
        sumodel2.url = "https://tourflag.com/%D9%85%D8%B5%D8%B1/%D8%A7%D9%84%D8%B3%D9%8A%D8%A7%D8%AD%D8%A9-%D9%81%D9%8A-%D8%A3%D8%B3%D9%88%D8%A7%D9%86/"


        val sumodel3 = sumodel()
        sumodel3.name = "Luxor"
        sumodel3.title = "The modern city sprawls to the site of the Ancient Egyptian city of Waset, also known as Nut (Coptic: ⲛⲏ)[5] and to the Greeks as Thebes or Diospolis, Luxor has frequently been characterized as the world's greatest open-air museum"
        sumodel3.img = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/%D8%A8%D8%A7%D9%86%D9%88%D8%B1%D8%A7%D9%85%D8%A7_%D9%85%D9%86_%D8%AF%D8%A7%D8%AE%D9%84_%D9%85%D8%B9%D8%A8%D8%AF_%D8%A7%D9%84%D8%A7%D9%82%D8%B5%D8%B1.jpg/413px-%D8%A8%D8%A7%D9%86%D9%88%D8%B1%D8%A7%D9%85%D8%A7_%D9%85%D9%86_%D8%AF%D8%A7%D8%AE%D9%84_%D9%85%D8%B9%D8%A8%D8%AF_%D8%A7%D9%84%D8%A7%D9%82%D8%B5%D8%B1.jpg"
        sumodel3.video="android.resource://" + context!!.getPackageName() + "/" + R.raw.luxor;
        sumodel3.url = "https://tourflag.com/%D9%85%D8%B5%D8%B1/%D8%A7%D9%84%D8%B3%D9%8A%D8%A7%D8%AD%D8%A9-%D9%81%D9%8A-%D8%A7%D9%84%D8%A3%D9%82%D8%B5%D8%B1/"

        val sumodel4 = sumodel()
        sumodel4.name = "Sinai Peninsula"
        sumodel4.title = "The Sinai Peninsula or simply Sinai (now usually /ˈsaɪnaɪ/ SY-ny, also /ˈsaɪnɪaɪ/ SY-nih-eye and US: /ˈsaɪneɪaɪ/ SY-nay-eye)is a peninsula in Egypt, and the only part of the country located in Asia. "
        sumodel4.img = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Katharinenkloster_Sinai_BW_2.jpg/375px-Katharinenkloster_Sinai_BW_2.jpg"
        sumodel4.video="android.resource://" + context!!.getPackageName() + "/" + R.raw.sinai;
        sumodel4.url = "https://mawdoo3.com/%D8%A3%D9%87%D9%85_%D8%A7%D9%84%D9%85%D8%B9%D8%A7%D9%84%D9%85_%D8%A7%D9%84%D8%B3%D9%8A%D8%A7%D8%AD%D9%8A%D8%A9_%D9%81%D9%8A_%D8%B3%D9%8A%D9%86%D8%A7%D8%A1"


        val sumodel5 = sumodel()
        sumodel5.name = "Bahariya Oasis"
        sumodel5.title = "It is approximately 370 km away from Cairo. The roughly oval valley extends from northeast to southwest, has a length of 94 km, a maximum width of 42 km and covers an area of about 2000 km²."
        sumodel5.img = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Bahariya.jpg/209px-Bahariya.jpg"
        sumodel5.video="android.resource://" + context!!.getPackageName() + "/" + R.raw.baharia_oasis;
        sumodel5.url = "https://al-ain.com/article/oases-nature-away-hustle-bustle-city"


        val sumodel6 = sumodel()
        sumodel6.name = "Mersa Matruh"
        sumodel6.title = "ancient Egypt and during the reign of Alexander the Great, the city was known as Amunia"
        sumodel6.img = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Cleopatra_Bath%2C_Marsa_Matrouh_%283%29.jpg/435px-Cleopatra_Bath%2C_Marsa_Matrouh_%283%29.jpg"
        sumodel6.video="android.resource://" + context!!.getPackageName() + "/" + R.raw.marsamatrouh;
        sumodel6.url = "https://www.ar-traveler.com/morsi-matruh-hotels-and-best-places.html"

        val sumodel7 = sumodel()
        sumodel7.name = "Sharm El Sheikh"
        sumodel7.title = "is an Egyptian city on the southern tip of the Sinai Peninsula, in South Sinai Governorate, on the coastal strip along the Red Sea."
        sumodel7.img = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/8_A_resort_in_Sharm_El_Sheikh.jpg/420px-8_A_resort_in_Sharm_El_Sheikh.jpg"
        sumodel7.video="android.resource://" + context!!.getPackageName() + "/" + R.raw.sharm;
        sumodel7.url = "https://tourflag.com/%D9%85%D8%B5%D8%B1/%D8%A7%D9%84%D8%B3%D9%8A%D8%A7%D8%AD%D8%A9-%D9%81%D9%8A-%D8%B4%D8%B1%D9%85-%D8%A7%D9%84%D8%B4%D9%8A%D8%AE/"

        val sumodel8 = sumodel()
        sumodel8.name = "Dahab"
        sumodel8.title = "is a small town on the southeast coast of the Sinai Peninsula in Egypt, approximately 80 km (50 mi) northeast of Sharm el-Sheikh. Formerly a Bedouin fishing village, Dahab is now considered to be one of Sinai's most treasured diving destinations"
        sumodel8.img = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Dahab_panorama.jpg/420px-Dahab_panorama.jpg"
        sumodel8.video="android.resource://" + context!!.getPackageName() + "/" + R.raw.dahab;
        sumodel8.url = "https://www.ar-traveler.com/the-best-tourist-places-in-dahab.html"

        val sumodel9 = sumodel()
        sumodel9.name = "Hurghada"
        sumodel9.title = "The city was founded in the early 20th century, and until recently it was a small fishing village. But since the 1980s, it has been continually enlarged by Egyptian and foreign investors to become the leading coastal resort on the Red Sea"
        sumodel9.img = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d6/Hurghada_Hotels_R03.jpg/420px-Hurghada_Hotels_R03.jpg"
        sumodel9.video="android.resource://" + context!!.getPackageName() + "/" + R.raw.hurgada;
        sumodel9.url = "https://tourflag.com/%D9%85%D8%B5%D8%B1/%D8%A7%D9%84%D8%B3%D9%8A%D8%A7%D8%AD%D8%A9-%D9%81%D9%8A-%D8%A7%D9%84%D8%BA%D8%B1%D8%AF%D9%82%D8%A9/"

        arrayList.add(sumodel)
        arrayList.add(sumodel1)
        arrayList.add(sumodel2)
        arrayList.add(sumodel3)
        arrayList.add(sumodel4)
        arrayList.add(sumodel5)
        arrayList.add(sumodel6)
        arrayList.add(sumodel7)
        arrayList.add(sumodel8)
        arrayList.add(sumodel9)

        v.rec.setLayoutManager(LinearLayoutManager(context))
        v.rec.setAdapter(context?.let { suggestadapter(it, arrayList) })



        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment sugestplaces.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                sugestplaces().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}