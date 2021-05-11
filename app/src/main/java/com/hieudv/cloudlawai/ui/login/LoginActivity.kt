package com.hieudv.cloudlawai.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hieudv.cloudlawai.R
import com.hieudv.cloudlawai.databinding.ActivityLoginBinding
import com.hieudv.cloudlawai.ui.login.viewmodel.LoginViewModel

class LoginActivity: AppCompatActivity() {
    var binding: ActivityLoginBinding? = null
    var viewModel: LoginViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding?.viewmodel = viewModel

        initObservables()
    }

    private fun initObservables() {
        viewModel?.userLogin?.observe(this, Observer { data ->
            Toast.makeText(this, "welcome, ${data.user.loginID}", Toast.LENGTH_LONG).show()
        })
    }
}