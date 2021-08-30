package id.tadi.visithumbang.accommodations.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.tadi.visithumbang.R
import id.tadi.visithumbang.databinding.FragmentAccomodationListBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AccomodationListFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding : FragmentAccomodationListBinding

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
        binding = FragmentAccomodationListBinding.inflate(layoutInflater)
        return binding.root
    }
}