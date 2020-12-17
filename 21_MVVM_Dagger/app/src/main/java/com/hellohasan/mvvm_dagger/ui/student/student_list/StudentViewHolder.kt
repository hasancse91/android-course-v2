package com.hellohasan.mvvm_dagger.ui.student.student_list

import androidx.recyclerview.widget.RecyclerView
import com.hellohasan.mvvm_dagger.databinding.ItemStudentBinding

class StudentViewHolder(binding: ItemStudentBinding) : RecyclerView.ViewHolder(binding.root) {

    val nameTextView = binding.nameTextView
    val registrationNumTextView = binding.registrationNumTextView
    val emailTextView = binding.emailTextView
    val phoneTextView = binding.phoneTextView
    val btnEdit = binding.btnEdit
    val btnDelete = binding.btnDelete
}