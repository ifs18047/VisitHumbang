package id.tadi.visithumbang.accommodations.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.tadi.visithumbang.R
import id.tadi.visithumbang.accommodations.utils.Accommodation
import id.tadi.visithumbang.accommodations.utils.Accommodations
import id.tadi.visithumbang.accommodations.utils.AccommodationsPrimaryAdapter
import id.tadi.visithumbang.accommodations.utils.AccomodationThirdAdapter
import id.tadi.visithumbang.databinding.FragmentAccomodationDetailsBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AccomodationDetailsFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding : FragmentAccomodationDetailsBinding

    private lateinit var rvOtherAccomodations : RecyclerView
    private lateinit var otherAdapter: AccomodationThirdAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccomodationDetailsBinding.inflate(layoutInflater)
        setupView()
        return binding.root
    }

    private fun setupView(){
        val hotel = arguments?.getParcelable<Accommodation>("accomodation")
        Glide.with(binding.ivFragmentDetailsPoster.context)
            .load(hotel?.accommodationPoster)
            .centerCrop()
            .into(binding.ivFragmentDetailsPoster)
        binding.tvAccommodationDetailsTitle.text = hotel?.accommodationName
        binding.tvAccommodationDetailsTitle.setTextColor(Color.WHITE)
        binding.tvAccommodationDetailsLocation.text = hotel?.accommodationLocation
        binding.tvAccomodationDetailsDescription.text = hotel?.accommodationAbout

        setupOtherAccomodations()
    }

    private fun setupOtherAccomodations(){
        rvOtherAccomodations = binding.rvOtherHotels
        otherAdapter = AccomodationThirdAdapter(Accommodations.getDummyAccommodations())
        rvOtherAccomodations.adapter = otherAdapter
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvOtherAccomodations.layoutManager = layoutManager
    }
}