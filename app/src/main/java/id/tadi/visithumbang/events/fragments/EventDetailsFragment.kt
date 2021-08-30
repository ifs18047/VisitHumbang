package id.tadi.visithumbang.events.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import id.tadi.visithumbang.R
import id.tadi.visithumbang.databinding.FragmentEventDetailsBinding
import id.tadi.visithumbang.databinding.FragmentEventListBinding
import id.tadi.visithumbang.events.utils.Event

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class EventDetailsFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentEventDetailsBinding

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
        binding = FragmentEventDetailsBinding.inflate(layoutInflater)
        setupView()
        return binding.root
    }

    @SuppressLint("CheckResult")
    private fun setupView(){
        val event = arguments?.getParcelable<Event>("event")
        Glide.with(binding.ivFragmentDetailsPoster)
            .load(event?.eventPoster)
            .centerCrop()
            .into(binding.ivFragmentDetailsPoster)
        binding.tvEventDetailsTitle.text = event?.eventName
        binding.tvEventDetailsTitle.setTextColor(Color.WHITE)
        binding.tvEventDetailsDate.text = event?.eventDate
        binding.tvEventDetailsLocation.text = event?.eventLocation
        binding.tvEventDetailsDescription.text = event?.eventDescription
    }
}