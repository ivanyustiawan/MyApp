package com.example.alodoktermobiletest.login.view

import android.content.Context
import com.example.alodoktermobiletest.helper.Constants
import com.example.alodoktermobiletest.R
import com.example.alodoktermobiletest.helper.SharePreferenceHelpers
import com.example.alodoktermobiletest.login.model.UserModelView

class LoginPresenter(private var loginInterface: LoginInterface?) {

    private var context = loginInterface as Context

    fun onLoginClick(email: String?, password: String?) {
        if (email.isNullOrEmpty() && password.isNullOrEmpty()) {
            loginInterface?.onEmailAndPasswordEmpty(context.getString(R.string.text_message_empty_email_and_password))
        } else {
            SharePreferenceHelpers.saveUser(
                context,
                Constants.PREF_KEY_USER,
                getUser(email, password)
            )
            loginInterface?.onSuccessfullyLogin()
        }
    }

    fun isAuthenticated() {
        if (SharePreferenceHelpers.getUser(context, Constants.PREF_KEY_USER) != null) {
            loginInterface?.onSuccessfullyLogin()
        }
    }

    private fun getUser(email: String?, password: String?): UserModelView {
        return UserModelView().apply {
            this.email = email
            this.password = password
            this.name = "Ivan"
            this.gender = "Male"
            this.phoneNumber = "+6285712345678"
            this.image = R.drawable.ic_elephant
        }
    }

}