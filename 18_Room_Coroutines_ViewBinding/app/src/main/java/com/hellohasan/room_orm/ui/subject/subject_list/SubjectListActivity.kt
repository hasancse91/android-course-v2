package com.hellohasan.room_orm.ui.subject.subject_list

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.hellohasan.room_orm.core.BaseActivity
import com.hellohasan.room_orm.data.repository.subject.Subject
import com.hellohasan.room_orm.data.repository.subject.SubjectRepositoryImpl
import com.hellohasan.room_orm.databinding.ActivitySubjectListBinding
import com.hellohasan.room_orm.ui.subject.SubjectViewModel
import com.hellohasan.room_orm.ui.subject.SubjectViewModelFactory
import com.hellohasan.room_orm.utils.STUDENT_REGISTRATION

class SubjectListActivity : BaseActivity() {

    private lateinit var binding : ActivitySubjectListBinding
    private var studentRegistrationNumber: Long = -1

    private val repository by lazy { SubjectRepositoryImpl(applicationContext) }
    private val viewModel by lazy {
        val factory = SubjectViewModelFactory(repository)
        ViewModelProvider(this, factory).get(SubjectViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        studentRegistrationNumber = intent.extras?.getLong(STUDENT_REGISTRATION) ?: -1

        binding.btnAddSubject.setOnClickListener {
            createSubject()
        }

        viewModel.subjectCreationSuccessLiveData.observe(this, {
            showToast("Successfully subject is created")
        })

        viewModel.subjectCreationFailedLiveData.observe(this, {
            showToast(it)
        })
    }

    private fun createSubject() {

        viewModel.createSubject(
            Subject(
                registrationNumber = studentRegistrationNumber,
                name = "Programming Language C",
                code = 101,
                credit = 3.0F
            ),
            studentRegistrationNumber
        )
    }
}