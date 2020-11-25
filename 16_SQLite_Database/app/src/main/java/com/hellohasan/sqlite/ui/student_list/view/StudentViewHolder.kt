package com.hellohasan.sqlite.ui.student_list.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.item_student.view.*

class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val nameTextView = itemView.nameTextView as TextView
    val registrationNumTextView = itemView.registrationNumTextView as TextView
    val emailTextView = itemView.emailTextView as TextView
    val phoneTextView = itemView.phoneTextView as TextView
    val btnEdit = itemView.btnEdit as MaterialButton
    val btnDelete = itemView.btnDelete as MaterialButton
}