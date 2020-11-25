package com.hellohasan.sqlite.ui.student_list.view

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.hellohasan.sqlite.R
import com.hellohasan.sqlite.core.BaseActivity
import com.hellohasan.sqlite.data.db.StudentDataSetChangeListener
import com.hellohasan.sqlite.data.model.student.Student
import com.hellohasan.sqlite.data.model.student.StudentModelImpl
import com.hellohasan.sqlite.ui.student_creation.view.StudentCreateDialogFragment
import com.hellohasan.sqlite.ui.student_list.viewmodel.StudentListViewModel
import com.hellohasan.sqlite.ui.student_list.viewmodel.StudentListViewModelFactory
import com.hellohasan.sqlite.utils.CREATE_STUDENT
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_student_list.*
import kotlinx.android.synthetic.main.toolbar.*

class StudentListActivity : BaseActivity(), StudentDataSetChangeListener {

    private val model by lazy { StudentModelImpl(applicationContext) }
    private val viewModel by lazy {
        val factory = StudentListViewModelFactory(model)
        ViewModelProvider(this, factory).get(StudentListViewModel::class.java)
    }
    private val studentList by lazy { mutableListOf<Student>()  }
    private val studentListAdapter by lazy {
        StudentListAdapter(studentList, object : StudentListAdapter.StudentListClickListener{
            override fun onEditButtonClicked(studentId: Long) {
                showStudentEditDialog(studentId)
            }

            override fun onDeleteButtonClicked(studentId: Long) {
                showStudentDeleteDialog(studentId)
            }
        })
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_student_list
    }

    override fun setToolbar(): Toolbar {
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        btn_add_student.setOnClickListener {
            showStudentCreationDialog()
        }

    }

    override fun onStudentDataChanged() {
        viewModel.getStudentList()
    }

    override fun onStudentDataSetChangeError(error: String) {
        showToast(error)

        Logger.e(error)
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = studentListAdapter
    }

    private fun showStudentCreationDialog() {

        val dialogFragment = StudentCreateDialogFragment()
        dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog)

        dialogFragment.show(supportFragmentManager, CREATE_STUDENT)
    }

    private fun showStudentEditDialog(studentId: Long) {
        showToast(studentId.toString())
    }

    private fun showStudentDeleteDialog(studentId: Long) {
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