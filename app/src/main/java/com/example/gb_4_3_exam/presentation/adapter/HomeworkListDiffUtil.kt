package com.example.gb_4_3_exam.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.gb_4_3_exam.domain.entity.Homework

class HomeworkListDiffUtil(
    private val oldList: List<Homework>,
    private val newList: List<Homework>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
