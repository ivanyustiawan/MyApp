package com.example.alodoktermobiletest.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alodoktermobiletest.databinding.FragmentHomeBinding
import com.example.alodoktermobiletest.home.adapter.ContentAdapter
import com.example.alodoktermobiletest.home.model.ContentModelView

class HomeFragment : Fragment(), HomeInterface {

    private var binding: FragmentHomeBinding? = null
    private lateinit var contentAdapter: ContentAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var presenter = HomePresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        presenter.setData()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun initRecyclerView() {
        viewManager = LinearLayoutManager(activity)
        contentAdapter =
            ContentAdapter(
                mutableListOf()
            )
        binding?.recyclerViewContent?.apply {
            layoutManager = viewManager
            adapter = contentAdapter
            addItemDecoration(
                DividerItemDecoration(
                    binding?.recyclerViewContent?.context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    override fun onDataSet(list: MutableList<ContentModelView>) {
        contentAdapter.setData(list)
    }
}