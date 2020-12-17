package com.hellohasan.mvvm_dagger.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hellohasan.mvvm_dagger.core.AppViewModelFactory
import com.hellohasan.mvvm_dagger.di.annotation.ViewModelKey
import com.hellohasan.mvvm_dagger.ui.student.student_creation.viewmodel.StudentCreateViewModel
import com.hellohasan.mvvm_dagger.ui.student.student_list.viewmodel.StudentListViewModel
import com.hellohasan.mvvm_dagger.ui.student.student_update.viewmodel.StudentUpdateViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(StudentCreateViewModel::class)
    abstract fun bindStudentCreateViewModel(viewModel: StudentCreateViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(StudentListViewModel::class)
    abstract fun bindStudentListViewModel(viewModel: StudentListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(StudentUpdateViewModel::class)
    abstract fun bindStudentUpdateViewModel(viewModel: StudentUpdateViewModel): ViewModel
}