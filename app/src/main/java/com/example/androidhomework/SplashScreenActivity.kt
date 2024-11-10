package com.example.androidhomework

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    private val splashScreenTimeout: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // Проверяем, авторизован ли пользователь
            if (isUserLoggedIn()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, RegistrationActivity::class.java)
                startActivity(intent)
            }
            finish()
        }, splashScreenTimeout)
    }

    private fun isUserLoggedIn(): Boolean {
        // Реализуйте логику проверки, авторизован ли пользователь
        // Например, проверка сохраненных токенов или данных в SharedPreferences
        return false
    }
}
