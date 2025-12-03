package com.example.masakyuk

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvLoginHeading: TextView
    private lateinit var tvWelcome: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginpage) // pastikan sesuai nama xml kamu

        // Inisialisasi View
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)
        tvLoginHeading = findViewById(R.id.tv_login_heading)
        tvWelcome = findViewById(R.id.tv_welcome)

        // Aksi tombol login
        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // Validasi sederhana
            if (email.isEmpty()) {
                etEmail.error = "Email tidak boleh kosong"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                etPassword.error = "Password tidak boleh kosong"
                return@setOnClickListener
            }

            // Contoh validasi sukses
            if (email == "admin@gmail.com" && password == "123456") {
                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()

                // Contoh pindah ke activity lain
                // val intent = Intent(this, HomeActivity::class.java)
                // startActivity(intent)
                // finish()

            } else {
                Toast.makeText(this, "Email atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
