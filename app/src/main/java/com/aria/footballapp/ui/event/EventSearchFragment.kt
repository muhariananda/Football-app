package com.aria.footballapp.ui.event


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aria.footballapp.R
import com.aria.footballapp.ui.adapter.EventSearchAdapter
import com.aria.footballapp.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_event_search.*

/**
 * A simple [Fragment] subclass.
 */
class EventSearchFragment : Fragment() {

    private lateinit var viewModel: EventSearchViewModel
    private lateinit var adapter: EventSearchAdapter

    companion object {
        private lateinit var event: String

        fun getInstance(e: String): EventSearchFragment {
            event = e
            return EventSearchFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            showLoading(true)

            adapter = EventSearchAdapter()
            val factory = ViewModelFactory.instance(requireContext())
            viewModel = ViewModelProvider(this, factory)[EventSearchViewModel::class.java]

            viewModel.init(event)
            viewModel.data?.observe(this, Observer { events ->
                if (events != null) {
                    showLoading(false)
                    adapter.setList(events)
                    adapter.notifyDataSetChanged()
                } else {
                    progressBar.visibility = View.GONE
                    rv_search_event.visibility = View.GONE
                    tv_not_found.visibility = View.VISIBLE
                }
            })

            rv_search_event.layoutManager = LinearLayoutManager(context)
            rv_search_event.setHasFixedSize(true)
            rv_search_event.adapter = adapter
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progressBar.visibility = View.VISIBLE
            rv_search_event.visibility = View.INVISIBLE
        } else {
            progressBar.visibility = View.GONE
            rv_search_event.visibility = View.VISIBLE
        }
    }
}
