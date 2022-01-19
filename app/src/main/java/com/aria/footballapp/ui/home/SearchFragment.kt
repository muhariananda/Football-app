package com.aria.footballapp.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aria.footballapp.R
import com.aria.footballapp.ui.adapter.TabAdapter
import com.aria.footballapp.ui.event.EventSearchFragment
import com.aria.footballapp.ui.team.TeamSearchFragment
import kotlinx.android.synthetic.main.fragment_search.*

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {

    private lateinit var adapter: TabAdapter

    companion object {
        private lateinit var query: String

        fun getInstance(q: String): SearchFragment {
            query = q
            return SearchFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            adapter = TabAdapter(childFragmentManager)
            adapter.addFragment(
                EventSearchFragment.getInstance(query),
                resources.getString(R.string.events)
            )
            adapter.addFragment(
                TeamSearchFragment.getInstance(query),
                resources.getString(R.string.teams)
            )

            view_pager.adapter = adapter
            tab_layout.setupWithViewPager(view_pager)
        }
    }
}
