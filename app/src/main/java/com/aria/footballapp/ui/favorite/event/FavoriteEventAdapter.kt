package com.aria.footballapp.ui.favorite.event

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aria.footballapp.R
import com.aria.footballapp.data.source.local.entity.EventsEntity
import com.aria.footballapp.ui.event.DetailEventActivity
import com.aria.footballapp.ui.event.DetailEventActivity.Companion.EXTRA_EVENT
import kotlinx.android.synthetic.main.list_event.view.arrow_away
import kotlinx.android.synthetic.main.list_event.view.arrow_home
import kotlinx.android.synthetic.main.list_event.view.tv_next_date
import kotlinx.android.synthetic.main.list_event.view.tv_next_time
import kotlinx.android.synthetic.main.list_event.view.tv_score_away
import kotlinx.android.synthetic.main.list_event.view.tv_score_home
import kotlinx.android.synthetic.main.list_event.view.tv_team_away
import kotlinx.android.synthetic.main.list_event.view.tv_team_home
import kotlinx.android.synthetic.main.list_event_favorite.view.*
import org.jetbrains.anko.startActivity
import java.text.SimpleDateFormat
import java.util.*

class FavoriteEventAdapter :
    PagedListAdapter<EventsEntity, FavoriteEventAdapter.EventViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<EventsEntity>() {
            override fun areItemsTheSame(oldItem: EventsEntity, newItem: EventsEntity): Boolean {
                return oldItem.idEvent == newItem.idEvent
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: EventsEntity, newItem: EventsEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_event_favorite, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = getItem(position) as EventsEntity
        holder.bind(event)
    }

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SimpleDateFormat")
        fun bind(event: EventsEntity) {

            val timeConvert = toGMTFormat(event.dateEvent, event.strTime)
            val formatDate = SimpleDateFormat("E, dd/MM")
            val formatTime = SimpleDateFormat("HH:mm")
            val date = formatDate.format(timeConvert)
            val time = formatTime.format(timeConvert)

            with(itemView) {
                tv_team_home.text = event.strHomeTeam
                tv_team_away.text = event.strAwayTeam
                tv_score_home.text = event.intHomeScore
                tv_score_away.text = event.intAwayScore
                tv_next_date.text = date
                tv_next_time.text = time

                tv_fav_match_info.text = resources.getString(R.string.last)
                tv_fav_match_info.setTextColor(Color.parseColor("#2ecc71"))

                if (event.intHomeScore == null && event.intAwayScore == null) {
                    tv_score_home.text = "-"
                    tv_score_away.text = "-"

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
                    tv_score_away.setTypeface(tv_team_away.typeface, Typeface.BOLD)
                    arrow_home.visibility = View.INVISIBLE
                }

                itemView.setOnClickListener {
                    context.startActivity<DetailEventActivity>(EXTRA_EVENT to event)
                }
            }
        }
    }
}

@SuppressLint("SimpleDateFormat")
private fun toGMTFormat(date: String?, time: String?): Date {
    val convert = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    convert.timeZone = TimeZone.getTimeZone("UTC")
    val dateTime = "$date $time"
    return convert.parse(dateTime)
}