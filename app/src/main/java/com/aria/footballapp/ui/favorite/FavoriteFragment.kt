package com.aria.footballapp.ui.favorite


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aria.footballapp.R
import com.aria.footballapp.ui.adapter.TabAdapter
import com.aria.footballapp.ui.favorite.event.FavoriteEventFragment
import com.aria.footballapp.ui.favorite.team.FavoriteTeamFragment
import kotlinx.android.synthetic.main.fragment_favorite.*

/**
 * A simple [Fragment] subclass.
 */
class FavoriteFragment : Fragment() {

    companion object {
        fun getInstance(): FavoriteFragment = FavoriteFragment()
    }

    private lateinit var tabAdapter: TabAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            tabAdapter = TabAdapter(childFragmentManager)
            tabAdapter.addFragment(
                FavoriteEventFragment.instance(),
                resources.getString(R.string.events)
            )
            tabAdapter.addFragment(
                FavoriteTeamFragment.instance(),
                resources.getString(R.string.teams)
            )

            view_pager.adapter = tabAdapter
            tab_layout.setupWithViewPager(view_pager)
        }
    }

}
