package com.aria.footballapp.ui.favorite.event


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
import kotlinx.android.synthetic.main.fragment_favorite_event.*

/**
 * A simple [Fragment] subclass.
 */
class FavoriteEventFragment : Fragment() {

    private lateinit var viewModel: FavoriteEventViewModel
    private lateinit var adapter: FavoriteEventAdapter

    companion object {
        fun instance(): FavoriteEventFragment =
            FavoriteEventFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_event, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            showLoading(true)

            val factory = ViewModelFactory.instance(requireContext())
            viewModel = ViewModelProvider(this, factory)[FavoriteEventViewModel::class.java]

            adapter = FavoriteEventAdapter()

            viewModel.getFavorite().observe(this, Observer { event ->
                showLoading(false)
                adapter.submitList(event)
                adapter.notifyDataSetChanged()
            })

            rv_fav_event.layoutManager = LinearLayoutManager(context)
            rv_fav_event.setHasFixedSize(true)
            rv_fav_event.adapter = adapter
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
