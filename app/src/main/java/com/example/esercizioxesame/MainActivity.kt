package com.example.esercizioxesame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun isValidPassword(password: String?): Boolean{
        return password != null && password.length >= 4
    }
    private fun isValidEmail(email: String): Boolean{
        val EMAIL_PATTERN = ("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+")
        val pattern = Pattern.compile(EMAIL_PATTERN)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun checkLogin(v: View?){
        val email = etEmailAddress.text.toString()
        val invalidEmail = getString(R.string.invalid_email)
        val invalidPassword = getString(R.string.invalid_password)
        val password = etPassword.text.toString()
        if(!isValidEmail(email)){
            etEmailAddress.error = invalidEmail
        }
        if(!isValidPassword(password)){
            etPassword.error = invalidPassword
        }
    }
}