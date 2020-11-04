package com.hellohasan.fragment_navigation_drawer.feature.student_details.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.hellohasan.fragment_navigation_drawer.R
import kotlinx.android.synthetic.main.fragment_student_details.*


class StudentDetailsFragment : Fragment() {

    private val args: StudentDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val studentId = args

        tv_student_id.text = "Show here details of Student ID:\n\n $studentId"
    }
}