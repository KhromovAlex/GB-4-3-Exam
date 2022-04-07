package com.example.gb_4_3_exam.data.datasource

import com.example.gb_4_3_exam.domain.entity.Homework
import com.example.gb_4_3_exam.domain.entity.Lesson
import java.util.*

interface RemoteDataSource {
    fun getLessons(): List<Lesson>
    fun getHomeWorks(): List<Homework>
    fun getDateExam(): Date
}
