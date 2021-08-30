package id.tadi.visithumbang.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import id.tadi.visithumbang.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    companion object{
        private val SEARCH_TAB = arrayListOf<String>(
            "News",
            "Destinations",
            "Events",
            "Accomodations"
        )
    }

    private lateinit var binding : ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setupView()
        setContentView(binding.root)
    }

    private fun setupView(){
        supportActionBar?.hide()
        setupSearchPager()
    }

    private fun setupSearchPager(){
        val searchTab = binding.searchTab
        binding.searchPager.adapter = SearchSectionAdapter(this)

        TabLayoutMediator(searchTab, binding.searchPager){ tab, position ->
            tab.text = SEARCH_TAB[position]
        }.attach()

    }
}