package com.example.gb_4_3_exam.domain.repository

import com.example.gb_4_3_exam.domain.entity.Homework
import com.example.gb_4_3_exam.domain.entity.Lesson
import io.reactivex.rxjava3.core.Observable

interface DataRepository {
    fun watchHomeworks(): Observable<List<Homework>>
    fun watchLessons(): Observable<List<Lesson>>
    fun watchDurationDateExam(): Observable<Long>
}
