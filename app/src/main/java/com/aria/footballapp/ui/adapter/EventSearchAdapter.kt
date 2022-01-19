package com.aria.footballapp.ui.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aria.footballapp.R
import com.aria.footballapp.data.source.local.entity.EventsEntity
import com.aria.footballapp.ui.event.DetailEventActivity
import com.aria.footballapp.ui.event.DetailEventActivity.Companion.EXTRA_EVENT
import kotlinx.android.synthetic.main.list_event_search.view.*

import org.jetbrains.anko.startActivity
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class EventSearchAdapter :
    RecyclerView.Adapter<EventSearchAdapter.SearchEventViewHolder>() {

    private val events: MutableList<EventsEntity> = ArrayList()

    fun setList(items: List<EventsEntity>) {
        this.events.clear()
        this.events.addAll(items)
    }

    class SearchEventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SimpleDateFormat")
        fun bindItems(event: EventsEntity) {

            val timeConvert = toGMTFormat(event.dateEvent)
            val formatDate = SimpleDateFormat("E, dd/MM")
            val date = formatDate.format(timeConvert)

            with(itemView) {
                tv_team_home.text = event.strHomeTeam
                tv_team_away.text = event.strAwayTeam
                tv_score_home.text = event.intHomeScore
                tv_score_away.text = event.intAwayScore
                tv_next_date.text = date

                tv_fav_match_info.text = resources.getString(R.string.last)
                tv_fav_match_info.setTextColor(Color.parseColor("#2ecc71"))

                if (event.intHomeScore == null && event.intAwayScore == null) {
                    tv_score_home.visibility = View.INVISIBLE
                    tv_score_away.visibility = View.INVISIBLE
                    arrow_home.visibility = View.INVISIBLE
                    arrow_away.visibility = View.INVISIBLE

                    tv_fav_match_info.text = resources.getString(R.string.next)
                    tv_fav_match_info.setTextColor(Color.parseColor("#ff7979"))

                } else if (event.intHomeScore == event.intAwayScore) {
                    arrow_home.visibility = View.INVISIBLE
                    arrow_away.visibility = View.INVISIBLE

                } else if (event.intHomeScore!! > event.intAwayScore!!) {
                    tv_team_home.setTypeface(tv_team_home.typeface, Typeface.BOLD)
                    tv_score_home.setTypeface(tv_score_home.typeface, Typeface.BOLD)
                    arrow_away.visibility = View.INVISIBLE

                } else {
                    tv_team_away.setTypeface(tv_team_away.typeface, Typeface.BOLD)
                    tv_score_away.setTypeface(tv_score_away.typeface, Typeface.BOLD)
                    arrow_home.visibility = View.INVISIBLE
                }

                itemView.setOnClickListener {
                    context.startActivity<DetailEventActivity>(EXTRA_EVENT to event)
                }
            }
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchEventViewHolder {
        return SearchEventViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_event_search,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: SearchEventViewHolder, position: Int) {
        if (events[position].strSport == "Soccer") {
            holder.bindItems(events[position])
        }
    }
}

@SuppressLint("SimpleDateFormat")
private fun toGMTFormat(date: String?): Date? {
    val convert = SimpleDateFormat("yyyy-MM-dd")
    convert.timeZone = TimeZone.getTimeZone("UTC")
    val dateTime = "$date"
    return convert.parse(dateTime)
}