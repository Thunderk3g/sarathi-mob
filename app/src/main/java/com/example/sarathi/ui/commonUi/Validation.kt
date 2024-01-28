package com.example.sarathi.ui.commonUi

import java.util.regex.Pattern

class Validation {

    private val nameRegex = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*\$"
    private val phoneRegex = "^\\d{10}\$"
    private val emailRegex = "^[A-Za-z\\d._%+-]+@[A-Za-z\\d.-]+\\.[A-Za-z]{2,}\$"

    fun validateName(name: String): Boolean {
        return if (name.isNotEmpty()) {
            Pattern.matches(nameRegex, name)
        } else {
            false
        }
    }

    fun validatePhone(phoneNumber: String): Boolean {
        return if (phoneNumber.isNotEmpty()) {
            Pattern.matches(phoneRegex, phoneNumber)
        } else {
            false
        }
    }

    fun validateEmail(email: String): Boolean {
        return if (email.isNotEmpty()) {
            Pattern.matches(emailRegex, email)
        } else {
            false
        }
    }

}