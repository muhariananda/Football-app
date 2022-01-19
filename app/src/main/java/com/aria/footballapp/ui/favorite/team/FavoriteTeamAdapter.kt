package com.aria.footballapp.ui.favorite.team

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aria.footballapp.R
import com.aria.footballapp.data.source.local.entity.TeamsEntity
import com.aria.footballapp.ui.team.DetailTeamActivity
import com.aria.footballapp.ui.team.DetailTeamActivity.Companion.EXTRA_TEAM
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_teams_favorite.view.*
import org.jetbrains.anko.startActivity

class FavoriteTeamAdapter :
    PagedListAdapter<TeamsEntity, FavoriteTeamAdapter.TeamViewHolder>(
        DIFF_CALLBACK
    ) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TeamsEntity>() {
            override fun areItemsTheSame(oldItem: TeamsEntity, newItem: TeamsEntity): Boolean {
                return oldItem.idTeam == newItem.idTeam
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: TeamsEntity, newItem: TeamsEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TeamViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_teams_favorite, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val teams = getItem(position) as TeamsEntity
        holder.bind(teams)
    }

    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(team: TeamsEntity) {
            with(itemView) {
                tv_team.text = team.strTeam
                tv_team_description.text = team.strDescriptionEN
                Picasso.get().load(team.strTeamBadge).fit().into(img_team_badge)

                itemView.setOnClickListener {
                    context.startActivity<DetailTeamActivity>(EXTRA_TEAM to team)
                }
            }
        }
    }
}