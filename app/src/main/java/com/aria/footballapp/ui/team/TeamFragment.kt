package com.aria.footballapp.ui.team


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aria.footballapp.R
import com.aria.footballapp.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_team.*

/**
 * A simple [Fragment] subclass.
 */
class TeamFragment : Fragment() {

    private lateinit var adapter: TeamAdapter
    private lateinit var viewModel: TeamsViewModel

    companion object {
        private lateinit var leagues: String

        fun create(league: String): TeamFragment {
            leagues = league
            return TeamFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            showLoading(true)

            adapter = TeamAdapter()
            val factory = ViewModelFactory.instance(requireContext())
            viewModel = ViewModelProvider(this, factory)[TeamsViewModel::class.java]

            viewModel.initTeam(leagues)
            viewModel.teams?.observe(this, Observer { teams ->
                if (teams != null) {
                    showLoading(false)
                    adapter.setList(teams)
                    adapter.notifyDataSetChanged()
                } else {
                    showLoading(false)
                    showError()
                }
            })

            rv_teams.layoutManager = LinearLayoutManager(context)
            rv_teams.adapter = adapter
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    private fun showError() {
        Toast.makeText(context, resources.getString(R.string.error), Toast.LENGTH_SHORT).show()
    }
}
