package com.anypli.roadtriip.ui.signup

import com.anypli.roadtriip.R
import com.anypli.roadtriip.base.BaseViewModel
import com.anypli.roadtriip.global.helper.Navigation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SignupViewModel : BaseViewModel() {

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name


    private val _phone = MutableStateFlow("")
    val phoneNumber: StateFlow<String> = _phone

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _passwordhidden = MutableStateFlow(true)
    val passwordHidden: StateFlow<Boolean> = _passwordhidden

    private val _confirmpassword = MutableStateFlow("")
    val confirmPassword: StateFlow<String> = _confirmpassword

    private val _errorName = MutableStateFlow<Int?>(null)
    val errorName: StateFlow<Int?> = _errorName

    private val _errorphone = MutableStateFlow<Int?>(null)
    val errorphone: StateFlow<Int?> = _errorphone

    private val _errorMail = MutableStateFlow<Int?>(null)
    val errorMail: StateFlow<Int?> = _errorMail

    private val _errorPass = MutableStateFlow<Int?>(null)
    val errorPass: StateFlow<Int?> = _errorPass

    private val _errorConfirmPass = MutableStateFlow<Int?>(null)
    val errorConfirmPass: StateFlow<Int?> = _errorConfirmPass




    fun onEmailChange(value: String) {
        _email.value = value
    }
    fun onNameChange(value: String) {
        _name.value = value
    }
    fun onPhoneChange(value: String) {
        _phone.value = value
    }
    fun onPasswordChange(value: String) {
        _password.value = value
    }

    fun onPasswordHiddenChange(value: Boolean) {
        _passwordhidden.value = value

    }
    fun onConfirmPasswordChange(value: String) {
        _confirmpassword.value = value
    }

    fun onSigninClicked(){
        navigate(Navigation.SigninScreen)
    }
    fun onResetPasswordClicked(){
        navigate(Navigation.ResetPassScreen)
    }

    fun onRegisterClicked()  {
        if (_email.value.isEmpty() || _password.value.isEmpty()) {
            _name.value.isEmpty()
            _phone.value.isEmpty()
            _confirmpassword.value.isEmpty()

            updateErrorMessage(R.string.empty)
        } else {
            // Effectuer la navigation ou les actions souhaitées pour le cas où les champs sont remplis
        }


    }



    private fun updateErrorMessage(message: Int) {
        _errorName.value = message
        _errorphone.value = message
        _errorMail.value = message
        _errorPass.value = message
        _errorConfirmPass.value = message
    }

}