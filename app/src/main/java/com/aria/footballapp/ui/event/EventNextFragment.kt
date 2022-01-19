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
import com.aria.footballapp.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_next_match.*

/**
 * A simple [Fragment] subclass.
 */
class EventNextFragment : Fragment() {

    private lateinit var adapter: EventAdapter
    private lateinit var viewModel: EventNextViewModel

    companion object {
        private lateinit var leagueId: String

        fun create(id: String): EventNextFragment {
            leagueId = id
            return EventNextFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next_match, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            showLoading(true)

            adapter = EventAdapter()

            val factory = ViewModelFactory.instance(requireContext())
            viewModel = ViewModelProvider(this, factory)[EventNextViewModel::class.java]

            viewModel.initNextEvent(leagueId)
            viewModel.data?.observe(this, Observer { events ->
                if (events != null) {
                    showLoading(false)
                    adapter.setList(events)
                    adapter.notifyDataSetChanged()
                } else {
                    showLoading(false)
                }
            })

            rv_event_next.layoutManager = LinearLayoutManager(context)
            rv_event_next.adapter = adapter
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }
}
