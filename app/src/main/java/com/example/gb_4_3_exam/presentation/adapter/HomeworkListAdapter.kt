package com.example.gb_4_3_exam.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gb_4_3_exam.R
import com.example.gb_4_3_exam.domain.entity.Homework

class HomeworkListAdapter :
    RecyclerView.Adapter<HomeworkListViewHolder>() {
    private val list: MutableList<Homework> = mutableListOf()

    fun submitList(newList: List<Homework>) {
        val callback =
            HomeworkListDiffUtil(
                list,
                newList
            )
        val result = DiffUtil.calculateDiff(callback)
        list.clear()
        list.addAll(newList)
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeworkListViewHolder {
        val rootView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.homework_item_list,
            parent,
            false
        )
        return HomeworkListViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: HomeworkListViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.tag = list[position]
    }

    override fun getItemCount(): Int = list.size

}
