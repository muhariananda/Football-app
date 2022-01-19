package com.aria.footballapp.ui.team

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aria.footballapp.R
import com.aria.footballapp.data.source.local.entity.TeamsEntity
import com.aria.footballapp.ui.team.DetailTeamActivity.Companion.EXTRA_TEAM
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_teams_favorite.view.*
import org.jetbrains.anko.startActivity

class TeamSearchAdapter :
    RecyclerView.Adapter<TeamSearchAdapter.TeamViewHolder>() {

    private val teams: MutableList<TeamsEntity> = ArrayList()

    class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(teamsEntity: TeamsEntity) {
            with(itemView) {
                tv_team.text = teamsEntity.strTeam
                tv_team_description.text = teamsEntity.strDescriptionEN
                Picasso.get().load(teamsEntity.strTeamBadge).fit().into(img_team_badge)

                itemView.setOnClickListener {
                    context.startActivity<DetailTeamActivity>(EXTRA_TEAM to teamsEntity)
                }
            }
        }
    }

    fun setList(items: List<TeamsEntity>) {
        this.teams.clear()
        this.teams.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_teams_favorite, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return teams.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(teams[position])
    }
}