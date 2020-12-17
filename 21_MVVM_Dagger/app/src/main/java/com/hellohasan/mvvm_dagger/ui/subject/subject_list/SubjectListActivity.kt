package com.hellohasan.mvvm_dagger.ui.subject.subject_list

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.hellohasan.mvvm_dagger.core.BaseActivity
import com.hellohasan.mvvm_dagger.data.repository.subject.Subject
import com.hellohasan.mvvm_dagger.data.repository.subject.SubjectRepositoryImpl
import com.hellohasan.mvvm_dagger.databinding.ActivitySubjectListBinding
import com.hellohasan.mvvm_dagger.ui.subject.SubjectViewModel
import com.hellohasan.mvvm_dagger.ui.subject.SubjectViewModelFactory
import com.hellohasan.mvvm_dagger.utils.STUDENT_REGISTRATION

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