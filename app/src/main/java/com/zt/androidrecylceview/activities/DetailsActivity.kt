package com.zt.androidrecylceview.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.zt.androidrecylceview.R
import com.zt.androidrecylceview.databinding.ActivityDetailsBinding
import com.zt.androidrecylceview.model.Employee
import kotlinx.android.synthetic.main.activity_main.*

class DetailsActivity : AppCompatActivity() {

    lateinit var detailBinding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_details
        )
        setSupportActionBar(toolbar)

        try {

            detailBinding.activityDetail = this

            val employee = intent.extras?.getSerializable("employee") as Employee

            employee?.let {
                detailBinding.employee = it
                supportActionBar?.title = it.name
            }

            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

}
