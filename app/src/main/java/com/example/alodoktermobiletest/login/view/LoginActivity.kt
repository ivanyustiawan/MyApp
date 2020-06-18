package com.example.alodoktermobiletest.login.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alodoktermobiletest.databinding.ActivityLoginBinding
import com.example.alodoktermobiletest.main.view.MainActivity

class LoginActivity : AppCompatActivity(),
    LoginInterface {

    private lateinit var binding: ActivityLoginBinding
    private var presenter =
        LoginPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        presenter.isAuthenticated()
        initButtonListener()
        setContentView(binding.root)
    }

    private fun initButtonListener() {
        binding.buttonLogin.setOnClickListener {
            presenter.onLoginClick(
                binding.editTextEmail.text.toString(),
                binding.editTextPassword.text.toString()
            )
        }
    }

    override fun onEmailAndPasswordEmpty(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onSuccessfullyLogin() {
        MainActivity.startThisActivity(this)
    }
}