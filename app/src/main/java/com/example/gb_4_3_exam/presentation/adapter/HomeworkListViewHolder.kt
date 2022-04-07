package com.example.gb_4_3_exam.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.gb_4_3_exam.R
import com.example.gb_4_3_exam.domain.entity.Homework
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class HomeworkListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var title: TextView = itemView.findViewById(R.id.title)
    private var date: TextView = itemView.findViewById(R.id.date)
    private var description: TextView = itemView.findViewById(R.id.description)
    var formatter = SimpleDateFormat("dd-MMMM-yyyy HH:mm", Locale.ENGLISH)

    fun bind(homework: Homework) {
        title.text = homework.subject
        date.text = formatter.format(homework.deadline)
        description.text = homework.description
    }
}
