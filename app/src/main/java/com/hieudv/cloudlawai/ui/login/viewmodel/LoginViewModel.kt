package com.hieudv.cloudlawai.ui.login.viewmodel

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.hieudv.cloudlawai.data.api.ApiClient
import com.hieudv.cloudlawai.data.api.request_body.LoginRequestBody
import com.hieudv.cloudlawai.data.api.response.LoginData
import com.hieudv.cloudlawai.data.api.response.LoginResponse
import com.hieudv.cloudlawai.data.api.services.AuthService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(application: Application): AndroidViewModel(application), Callback<LoginResponse> {
    var btnSelected: ObservableBoolean? = null
    var email: ObservableField<String>? = null
    var password: ObservableField<String>? = null
    var userLogin: MutableLiveData<LoginData>? = null

    init {
        btnSelected = ObservableBoolean(true)
        email = ObservableField("")
        password = ObservableField("")
        userLogin = MutableLiveData<LoginData>()
    }

    fun onEmailChanged(s: CharSequence, start: Int, befor: Int, count: Int) {
//        btnSelected?.set(Util.isEmailValid(s.toString()) && password?.get()!!.length >= 8)
    }

    fun onPasswordChanged(s: CharSequence, start: Int, befor: Int, count: Int) {
//        btnSelected?.set(Util.isEmailValid(email?.get()!!) && s.toString().length >= 8)
    }

    fun login() {
        val loginBody = LoginRequestBody(email?.get()!!, password?.get()!!)
        ApiClient.shared.create(AuthService::class.java)
            .login(loginBody)
            .enqueue(this)
    }

    override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) {
        val loginResponse: LoginResponse = response?.body()!!
        if (loginResponse.status == "SUCCESS") {
            Log.i("TAG", loginResponse.data.user.loginID)
            userLogin?.value = loginResponse.data
        } else if (loginResponse.status == "FAIL") {
            Log.e("TAG", "login failed --- " + loginResponse.message)
        }
    }

    override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
        Log.e("TAG", "login failed")
    }
}