package com.example.alodoktermobiletest.main.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.alodoktermobiletest.databinding.ActivityMainBinding
import com.example.alodoktermobiletest.home.view.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(),
    MainInterface {

    companion object {
        fun startThisActivity(context: Context?) {
            val intent = Intent(context, MainActivity::class.java)
            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            context?.startActivity(intent)
        }
    }

    private lateinit var binding: ActivityMainBinding
    private var presenter =
        MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initNavigationListener()
        setContentView(binding.root)
    }

    private fun initNavigationListener() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {
            presenter.onTabClicked(it)
            return@OnNavigationItemSelectedListener true
        })

        onTabSelected(HomeFragment())
    }

    override fun onTabSelected(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(binding.container.id, fragment)
            .commit()
    }

}