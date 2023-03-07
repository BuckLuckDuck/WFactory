package com.example.worldfactory.activity.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.worldfactory.R
import com.example.worldfactory.activity.word.WordActivity
import com.example.worldfactory.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBack.setOnClickListener {
            super.onBackPressed() //
        }

        binding.buttonSignup.setOnClickListener {
            if (binding.textInputLayoutName.editText?.text.toString().isEmpty() ||
                binding.textInputLayoutEmail.editText?.text.toString().isEmpty() ||
                binding.textInputLayoutPassword.editText?.text.toString().isEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.login_failure))
                    .setMessage(R.string.login_fail_empty_fields)
                    .show()
                return@setOnClickListener
            }

            // Move next
            val intent = Intent(this@LoginActivity, WordActivity::class.java)
            startActivity(intent)
        }
    }
}