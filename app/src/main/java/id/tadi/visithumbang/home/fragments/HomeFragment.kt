package id.tadi.visithumbang.home.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.tadi.visithumbang.databinding.FragmentHomeBinding
import id.tadi.visithumbang.events.utils.Events
import id.tadi.visithumbang.search.SearchActivity
import id.tadi.visithumbang.utils.CarouselAdapter
import id.tadi.visithumbang.utils.SecondaryNewsCardAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding : FragmentHomeBinding

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
        binding = FragmentHomeBinding.inflate(layoutInflater)
        setupView()
        return binding.root
    }

    private fun setupView(){
        setupCarousel()
        setupNews()
        setupEvents()
        setupAccomodations()
        setupSearch()
    }

    private fun setupCarousel(){
        val rvHomeCarousel = binding.rvHomeCarousel
        rvHomeCarousel.adapter = CarouselAdapter(arrayListOf(
            "https://www.jawaban.com/assets/uploads/lori_mora/images/main/160801142520.jpg",
            "https://static.inilah.com/data/berita/foto/2348202.jpg",
            "https://storage.googleapis.com/allindonesiatoursim/2017/12/79ee60be-danau-toba.jpg",
            "https://www.indofoodstore.com/images/lake%20toba%202.jpg"
        ))
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvHomeCarousel.layoutManager = layoutManager

        rvHomeCarousel.addOnItemTouchListener(object : RecyclerView.SimpleOnItemTouchListener(){
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                return true
            }
        })

        binding.btnHomeCarouselNext.setOnClickListener {
            if(layoutManager.findFirstVisibleItemPosition() != 2){
                rvHomeCarousel.smoothScrollToPosition(layoutManager.findLastCompletelyVisibleItemPosition()+1)
            }
        }

        binding.btnHomeCarouselPrev.setOnClickListener {
            if(layoutManager.findFirstVisibleItemPosition() != 0){
                rvHomeCarousel.smoothScrollToPosition(layoutManager.findLastCompletelyVisibleItemPosition()-1)
            }
        }
    }

    private fun setupNews(){
        val rvHomeNews = binding.rvHomeNews
        rvHomeNews.adapter = SecondaryNewsCardAdapter(Events.getDummyEvents())
        rvHomeNews.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setupEvents(){
        val rvHomeEvents = binding.rvHomeEvents
        rvHomeEvents.adapter = SecondaryNewsCardAdapter(Events.getDummyEvents())
        rvHomeEvents.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setupAccomodations(){
        val rvHomeAccomodations = binding.rvHomeAccomodations
        rvHomeAccomodations.adapter = SecondaryNewsCardAdapter(Events.getDummyEvents())
        rvHomeAccomodations.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setupSearch(){
        binding.btnHomeSearch.setOnClickListener {
            startActivity(
                Intent(
                    activity,
                    SearchActivity::class.java
                )
            )
        }
    }

}