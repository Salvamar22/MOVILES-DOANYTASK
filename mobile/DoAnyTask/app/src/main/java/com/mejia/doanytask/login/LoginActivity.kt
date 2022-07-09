package com.mejia.doanytask.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.mejia.doanytask.DoAnyTaskApplication
import com.mejia.doanytask.MainActivity
import com.mejia.doanytask.R
import com.mejia.doanytask.ViewModelFactory
import com.mejia.doanytask.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    val app by lazy {
        application as DoAnyTaskApplication
    }

    private lateinit var binding: ActivityLoginBinding;

    private val viewModelFactory by lazy {
        ViewModelFactory(app.getLoginRepository())
    }
    private val viewModel: LoginViewModel by viewModels {
        viewModelFactory
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (app.isUserLogin()) {
            return goToMainActivity()
        }

        binding = DataBindingUtil.setContentView(
        this, R.layout.activity_login)

        binding.viewModel = viewModel;

        viewModel.status.observe(this) { status ->
            handleUiState(status)
        }


        val btn: Button = findViewById(R.id.btn_registrarse)
        btn.setOnClickListener{
            val intent: Intent = Intent(this, RegistrarseActivity:: class.java)
            startActivity(intent)
        }

        val but: Button = findViewById(R.id.btn_iniciar_sesion)
        but.setOnClickListener {
            viewModel.onLogin()
        }
    }

    private fun handleUiState(status: LoginUiStatus) {
        if(status is LoginUiStatus.Success) {
            app.saveAuthToken(status.token)
            goToMainActivity()
            Log.d("CREATION", "Esta token esta siendo seteado");
            Log.d("CREATION", status.token);
        }
        else {
            //nothing
        }
    }


    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}