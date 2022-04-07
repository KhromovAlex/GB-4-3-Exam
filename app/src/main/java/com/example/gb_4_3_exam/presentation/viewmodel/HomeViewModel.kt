package com.example.gb_4_3_exam.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gb_4_3_exam.domain.entity.Homework
import com.example.gb_4_3_exam.domain.entity.Lesson
import com.example.gb_4_3_exam.domain.repository.DataRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class HomeViewModel(
    private val dataRepository: DataRepository,
) : ViewModel() {
    private val disposables = CompositeDisposable()
    private val _liveDataLessons = MutableLiveData<List<Lesson>>()
    val liveDataLessons: LiveData<List<Lesson>> = _liveDataLessons
    private val _liveDataHomeworks = MutableLiveData<List<Homework>>()
    val liveDataHomeworks: LiveData<List<Homework>> = _liveDataHomeworks
    private val _liveDataDeadlinesExam = MutableLiveData<Long>()
    val liveDataDeadlinesExam: LiveData<Long> = _liveDataDeadlinesExam

    fun watchLessons() {
        disposables += dataRepository.watchLessons()
            .subscribeOn(Schedulers.io())
            .subscribe {
                _liveDataLessons.postValue(it)
            }
    }

    fun watchHomeworks() {
        disposables += dataRepository.watchHomeworks()
            .subscribeOn(Schedulers.io())
            .subscribe {
                _liveDataHomeworks.postValue(it)
            }
    }

    fun watchDeadlinesExam() {
        disposables += dataRepository.watchDurationDateExam()
            .subscribeOn(Schedulers.io())
            .subscribe {
                _liveDataDeadlinesExam.postValue(it)
            }
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
