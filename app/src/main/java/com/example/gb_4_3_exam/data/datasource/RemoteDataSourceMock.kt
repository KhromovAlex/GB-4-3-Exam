package com.example.gb_4_3_exam.data.datasource

import com.example.gb_4_3_exam.domain.entity.Homework
import com.example.gb_4_3_exam.domain.entity.Lesson
import java.util.*

class RemoteDataSourceMock : RemoteDataSource {
    override fun getLessons(): List<Lesson> {
        val currentTime: Date = Calendar.getInstance().time
        val durationLesson = 27000000L

        return listOf(
            Lesson(
                id = "1",
                subject = "Русский язык",
                dateStart = currentTime,
                dateEnd = Date(currentTime.time + durationLesson),
                isRequired = true,
            ),
            Lesson(
                id = "2",
                subject = "Литература",
                dateStart = Date(currentTime.time + durationLesson * 2),
                dateEnd = Date(currentTime.time + durationLesson * 3),
                isRequired = true,
            ),
            Lesson(
                id = "3",
                subject = "Физика",
                dateStart = Date(currentTime.time + durationLesson * 4),
                dateEnd = Date(currentTime.time + durationLesson * 5),
                isRequired = true,
            ),
            Lesson(
                id = "4",
                subject = "Право",
                dateStart = Date(currentTime.time + durationLesson * 6),
                dateEnd = Date(currentTime.time + durationLesson * 7),
                isRequired = false,
            ),
            Lesson(
                id = "5",
                subject = "Психология",
                dateStart = Date(currentTime.time + durationLesson * 8),
                dateEnd = Date(currentTime.time + durationLesson * 9),
                isRequired = false,
            ),
        )
    }

    override fun getHomeWorks(): List<Homework> =
        listOf(
            Homework(
                id = "1",
                description = "Написать сочинение на тему...",
                subject = "Русский язык",
                deadline = Date(1651543200000),
            ),
            Homework(
                id = "2",
                description = "Прочитать войну и мир",
                subject = "Литература",
                deadline = Date(1651456800000),
            ),
            Homework(
                id = "3",
                description = "Решить задачи по...",
                subject = "Физика",
                deadline = Date(1651683600000),
            ),
        )

    override fun getDateExam(): Date = Date(1651683600000)
}
