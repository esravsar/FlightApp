package esra.avsar.flightapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import esra.avsar.flightapp.R
import java.util.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

            Timer().schedule(object : TimerTask() {
                override fun run() {
                    val mainIntent = Intent(this@SplashActivity, LoginActivity::class.java)
                    startActivity(mainIntent)
                    finish()
                }
            }, 3000)


    }
}