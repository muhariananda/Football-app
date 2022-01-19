package com.aria.footballapp.ui.table

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aria.footballapp.R
import com.aria.footballapp.data.source.local.entity.TableEntity
import kotlinx.android.synthetic.main.list_table_standing.view.*

class TableAdapter :
    RecyclerView.Adapter<TableAdapter.TableViewHolder>() {

    private val table: MutableList<TableEntity> = ArrayList()

    class TableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(tableEntity: TableEntity, position: Int) {
            with(itemView) {
                tv_position.text = (position + 1).toString()
                tv_club.text = tableEntity.name
                tv_played.text = tableEntity.played.toString()
                tv_win.text = tableEntity.win.toString()
                tv_draw.text = tableEntity.draw.toString()
                tv_lose.text = tableEntity.draw.toString()
                tv_goals_for.text = tableEntity.goalsfor.toString()
                tv_goals_against.text = tableEntity.goalsagainst.toString()
                tv_goals_difference.text = tableEntity.goalsdifference.toString()
                tv_total.text = tableEntity.total.toString()
            }
        }
    }

    fun setList(table: List<TableEntity>) {
        this.table.clear()
        this.table.addAll(table)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        return TableViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_table_standing,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return table.size
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        holder.bindItems(table[position], position)
    }
}