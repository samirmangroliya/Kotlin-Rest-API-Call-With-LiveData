package com.zt.androidrecylceview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zt.androidrecylceview.activities.MainActivity
import com.zt.androidrecylceview.R
import com.zt.androidrecylceview.adapter.EmployeeDataAdapter.EmployeeViewHolder
import com.zt.androidrecylceview.databinding.RowBinding
import com.zt.androidrecylceview.model.Employee

class EmployeeDataAdapter(val activity: MainActivity) : RecyclerView.Adapter<EmployeeViewHolder>() {
    private var employees: List<Employee>? = null
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): EmployeeViewHolder {
        val employeeListItemBinding = DataBindingUtil.inflate<RowBinding>(
            LayoutInflater.from(viewGroup.context),
            R.layout.row, viewGroup, false
        )
        return EmployeeViewHolder(employeeListItemBinding)
    }

    override fun onBindViewHolder(employeeViewHolder: EmployeeViewHolder,i: Int) {
        val currentStudent = employees!![i]

        employeeViewHolder.employeeListItemBinding.mainActivity= activity
        employeeViewHolder.employeeListItemBinding.employee = currentStudent
    }

    override fun getItemCount(): Int {
        return if (employees != null) {
            employees!!.size
        } else {
            0
        }
    }

    fun setEmployeeList(employees: List<Employee>?) {
        this.employees = employees
        notifyDataSetChanged()
    }

    inner class EmployeeViewHolder(val employeeListItemBinding: RowBinding) :
        RecyclerView.ViewHolder(employeeListItemBinding.root)
}