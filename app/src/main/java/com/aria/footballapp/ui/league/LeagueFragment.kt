package com.aria.footballapp.ui.league


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
import kotlinx.android.synthetic.main.fragment_league.*

/**
 * A simple [Fragment] subclass.
 */
class LeagueFragment : Fragment() {

    private lateinit var adapter: LeagueAdapter
    private lateinit var viewModel: LeagueViewModel

    companion object {

        fun instance(): LeagueFragment =
            LeagueFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_league, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            showLoading(true)

            adapter = LeagueAdapter()

            val factory = ViewModelFactory.instance(requireContext())
            viewModel = ViewModelProvider(this, factory)[LeagueViewModel::class.java]

            viewModel.initLeague()
            viewModel.getLeague()?.observe(this, Observer { leagues ->
                if (leagues != null) {
                    showLoading(false)
                    adapter.setList(leagues)
                    adapter.notifyDataSetChanged()
                } else {
                    showLoading(false)
                }
            })

            rv_league_list.layoutManager = LinearLayoutManager(context)
            rv_league_list.adapter = adapter
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progress_bar.visibility = View.VISIBLE
        } else {
            progress_bar.visibility = View.GONE
        }
    }
}
