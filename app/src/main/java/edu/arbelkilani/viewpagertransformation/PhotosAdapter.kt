package edu.arbelkilani.viewpagertransformation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PhotosAdapter(private val photosList: List<Photo>, fm: AppCompatActivity) :
    FragmentStateAdapter(fm.supportFragmentManager, fm.lifecycle) {

    private val fragmentList = HashMap<Int, Fragment>()

    override fun getItemCount(): Int {
        return photosList.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = ViewPagerFragment.newInstance(photosList[position])
        fragmentList[position] = fragment
        return fragment
    }

    fun getFragmentByPosition(position: Int): Fragment? {
        return fragmentList[position]
    }

}