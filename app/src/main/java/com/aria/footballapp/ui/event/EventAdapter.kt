package com.aria.footballapp.ui.event

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aria.footballapp.R
import com.aria.footballapp.data.source.local.entity.EventsEntity
import com.aria.footballapp.ui.event.DetailEventActivity.Companion.EXTRA_EVENT
import kotlinx.android.synthetic.main.list_event.view.*
import org.jetbrains.anko.startActivity
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class EventAdapter :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    private val events: MutableList<EventsEntity> = ArrayList()

    fun setList(items: List<EventsEntity>) {
        this.events.clear()
        this.events.addAll(items)
    }

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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

                if (event.intHomeScore == null && event.intAwayScore == null) {
                    tv_score_home.visibility = View.INVISIBLE
                    tv_score_away.visibility = View.INVISIBLE

                    arrow_home.visibility = View.INVISIBLE
                    arrow_away.visibility = View.INVISIBLE

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

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventViewHolder {
        return EventViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_event,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(events[position])
    }

}

@SuppressLint("SimpleDateFormat")
private fun toGMTFormat(date: String?, time: String?): Date {
    val convert = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    convert.timeZone = TimeZone.getTimeZone("UTC")
    val dateTime = "$date $time"
    return convert.parse(dateTime)
}