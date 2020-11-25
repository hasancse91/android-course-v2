package com.hellohasan.sqlite.ui.student_list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hellohasan.sqlite.R
import com.hellohasan.sqlite.data.model.student.Student
import com.orhanobut.logger.Logger

class StudentListAdapter(
    private val studentList: MutableList<Student>,
    private val clickListener: StudentListClickListener
) : RecyclerView.Adapter<StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]

        holder.nameTextView.text = student.name
        holder.registrationNumTextView.text = student.registrationNumber.toString()
        holder.phoneTextView.text = student.phoneNumber
        holder.emailTextView.text = student.email

        holder.btnEdit.setOnClickListener {
            clickListener.onEditButtonClicked(student.id)
        }

        holder.btnDelete.setOnClickListener {
            clickListener.onDeleteButtonClicked(student.id)
        }

        holder.itemView.setOnClickListener {
            // nothing to do. just added this listener for item click ripple effect
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
        fun onEditButtonClicked(studentId: Long)
        fun onDeleteButtonClicked(studentId: Long)
    }
}