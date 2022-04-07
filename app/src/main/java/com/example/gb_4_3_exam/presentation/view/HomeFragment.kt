package com.example.gb_4_3_exam.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gb_4_3_exam.R
import com.example.gb_4_3_exam.databinding.FragmentHomeBinding
import com.example.gb_4_3_exam.domain.entity.Homework
import com.example.gb_4_3_exam.domain.entity.Lesson
import com.example.gb_4_3_exam.presentation.adapter.HomeworkListAdapter
import com.example.gb_4_3_exam.presentation.adapter.LessonListAdapter
import com.example.gb_4_3_exam.presentation.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModel()
    private val lessonListAdapter = LessonListAdapter()
    private val homeworkListAdapter = HomeworkListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lessonList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.lessonList.adapter = lessonListAdapter
        binding.homeworkList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.homeworkList.adapter = homeworkListAdapter
        viewModel.watchDeadlinesExam()
        viewModel.watchHomeworks()
        viewModel.watchLessons()
        viewModel.liveDataDeadlinesExam.observe(viewLifecycleOwner, ::renderDeadline)
        viewModel.liveDataHomeworks.observe(viewLifecycleOwner, ::renderHomeworks)
        viewModel.liveDataLessons.observe(viewLifecycleOwner, ::renderLessons)
    }

    private fun renderLessons(list: List<Lesson>) {
        lessonListAdapter.submitList(list)
    }

    private fun renderHomeworks(list: List<Homework>) {
        homeworkListAdapter.submitList(list)
    }

    private fun renderDeadline(duration: Long) {
        val durationAsSeconds = duration / 1000.0
        val durationAsMinutes = durationAsSeconds / 60.0
        val durationAsHours = durationAsMinutes / 60.0
        val durationAsDays = durationAsHours / 24.0

        val days = durationAsDays.toInt()
        val hours = (durationAsDays - days) * 24.0
        val minutes = (hours - hours.toInt()) * 60.0
        val seconds = (minutes - minutes.toInt()) * 60
        binding.durationExam.text = getString(
            R.string.date_format_exam,
            days.toString().padStart(2, '0'),
            hours.toInt().toString().padStart(2, '0'),
            minutes.toInt().toString().padStart(2, '0'),
            seconds.toInt().toString().padStart(2, '0')
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
