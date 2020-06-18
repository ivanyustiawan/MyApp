package com.example.alodoktermobiletest.main.view

import android.view.MenuItem
import com.example.alodoktermobiletest.R
import com.example.alodoktermobiletest.home.view.HomeFragment
import com.example.alodoktermobiletest.main.view.MainInterface
import com.example.alodoktermobiletest.profile.view.ProfileFragment

class MainPresenter(private var mainInterface: MainInterface?) {

    fun onTabClicked(menuItem: MenuItem) {
        if (menuItem.itemId == R.id.navigation_home) {
            val homeFragment =
                HomeFragment()
            mainInterface?.onTabSelected(homeFragment)

        } else if (menuItem.itemId == R.id.navigation_profile) {
            val profileFragment =
                ProfileFragment()
            mainInterface?.onTabSelected(profileFragment)
        }
    }

}