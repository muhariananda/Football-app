package com.aria.footballapp.ui.team

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aria.footballapp.R
import com.aria.footballapp.data.source.local.entity.TeamsEntity
import com.aria.footballapp.ui.team.DetailTeamActivity.Companion.EXTRA_TEAM
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_teams.view.*
import org.jetbrains.anko.startActivity

class TeamAdapter :
    RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    private val teams: MutableList<TeamsEntity> = ArrayList()

    class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(team: TeamsEntity) {
            with(itemView) {
                tv_team_item_name.text = team.strTeam
                Picasso.get().load(team.strTeamBadge).fit().into(img_team_item_badge)

                itemView.setOnClickListener {
                    context.startActivity<DetailTeamActivity>(EXTRA_TEAM to team)
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
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_teams,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return teams.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(teams[position])
    }
}