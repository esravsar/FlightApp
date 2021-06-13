package esra.avsar.flightapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import esra.avsar.flightapp.R
import esra.avsar.flightapp.ui.home.HomeActivity
import esra.avsar.flightapp.utils.Constants
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var isRemember = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener {
            if (Constants.email == etEmail.text.toString() && Constants.password == etPassword.text.toString()) {
                if (isRemember) {
                    rememberMe()
                }
                Toast.makeText(this, "Giriş Başarılı", Toast.LENGTH_SHORT).show()
                val loginIntent = Intent(this, HomeActivity::class.java)
                startActivity(loginIntent)
                finish()
            } else {
                Toast.makeText(
                    this,
                    "Bilgileriniz hatalıdır. Lütfen bilgilerini kontrol ediniz.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        cbRemember.setOnCheckedChangeListener { _, isChecked ->
            isRemember = isChecked
        }
    }

    private fun rememberMe() {
        val sharedPreferences = getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()
        myEdit.putString("email",etEmail.text.toString())
        myEdit.putString("password",etPassword.text.toString())
        myEdit.putBoolean("isRemember",isRemember)
        myEdit.commit()
    }
}