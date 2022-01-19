package com.aria.footballapp.ui.favorite.team


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
import kotlinx.android.synthetic.main.fragment_favorite_team.*

/**
 * A simple [Fragment] subclass.
 */
class FavoriteTeamFragment : Fragment() {

    private lateinit var viewModel: FavoriteTeamViewModel
    private lateinit var adapter: FavoriteTeamAdapter

    companion object {
        fun instance(): FavoriteTeamFragment =
            FavoriteTeamFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_team, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            showLoading(true)

            val factory = ViewModelFactory.instance(requireContext())
            viewModel = ViewModelProvider(this, factory)[FavoriteTeamViewModel::class.java]

            adapter = FavoriteTeamAdapter()

            viewModel.getFavorite().observe(this, Observer { teams ->
                showLoading(false)
                adapter.submitList(teams)
                adapter.notifyDataSetChanged()
            })

            rv_fav_team.layoutManager = LinearLayoutManager(context)
            rv_fav_team.setHasFixedSize(true)
            rv_fav_team.adapter = adapter
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
