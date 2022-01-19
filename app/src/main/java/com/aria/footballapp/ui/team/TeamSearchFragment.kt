package com.aria.footballapp.ui.team


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aria.footballapp.R
import com.aria.footballapp.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_team_search.*

/**
 * A simple [Fragment] subclass.
 */
class TeamSearchFragment : Fragment() {

    private lateinit var viewModel: TeamSearchViewModel
    private lateinit var adapter: TeamSearchAdapter

    companion object {
        private lateinit var teams: String

        fun getInstance(t: String): TeamSearchFragment {
            teams = t
            return TeamSearchFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            showLoading(true)

            adapter = TeamSearchAdapter()
            val factory = ViewModelFactory.instance(requireContext())
            viewModel = ViewModelProvider(this, factory)[TeamSearchViewModel::class.java]

            viewModel.initSearch(teams)
            viewModel.teams?.observe(this, Observer { teams ->
                if (teams != null) {
                    showLoading(false)
                    adapter.setList(teams)
                    adapter.notifyDataSetChanged()

                } else {
                    progressBar.visibility = View.GONE
                    rv_search_team.visibility = View.GONE
                    tv_not_found.visibility = View.VISIBLE
                }
            })
            rv_search_team.layoutManager = LinearLayoutManager(context)
            rv_search_team.setHasFixedSize(true)
            rv_search_team.adapter = adapter
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progressBar.visibility = View.VISIBLE
            rv_search_team.visibility = View.INVISIBLE
        } else {
            progressBar.visibility = View.GONE
            rv_search_team.visibility = View.VISIBLE
        }
    }
}
