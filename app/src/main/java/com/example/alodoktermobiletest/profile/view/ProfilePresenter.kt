package com.example.alodoktermobiletest.profile.view

import androidx.fragment.app.Fragment
import com.example.alodoktermobiletest.Constants
import com.example.alodoktermobiletest.SharePreferenceHelpers

class ProfilePresenter(private var profileInterface: ProfileInterface?) {

    private var fragment = profileInterface as Fragment

    fun initData() {
        val userModelView =
            fragment.activity?.let { SharePreferenceHelpers.getUser(it, Constants.PREF_KEY_USER) }
        profileInterface?.onDataSet(userModelView)
    }
}