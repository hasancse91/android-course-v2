package com.hellohasan.room_orm.ui.student_list.view

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.hellohasan.room_orm.R
import com.hellohasan.room_orm.core.BaseActivity
import com.hellohasan.room_orm.data.local.StudentDataSetChangeListener
import com.hellohasan.room_orm.data.repository.student.Student
import com.hellohasan.room_orm.data.repository.student.StudentRepositoryImpl
import com.hellohasan.room_orm.databinding.ActivityStudentListBinding
import com.hellohasan.room_orm.ui.student_creation.view.StudentCreateDialogFragment
import com.hellohasan.room_orm.ui.student_list.viewmodel.StudentListViewModel
import com.hellohasan.room_orm.ui.student_list.viewmodel.StudentListViewModelFactory
import com.hellohasan.room_orm.utils.CREATE_STUDENT
import com.orhanobut.logger.Logger

class StudentListActivity : BaseActivity(), StudentDataSetChangeListener {

    private lateinit var binding: ActivityStudentListBinding

    private val repository by lazy { StudentRepositoryImpl(applicationContext) }
    private val viewModel by lazy {
        val factory = StudentListViewModelFactory(repository)
        ViewModelProvider(this, factory).get(StudentListViewModel::class.java)
    }
    private val studentList by lazy { mutableListOf<Student>()  }
    private val studentListAdapter by lazy {
        StudentListAdapter(studentList, object : StudentListAdapter.StudentListClickListener{
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

        viewModel.getStudentList()

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
                viewModel.deleteStudentById(studentId)
            }
            .setNegativeButton(getString(R.string.no)) { _, _ ->
                dialog?.dismiss()
            }
            .show()
    }
}