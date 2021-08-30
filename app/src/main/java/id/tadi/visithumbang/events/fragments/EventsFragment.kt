package id.tadi.visithumbang.events.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.tadi.visithumbang.R
import id.tadi.visithumbang.databinding.FragmentEventsBinding
import id.tadi.visithumbang.events.utils.*
import java.util.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class EventsFragment : Fragment(){
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentEventsBinding
    private lateinit var events: ArrayList<Event>

    private lateinit var rvOngoingEvents : RecyclerView
    private lateinit var ongoingAdapter : EventSecondaryAdapter

    private lateinit var rvUpcomingEvents : RecyclerView
    private lateinit var upcomingAdapter : EventThirdAdapter

    private lateinit var rvPassedEvents : RecyclerView
    private lateinit var passedAdapter : EventThirdAdapter


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
        binding = FragmentEventsBinding.inflate(layoutInflater)
        setupView()
        return binding.root
    }

    private fun setupView(){
        with(binding){
            tvOngoingEventsAll.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fl_container, EventListFragment()).commit()
            }
        }
        setupOngoingEvents()
        setupUpcomingEvents()
        setupPassedEvents()
    }

    private fun setupOngoingEvents(){
        rvOngoingEvents = binding.rvOngoingEvents
        events = Events.getDummyEvents()
        ongoingAdapter = EventSecondaryAdapter(events)
        rvOngoingEvents.adapter = ongoingAdapter
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvOngoingEvents.layoutManager = layoutManager

        ongoingAdapter.setOnItemClickCallback(object : EventSecondaryAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Event) {
                val bundle = Bundle()
                bundle.putParcelable("event", data)
                val detailsFragment = EventDetailsFragment()
                detailsFragment.arguments = bundle

                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fl_container, detailsFragment).commit()
            }
        })
    }

    private fun setupUpcomingEvents(){
        rvUpcomingEvents = binding.rvUpcomingEvents
        events = Events.getDummyEvents()
        upcomingAdapter = EventThirdAdapter(events)
        rvUpcomingEvents.adapter = upcomingAdapter
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvUpcomingEvents.layoutManager = layoutManager
    }

    private fun setupPassedEvents(){
        rvPassedEvents = binding.rvPassedEvents
        events =  Events.getDummyEvents()
        passedAdapter = EventThirdAdapter(events)
        rvPassedEvents.adapter = passedAdapter
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvPassedEvents.layoutManager = layoutManager
    }

}