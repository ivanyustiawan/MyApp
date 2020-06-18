package com.example.alodoktermobiletest.home.view

import com.example.alodoktermobiletest.R
import com.example.alodoktermobiletest.home.model.ContentModelView

class HomePresenter(private var homeInterface: HomeInterface?) {

    fun setData() {
        homeInterface?.onDataSet(getListContent())
    }

    private fun getListContent(): MutableList<ContentModelView> {
        val resultList: MutableList<ContentModelView> = mutableListOf()
        resultList.add(ContentModelView().apply {
            listImage.add(R.drawable.ic_elephant)
            listImage.add(R.drawable.ic_duck)
            listImage.add(R.drawable.ic_dinosaur)
        })
        resultList.add(ContentModelView().apply {
            listImage.add(R.drawable.ic_people)
            listImage.add(R.drawable.ic_buddy)
            listImage.add(R.drawable.ic_elephant)
        })
        resultList.add(ContentModelView().apply {
            listImage.add(R.drawable.ic_buddy)
            listImage.add(R.drawable.ic_elephant)
            listImage.add(R.drawable.ic_duck)
        })
        return resultList
    }
}