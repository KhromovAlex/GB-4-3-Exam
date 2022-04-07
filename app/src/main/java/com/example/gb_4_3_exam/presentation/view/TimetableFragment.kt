package com.example.gb_4_3_exam.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gb_4_3_exam.R
import com.example.gb_4_3_exam.databinding.FragmentTimetableBinding
import com.example.gb_4_3_exam.domain.entity.Lesson
import com.example.gb_4_3_exam.presentation.adapter.LessonListAdapter
import com.example.gb_4_3_exam.presentation.viewmodel.TimetableViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TimetableFragment : Fragment() {
    private var _binding: FragmentTimetableBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TimetableViewModel by viewModel()
    private val lessonListAdapter = LessonListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTimetableBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lessonList.layoutManager = LinearLayoutManager(requireContext())
        binding.lessonList.adapter = lessonListAdapter
        viewModel.watchLessons()
        viewModel.liveDataLessons.observe(viewLifecycleOwner, ::renderLessons)
    }

    private fun renderLessons(list: List<Lesson>) {
        lessonListAdapter.submitList(list)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
