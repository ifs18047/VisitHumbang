package id.tadi.visithumbang.accommodations.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.tadi.visithumbang.R
import id.tadi.visithumbang.accommodations.utils.Accommodation
import id.tadi.visithumbang.accommodations.utils.Accommodations
import id.tadi.visithumbang.accommodations.utils.AccommodationsPrimaryAdapter
import id.tadi.visithumbang.databinding.FragmentAccomodationsBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AccomodationsFragment : Fragment(){
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding : FragmentAccomodationsBinding

    private lateinit var rvHotels : RecyclerView
    private lateinit var hotelsAdapter : AccommodationsPrimaryAdapter

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
        binding = FragmentAccomodationsBinding.inflate(layoutInflater)
        setupView()
        return binding.root
    }

    private fun setupView(){
        setupHotels()
    }

    private fun setupHotels(){
        rvHotels = binding.rvHotels
        hotelsAdapter = AccommodationsPrimaryAdapter(Accommodations.getDummyAccommodations())
        rvHotels.adapter = hotelsAdapter
        val layoutManager = LinearLayoutManager(activity)
        rvHotels.layoutManager = layoutManager

        hotelsAdapter.setOnItemClickCallback(object : AccommodationsPrimaryAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Accommodation) {
                val bundle = Bundle()
                bundle.putParcelable("accomodation", data)
                val detailsFragment = AccomodationDetailsFragment()
                detailsFragment.arguments = bundle

                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fl_container, detailsFragment).commit()
            }

        })
    }
}