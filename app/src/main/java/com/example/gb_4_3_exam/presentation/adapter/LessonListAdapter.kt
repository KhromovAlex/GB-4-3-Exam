package com.example.gb_4_3_exam.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gb_4_3_exam.R
import com.example.gb_4_3_exam.domain.entity.Lesson

class LessonListAdapter :
    RecyclerView.Adapter<LessonListViewHolder>() {
    private val list: MutableList<Lesson> = mutableListOf()

    fun submitList(newList: List<Lesson>) {
        val callback =
            LessonListDiffUtil(
                list,
                newList
            )
        val result = DiffUtil.calculateDiff(callback)
        list.clear()
        list.addAll(newList)
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonListViewHolder {
        val rootView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.lesson_item_list,
            parent,
            false
        )
        return LessonListViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: LessonListViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.tag = list[position]
    }

    override fun getItemCount(): Int = list.size

}
