package com.aria.footballapp.ui.league


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.aria.footballapp.R
import com.aria.footballapp.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_detail_information.view.*

/**
 * A simple [Fragment] subclass.
 */
class DetailInformationFragment : Fragment() {

    private lateinit var tvDescription: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var viewModel: DetailLeagueViewModel

    companion object {
        private var leagueId: String = ""
        fun create(id: String): DetailInformationFragment {
            leagueId = id
            return DetailInformationFragment()
        }

        fun obtainViewModel(activity: FragmentActivity): DetailLeagueViewModel {
            val factory: ViewModelFactory? = ViewModelFactory.instance(activity.application)
            return ViewModelProviders.of(activity, factory).get(DetailLeagueViewModel::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_information, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvDescription = view.tv_detail_description
        progressBar = view.progress_bar
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            showLoading(true)
            viewModel =
                obtainViewModel(
                    activity!!
                )

            viewModel.initLeague(leagueId)
            viewModel.leagues?.observe(this, Observer { leagues ->
                if (leagues != null) {
                    showLoading(false)
                    tvDescription.text = leagues.strDescriptionEN
                } else {
                    showLoading(false)
                    showError()
                }
            })
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
