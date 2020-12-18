package com.hellohasan.mvvm_dagger.di.modules

import com.hellohasan.mvvm_dagger.data.repository.client_ip.IpInfoRepository
import com.hellohasan.mvvm_dagger.data.repository.client_ip.IpInfoRepositoryImpl
import com.hellohasan.mvvm_dagger.data.repository.student.StudentRepository
import com.hellohasan.mvvm_dagger.data.repository.student.StudentRepositoryImpl
import com.hellohasan.mvvm_dagger.data.repository.subject.SubjectRepository
import com.hellohasan.mvvm_dagger.data.repository.subject.SubjectRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindIpRepository(ipInfoRepositoryImpl: IpInfoRepositoryImpl): IpInfoRepository

    @Binds
    abstract fun bindStudentRepository(studentRepositoryImpl: StudentRepositoryImpl): StudentRepository

    @Binds
    abstract fun bindSubjectRepository(subjectRepositoryImpl: SubjectRepositoryImpl): SubjectRepository
}