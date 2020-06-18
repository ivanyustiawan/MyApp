package com.example.alodoktermobiletest.home.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alodoktermobiletest.helper.Constants
import com.example.alodoktermobiletest.R
import com.example.alodoktermobiletest.detail.view.ContentDetailActivity
import com.example.alodoktermobiletest.home.model.ContentModelView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.row_single_image.view.*

class ContentAdapter(private var listContent: MutableList<ContentModelView>) :
    RecyclerView.Adapter<ContentAdapter.ContentHolder>() {

    private lateinit var context: Context

    class ContentHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image = view.image_view_content
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentHolder {
        this.context = parent.context
        return ContentHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_single_image, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listContent.size
    }

    override fun onBindViewHolder(holder: ContentHolder, position: Int) {
        holder.image.setImageResource(listContent[position].listImage[0])
        holder.image.setOnClickListener {
            val gson = Gson()
            val json = gson.toJson(listContent[position].listImage)
            val bundle = Bundle()
            bundle.putString(Constants.EXTRA_CONTENT_DETAIL, json)
            ContentDetailActivity.startThisActivity(context, bundle)
        }
    }

    fun setData(newData: MutableList<ContentModelView>) {
        this.listContent = newData
        notifyDataSetChanged()
    }

}