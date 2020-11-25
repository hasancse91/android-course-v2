package com.hellohasan.sqlite.ui.student_creation.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.hellohasan.sqlite.R
import com.hellohasan.sqlite.data.db.StudentDataSetChangeListener
import com.hellohasan.sqlite.data.model.student.Student
import com.hellohasan.sqlite.data.model.student.StudentModelImpl
import com.hellohasan.sqlite.ui.student_creation.viewmodel.StudentCreateViewModel
import com.hellohasan.sqlite.ui.student_creation.viewmodel.StudentCreateViewModelFactory
import kotlinx.android.synthetic.main.fragment_student_create_dialog.*

class StudentCreateDialogFragment : DialogFragment() {

    private val model by lazy { StudentModelImpl(requireContext().applicationContext) }
    private val viewModel by lazy {
        val factory = StudentCreateViewModelFactory(model)
        ViewModelProvider(this, factory).get(StudentCreateViewModel::class.java)
    }
    private lateinit var studentDataSetChangeListener: StudentDataSetChangeListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is StudentDataSetChangeListener) {
            studentDataSetChangeListener = context
        } else
            throw ClassCastException("Caller class must implement StudentCrudListener interface")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_create_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog?.setTitle(getString(R.string.title_create_student))

        createButton.setOnClickListener {
            val name = studentNameEditText.text.toString()
            val registrationNumber = registrationEditText.text.toString()
            val phoneNumber = phoneEditText.text.toString()
            val email = emailEditText.text.toString()

            if (name.isEmpty() || registrationNumber.isEmpty() || phoneNumber.isEmpty() || email.isEmpty()) {
                Toast.makeText(requireContext(), "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val student = Student(
                name = name,
                registrationNumber = registrationNumber.toLong(),
                phoneNumber = phoneNumber,
                email = email
            )

            viewModel.createStudent(student)
        }

        cancelButton.setOnClickListener {
            dismiss()
        }

        viewModel.studentCreationSuccessLiveData.observe(viewLifecycleOwner, {
            studentDataSetChangeListener.onStudentDataChanged()
            dismiss()
        })

        viewModel.studentCreationFailedLiveData.observe(viewLifecycleOwner, {
            studentDataSetChangeListener.onStudentDataSetChangeError(it)
        })
    }

    override fun onStart() {
        super.onStart()

        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.WRAP_CONTENT

        dialog?.window?.setLayout(width, height)
    }
}