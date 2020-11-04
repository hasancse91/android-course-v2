package com.hellohasan.fragment_navigation_drawer.feature.student_list.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hellohasan.fragment_navigation_drawer.R
import kotlinx.android.synthetic.main.fragment_student_list.*

class StudentListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {

            val direction = StudentListFragmentDirections.navigateToStudentDetails(106)
            findNavController().navigate(direction)

//            val direction = StudentListFragmentDirections.navigateToLogin()
//            findNavController().navigate(direction)

        }
    }
}