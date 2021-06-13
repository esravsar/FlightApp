package esra.avsar.flightapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import esra.avsar.flightapp.R
import esra.avsar.flightapp.ui.home.HomeActivity
import java.util.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (checkRememberData()) {
            Timer().schedule(object : TimerTask() {
                override fun run() {
                    val mainIntent = Intent(this@SplashActivity, HomeActivity::class.java)
                    startActivity(mainIntent)
                    finish()
                }
            }, 3000)
        } else {
            Timer().schedule(object : TimerTask() {
                override fun run() {
                    val mainIntent = Intent(this@SplashActivity, LoginActivity::class.java)
                    startActivity(mainIntent)
                    finish()
                }
            }, 3000)
        }
    }

    private fun checkRememberData(): Boolean {
        val sharedPreferences = getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)
        val email = sharedPreferences.getString("email", "")
        val password = sharedPreferences.getString("password", "")

        return email?.isNotEmpty() == true && password?.isNotEmpty() == true
    }
}


