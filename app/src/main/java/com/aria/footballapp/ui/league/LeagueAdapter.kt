package com.aria.footballapp.ui.league

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aria.footballapp.R
import com.aria.footballapp.data.source.local.entity.LeaguesEntity
import com.aria.footballapp.ui.league.DetailLeagueActivity.Companion.EXTRA_LEAGUE
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_league.view.*
import org.jetbrains.anko.startActivity

class LeagueAdapter :
    RecyclerView.Adapter<LeagueAdapter.HomeViewHolder>() {

    private val items: MutableList<LeaguesEntity> = ArrayList()
    fun setList(items: List<LeaguesEntity>) {
        this.items.clear()
        this.items.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_league,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(items: LeaguesEntity) {
            with(itemView) {
                tv_item_league_name.text = items.strLeague
                tv_item_information.text = items.strDescriptionEN

                Picasso.get().load(items.strBadge).fit().into(img_item_league)

                itemView.setOnClickListener {
                    context.startActivity<DetailLeagueActivity>(EXTRA_LEAGUE to items)
                }
            }
        }
    }

}