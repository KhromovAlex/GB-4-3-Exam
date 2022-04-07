package com.example.gb_4_3_exam.domain.entity

import java.util.*

data class Homework(
    val id: String,
    val subject: String,
    val deadline: Date,
    val description: String
)
