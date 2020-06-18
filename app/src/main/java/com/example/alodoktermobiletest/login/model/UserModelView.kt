package com.example.alodoktermobiletest.login.model

import java.io.Serializable

class UserModelView : Serializable {
    var email: String? = ""
    var password: String? = ""
    var name: String? = ""
    var gender: String? = ""
    var phoneNumber: String? = ""
    var image: Int? = 0
}