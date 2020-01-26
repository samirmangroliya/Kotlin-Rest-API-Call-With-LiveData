package com.zt.androidrecylceview.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.zt.androidrecylceview.apirequest.EmployeeRepository
import com.zt.androidrecylceview.model.Employee
import java.util.ArrayList

class MainViewModel(application: Application) :
    AndroidViewModel(application) {
    private val employeeRepository: EmployeeRepository

    val allEmployee: MutableLiveData<ArrayList<Employee>> get() = employeeRepository.getMutableLiveData()

    init {
        employeeRepository = EmployeeRepository()
    }
}