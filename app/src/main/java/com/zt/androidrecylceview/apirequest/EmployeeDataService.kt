package com.zt.androidrecylceview.apirequest

import com.zt.androidrecylceview.model.Employee
import retrofit2.Call
import retrofit2.http.GET

interface EmployeeDataService {
    @get:GET("json/glide.json") ADD YOUR ENDPOINT HERE
    val employees: Call<List<Employee>>?
}
