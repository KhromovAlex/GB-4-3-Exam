package com.example.gb_4_3_exam.data.repository

import com.example.gb_4_3_exam.data.datasource.RemoteDataSource
import com.example.gb_4_3_exam.domain.entity.Homework
import com.example.gb_4_3_exam.domain.entity.Lesson
import com.example.gb_4_3_exam.domain.repository.DataRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.Calendar
import java.util.Date
import java.util.concurrent.TimeUnit

class DataRepositoryImpl(
    val remoteDataSource: RemoteDataSource
) : DataRepository {
    var dateExam: Date = remoteDataSource.getDateExam()

    override fun watchHomeworks(): Observable<List<Homework>> {
        return BehaviorSubject.createDefault(remoteDataSource.getHomeWorks())
    }

    override fun watchLessons(): Observable<List<Lesson>> {
        return BehaviorSubject.createDefault(remoteDataSource.getLessons())
    }

    override fun watchDurationDateExam(): Observable<Long> {
        return BehaviorSubject.interval(1L, TimeUnit.SECONDS)
            .map {
                val currentTime: Date = Calendar.getInstance().time
                if (currentTime.after(dateExam)) 0L else dateExam.time - currentTime.time
            }
    }
}
