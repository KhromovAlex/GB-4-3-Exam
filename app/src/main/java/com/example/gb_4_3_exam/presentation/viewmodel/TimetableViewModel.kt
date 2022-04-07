package com.example.gb_4_3_exam.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gb_4_3_exam.domain.entity.Lesson
import com.example.gb_4_3_exam.domain.repository.DataRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class TimetableViewModel(
    private val dataRepository: DataRepository,
) : ViewModel() {
    private val disposables = CompositeDisposable()
    private val _liveDataLessons = MutableLiveData<List<Lesson>>()
    val liveDataLessons: LiveData<List<Lesson>> = _liveDataLessons

    fun watchLessons() {
        disposables += dataRepository.watchLessons()
            .subscribeOn(Schedulers.io())
            .subscribe {
                _liveDataLessons.postValue(it)
            }
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
