package esra.avsar.flightapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import esra.avsar.flightapp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val email = "appcent@appcent.mobi"
    private val password = "123456"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener {
            if (email == etEmail.text.toString() && password == etPassword.text.toString()) {
                Toast.makeText(this, "Giriş Başarılı", Toast.LENGTH_SHORT).show()
                val loginIntent = Intent(this, HomeActivity::class.java)
                startActivity(loginIntent)
                finish()
            } else {
                Toast.makeText(this,"Bilgileriniz hatalıdır. Lütfen bilgilerini kontrol ediniz.", Toast.LENGTH_SHORT).show()
            }
        }


        //TODO: login tasarımı yapıldı, işlevi yazılacak.
    }
}