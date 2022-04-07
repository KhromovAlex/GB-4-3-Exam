package com.example.gb_4_3_exam.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import com.example.gb_4_3_exam.R
import com.example.gb_4_3_exam.domain.entity.Lesson
import java.text.SimpleDateFormat
import java.util.*

class LessonListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var root: ConstraintLayout = itemView.findViewById(R.id.root)
    private var title: TextView = itemView.findViewById(R.id.title)
    private var dateStart: TextView = itemView.findViewById(R.id.dateStart)
    private var dateEnd: TextView = itemView.findViewById(R.id.dateEnd)
    var formatter = SimpleDateFormat("dd-MMMM HH:mm", Locale.ENGLISH)

    fun bind(lesson: Lesson) {
        val bg = if (lesson.isRequired) ContextCompat.getDrawable(
            itemView.context,
            R.drawable.black_with_radius_bg
        ) else ContextCompat.getDrawable(itemView.context, R.drawable.teel_with_radius_bg)
        root.background = bg
        title.text = lesson.subject
        dateStart.text = formatter.format(lesson.dateStart)
        dateEnd.text = formatter.format(lesson.dateEnd)
    }
}
