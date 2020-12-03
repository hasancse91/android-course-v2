package com.hellohasan.room_orm.ui.student.student_list.view

import androidx.recyclerview.widget.RecyclerView
import com.hellohasan.room_orm.databinding.ItemStudentBinding

class StudentViewHolder(binding: ItemStudentBinding) : RecyclerView.ViewHolder(binding.root) {

    val nameTextView = binding.nameTextView
    val registrationNumTextView = binding.registrationNumTextView
    val emailTextView = binding.emailTextView
    val phoneTextView = binding.phoneTextView
    val btnEdit = binding.btnEdit
    val btnDelete = binding.btnDelete
}