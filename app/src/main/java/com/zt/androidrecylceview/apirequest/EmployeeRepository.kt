package com.zt.androidrecylceview.apirequest

import androidx.lifecycle.MutableLiveData
import com.zt.androidrecylceview.model.Employee
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class EmployeeRepository {
    private var employees = ArrayList<Employee>()
    private val mutableLiveData =
        MutableLiveData<ArrayList<Employee>>()

    fun getMutableLiveData(): MutableLiveData<ArrayList<Employee>> {
        try {
            val userDataService = RetrofitClient.service
            val call = userDataService.employees
            call!!.enqueue(object : Callback<List<Employee>> {
                override fun onResponse(
                    call: Call<List<Employee>>,
                    response: Response<List<Employee>>
                ) {
                    val employeeDBResponse = response.body()
                    if (employeeDBResponse != null) {
                        employees = employeeDBResponse as ArrayList<Employee>
                        mutableLiveData.value = employees
                    }
                }

                override fun onFailure(
                    call: Call<List<Employee>>,
                    t: Throwable
                ) {

                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return mutableLiveData
    }

    companion object {
        private const val TAG = "EmployeeRepository"
    }
}