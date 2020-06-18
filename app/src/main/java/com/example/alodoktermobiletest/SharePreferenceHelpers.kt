package com.example.alodoktermobiletest

import android.content.Context
import androidx.preference.PreferenceManager
import com.example.alodoktermobiletest.login.model.UserModelView
import com.google.gson.Gson


class SharePreferenceHelpers {
    companion object {
        fun saveUser(context: Context, key: String, userModelView: UserModelView) {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val sharedPreferenceEditor = sharedPreferences.edit()
            val gson = Gson()
            val json = gson.toJson(userModelView)
            sharedPreferenceEditor.putString(key, json)
            sharedPreferenceEditor.apply()
        }

        fun getUser(context: Context, key: String): UserModelView? {
            return try {
                val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
                val gson = Gson()
                val json: String? = sharedPreferences.getString(key, "")
                val userModelView: UserModelView = gson.fromJson(json, UserModelView::class.java)
                userModelView
            } catch (e: Exception) {
                null
            }
        }
    }
}