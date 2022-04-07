package com.example.gb_4_3_exam.domain.entity

import java.util.*

data class Lesson(
    val id: String,
    val subject: String,
    val dateStart: Date,
    val dateEnd: Date,
    val isRequired: Boolean
)
