package com.zt.androidrecylceview.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.zt.androidrecylceview.R
import com.zt.androidrecylceview.adapter.EmployeeDataAdapter
import com.zt.androidrecylceview.databinding.ActivityMainBinding
import com.zt.androidrecylceview.model.Employee
import com.zt.androidrecylceview.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    lateinit var employeeDataAdapter: EmployeeDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        setSupportActionBar(toolbar)

        try {
            mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
            employeeDataAdapter = EmployeeDataAdapter(this)

            mainBinding.recycleviewemployee.layoutManager = LinearLayoutManager(this)
            mainBinding.recycleviewemployee.setHasFixedSize(true)

            mainBinding.recycleviewemployee.adapter = employeeDataAdapter


            getAllEmployee()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getAllEmployee() {
        try {
            mainBinding.progressBar.visibility = View.VISIBLE
            employeeDataAdapter.setEmployeeList(ArrayList<Employee>())


            mainViewModel?.allEmployee?.observe(this, Observer {
                mainBinding.progressBar.visibility = View.GONE

                //sorted with name
                val sortedList = it?.sortedWith(compareBy{it.name})
                employeeDataAdapter.setEmployeeList(sortedList)
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    fun clickOnItem(employee: Employee) {
        print("click on item")
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("employee", employee)
        startActivity(intent)
    }
}
