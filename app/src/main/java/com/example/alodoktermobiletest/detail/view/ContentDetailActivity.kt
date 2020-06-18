package com.example.alodoktermobiletest.detail.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.alodoktermobiletest.databinding.ActivityContentDetailBinding
import com.example.alodoktermobiletest.detail.adapter.CirclePagerIndicatorDecoration
import com.example.alodoktermobiletest.detail.adapter.ContentAllImagesAdapter

class ContentDetailActivity : AppCompatActivity(),
    ContentDetailInterface {

    companion object {
        fun startThisActivity(context: Context?, bundle: Bundle) {
            val intent = Intent(context, ContentDetailActivity::class.java)
            intent.putExtras(bundle)
            context?.startActivity(intent)
        }
    }

    private lateinit var binding: ActivityContentDetailBinding
    private lateinit var contentAllImagesAdapter: ContentAllImagesAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var presenter =
        ContentDetailPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentDetailBinding.inflate(layoutInflater)
        initRecyclerView()
        presenter.setData(intent.extras)
        setContentView(binding.root)
    }

    private fun initRecyclerView() {
        viewManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        contentAllImagesAdapter =
            ContentAllImagesAdapter(
                mutableListOf()
            )
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.recyclerViewAllImages)
        binding.recyclerViewAllImages.apply {
            layoutManager = viewManager
            adapter = contentAllImagesAdapter
            addItemDecoration(CirclePagerIndicatorDecoration(context))
        }
    }

    override fun onDataSet(mutableList: MutableList<Int>) {
        contentAllImagesAdapter.setData(mutableList)
    }
}