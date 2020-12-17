package com.hellohasan.mvvm_dagger.di.modules

import com.hellohasan.mvvm_dagger.di.annotation.FragmentScope
import com.hellohasan.mvvm_dagger.ui.student.student_creation.StudentCreateDialogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindStudentCreateFragment(): StudentCreateDialogFragment
}