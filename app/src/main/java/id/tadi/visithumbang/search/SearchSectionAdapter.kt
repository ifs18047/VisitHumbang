package id.tadi.visithumbang.search

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.tadi.visithumbang.accommodations.fragments.AccomodationsFragment

class SearchSectionAdapter(activity: SearchActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> AccomodationsFragment()
            1 -> AccomodationsFragment()
            2 -> AccomodationsFragment()
            3 -> AccomodationsFragment()
            else -> AccomodationsFragment()
        }
    }

}