package com.hellohasan.mvvm_dagger.ui.student.student_list.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.hellohasan.mvvm_dagger.R
import com.hellohasan.mvvm_dagger.core.BaseActivity
import com.hellohasan.mvvm_dagger.data.local.db.student.StudentDataSetChangeListener
import com.hellohasan.mvvm_dagger.data.repository.client_ip.IpInfoRepositoryImpl
import com.hellohasan.mvvm_dagger.data.repository.student.Student
import com.hellohasan.mvvm_dagger.data.repository.student.StudentRepositoryImpl
import com.hellohasan.mvvm_dagger.databinding.ActivityStudentListBinding
import com.hellohasan.mvvm_dagger.ui.student.student_creation.view.StudentCreateDialogFragment
import com.hellohasan.mvvm_dagger.ui.student.student_list.viewmodel.StudentListViewModel
import com.hellohasan.mvvm_dagger.ui.student.student_list.viewmodel.StudentListViewModelFactory
import com.hellohasan.mvvm_dagger.ui.subject.subject_list.SubjectListActivity
import com.hellohasan.mvvm_dagger.utils.CREATE_STUDENT
import com.hellohasan.mvvm_dagger.utils.STUDENT_REGISTRATION

class StudentListActivity : BaseActivity<StudentListViewModel>(), StudentDataSetChangeListener {

    private lateinit var binding: ActivityStudentListBinding

    private val studentList by lazy { mutableListOf<Student>()  }
    private val studentListAdapter by lazy {
        StudentListAdapter(studentList, object : StudentListAdapter.StudentListClickListener{
            override fun onItemClicked(registrationNumber: Long) {
                showSubjectListActivity(registrationNumber)
            }

            override fun onEditButtonClicked(student: Student) {
                showStudentEditDialog(student)
            }

            override fun onDeleteButtonClicked(student: Student) {
                showStudentDeleteDialog(student)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarLayout.toolbar.title = getString(R.string.app_name)

        initRecyclerView()

        viewModel.getIpInfo()
        viewModel.getStudentList()

        viewModel.ipInfoLiveData.observe(this, {
            binding.tvIpInfo.text = it
        })

        viewModel.studentListLiveData.observe(this, {
            studentListAdapter.replaceData(it)
        })

        viewModel.studentListFailedLiveData.observe(this, {
            showToast(it)
        })

        viewModel.studentDeletionSuccessLiveData.observe(this, {
            viewModel.getStudentList()
            showToast("$it item is deleted")
        })

        viewModel.studentDeletionFailedLiveData.observe(this, {
            showToast(it)
        })

        binding.btnAddStudent.setOnClickListener {
            showStudentCreationDialog()
        }

    }

    override fun onStudentDataChanged() {
        viewModel.getStudentList()
    }

    override fun onStudentDataSetChangeError(error: String) {
        showToast(error)
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = studentListAdapter
    }

    private fun showStudentCreationDialog() {

        val dialogFragment = StudentCreateDialogFragment()
        dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog)

        dialogFragment.show(supportFragmentManager, CREATE_STUDENT)
    }

    private fun showStudentEditDialog(studentId: Student) {
        showToast(studentId.toString())
    }

    private fun showStudentDeleteDialog(studentId: Student) {
        var dialog: AlertDialog? = null

        dialog = MaterialAlertDialogBuilder(this)
            .setMessage(getString(R.string.student_delete_alert))
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                viewModel.deleteStudent(studentId)
            }
            .setNegativeButton(getString(R.string.no)) { _, _ ->
                dialog?.dismiss()
            }
            .show()
    }

    private fun showSubjectListActivity(registrationNumber: Long) {
        val bundle = Bundle()
        bundle.putLong(STUDENT_REGISTRATION, registrationNumber)
        val intent = Intent(this, SubjectListActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}