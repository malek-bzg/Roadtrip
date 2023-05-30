package com.anypli.roadtriip.ui.signin

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.anypli.roadtriip.R
import com.anypli.roadtriip.base.BaseViewModel
import com.anypli.roadtriip.global.helper.Navigation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SigninViewModel : BaseViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email


    private val _passwordhidden = MutableStateFlow(true)
    val passwordHidden: StateFlow<Boolean> = _passwordhidden


    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password
//


    private val _errorMail = MutableStateFlow<Int?>(null)
    val errorMail: StateFlow<Int?> = _errorMail


    private val _errorPass = MutableStateFlow<Int?>(null)
    val errorPass: StateFlow<Int?> = _errorPass





//    private val _isPasswordEmpty  = MutableStateFlow(false)
//    val isPasswordEmpty: StateFlow<Boolean> = _isPasswordEmpty

    fun onEmailChange(value: String) {
        _email.value = value

    }
    fun onPasswordChange(value: String) {
        _password.value = value

    }
    fun onPasswordHiddenChange(value: Boolean) {
        _passwordhidden.value = value

    }

   fun onResetPasswordClicked(){
       navigate(Navigation.ResetPassScreen)
   }

    fun onCreateAccountClicked(){
        navigate(Navigation.SignupScreen)
    }


    fun onLoginClicked()  {
        if (_email.value.isEmpty() || _password.value.isEmpty()) {
            updateErrorMessage(R.string.empty)
        } else {
            // Effectuer la navigation ou les actions souhaitées pour le cas où les champs sont remplis
        }


    }

    private fun updateErrorMessage(message: Int) {
        _errorMail.value = message
        _errorPass.value = message
    }




}