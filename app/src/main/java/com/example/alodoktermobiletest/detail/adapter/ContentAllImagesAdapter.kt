package com.example.alodoktermobiletest.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alodoktermobiletest.R
import kotlinx.android.synthetic.main.row_single_big_image.view.*

class ContentAllImagesAdapter(private var listAllImages: MutableList<Int>) :
    RecyclerView.Adapter<ContentAllImagesAdapter.ContentAllImagesHolder>() {

    class ContentAllImagesHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image = view.image_view_detail
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentAllImagesHolder {
        return ContentAllImagesHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_single_big_image, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listAllImages.size
    }

    override fun onBindViewHolder(holder: ContentAllImagesHolder, position: Int) {
        holder.image.setImageResource(listAllImages[position])
    }

    fun setData(newData: MutableList<Int>) {
        this.listAllImages = newData
        notifyDataSetChanged()
    }
}