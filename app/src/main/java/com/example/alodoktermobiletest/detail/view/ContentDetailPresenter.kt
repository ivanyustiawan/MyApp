package com.example.alodoktermobiletest.detail.view

import android.os.Bundle
import com.example.alodoktermobiletest.Constants
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ContentDetailPresenter(private var contentDetailInterface: ContentDetailInterface?) {

    fun setData(bundle: Bundle?) {
        val listString = bundle?.getSerializable(Constants.EXTRA_CONTENT_DETAIL) as String
        val gson = Gson()
        val itemType = object : TypeToken<MutableList<Int>>() {}.type
        val list = gson.fromJson<MutableList<Int>>(listString, itemType)
        contentDetailInterface?.onDataSet(list)
    }

}