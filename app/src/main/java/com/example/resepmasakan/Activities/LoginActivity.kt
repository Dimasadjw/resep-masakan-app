package com.example.resepmasakan.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.resepmasakan.MainActivity
import com.example.resepmasakan.R

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvLoginHeading: TextView
    private lateinit var tvWelcome: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginpage)  // sesuai layout kamu

        // Inisialisasi View
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)
        tvLoginHeading = findViewById(R.id.tv_login_heading)
        tvWelcome = findViewById(R.id.tv_welcome)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty()) {
                etEmail.error = "Email tidak boleh kosong"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                etPassword.error = "Password tidak boleh kosong"
                return@setOnClickListener
            }

            // Login Berhasil
            Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()

            // Kirim email ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("user_email", email)
            startActivity(intent)
            finish()
        }
    }
}