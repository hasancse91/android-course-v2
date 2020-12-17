package com.hellohasan.mvvm_dagger.di.builders

import com.hellohasan.mvvm_dagger.di.annotation.FragmentScope
import com.hellohasan.mvvm_dagger.ui.student.student_creation.view.StudentCreateDialogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindStudentCreateFragment(): StudentCreateDialogFragment
}