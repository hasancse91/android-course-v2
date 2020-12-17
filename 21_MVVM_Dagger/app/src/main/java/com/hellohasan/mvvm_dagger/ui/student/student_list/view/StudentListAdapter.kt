package com.hellohasan.mvvm_dagger.ui.student.student_list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hellohasan.mvvm_dagger.data.repository.student.Student
import com.hellohasan.mvvm_dagger.databinding.ItemStudentBinding

class StudentListAdapter(
    private val studentList: MutableList<Student>,
    private val clickListener: StudentListClickListener
) : RecyclerView.Adapter<StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]

        holder.nameTextView.text = student.name
        holder.registrationNumTextView.text = student.registrationNumber.toString()
        holder.phoneTextView.text = student.phoneNumber
        holder.emailTextView.text = student.email

        holder.btnEdit.setOnClickListener {
            clickListener.onEditButtonClicked(student)
        }

        holder.btnDelete.setOnClickListener {
            clickListener.onDeleteButtonClicked(student)
        }

        holder.itemView.setOnClickListener {
            clickListener.onItemClicked(student.registrationNumber)
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    fun replaceData(studentList: MutableList<Student>) {
        this.studentList.clear()
        this.studentList.addAll(studentList)
        notifyDataSetChanged()
    }

    interface StudentListClickListener {
        fun onItemClicked(registrationNumber: Long)
        fun onEditButtonClicked(student: Student)
        fun onDeleteButtonClicked(student: Student)
    }
}