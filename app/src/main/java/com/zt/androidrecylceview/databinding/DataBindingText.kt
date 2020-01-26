package com.zt.androidrecylceview.databinding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zt.androidrecylceview.R
import com.zt.androidrecylceview.model.Employee

class DataBindingText {
    companion object {
        @JvmStatic
        @BindingAdapter("url")
        fun loadImage(imageView: ImageView, imageURL: String?) {
            try {
                Glide.with(imageView.context)
                    .setDefaultRequestOptions(
                        RequestOptions()
                            .circleCrop()
                    )
                    .load(imageURL)
                    .placeholder(R.drawable.loading)
                    .into(imageView)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        @JvmStatic
        @BindingAdapter("desc")
        fun setDesc(textView: TextView, employee: Employee) {
            try {

                var sb = StringBuilder()
                sb.append(employee.name)
                sb.append(" has three urls : ")
                sb.append(employee.data?.small)
                sb.append("\n")
                sb.append(employee.data?.medium)
                sb.append("\n")
                sb.append(employee.data?.large)

                textView.text = sb.toString()


            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}