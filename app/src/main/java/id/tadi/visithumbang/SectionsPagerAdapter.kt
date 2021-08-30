package id.tadi.visithumbang

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.tadi.visithumbang.accommodations.fragments.AccomodationsFragment
import id.tadi.visithumbang.events.fragments.EventsFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.news, R.string.destinations, R.string.events, R.string.accomodations)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> EventsFragment()
            1 -> EventsFragment()
            2 -> EventsFragment()
            3 -> AccomodationsFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 4

}