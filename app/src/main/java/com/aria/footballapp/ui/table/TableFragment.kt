package com.aria.footballapp.ui.table


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aria.footballapp.R
import com.aria.footballapp.data.source.local.entity.TeamsEntity
import com.aria.footballapp.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_table.*

/**
 * A simple [Fragment] subclass.
 */
class TableFragment : Fragment() {

    private lateinit var viewModel: TableViewModel
    private lateinit var adapter: TableAdapter

    private lateinit var teams: MutableList<TeamsEntity>

    companion object {
        private lateinit var idLeague: String

        fun getInstance(id: String): TableFragment {
            idLeague = id
            return TableFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_table, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            showLoading(true)
            adapter = TableAdapter()
            val factory = ViewModelFactory.instance(requireContext())
            viewModel = ViewModelProvider(this, factory)[TableViewModel::class.java]

            viewModel.initTable(idLeague)
            viewModel.table?.observe(this, Observer { table ->
                if (table != null) {
                    showLoading(false)
                    adapter.setList(table)
                    adapter.notifyDataSetChanged()
                }
            })
            rv_table.layoutManager = LinearLayoutManager(context)
            rv_table.setHasFixedSize(true)
            rv_table.adapter = adapter
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
