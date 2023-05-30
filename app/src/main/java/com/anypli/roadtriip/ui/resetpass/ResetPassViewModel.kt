package com.anypli.roadtriip.ui.resetpass

import com.anypli.roadtriip.R
import com.anypli.roadtriip.base.BaseViewModel
import com.anypli.roadtriip.global.helper.Navigation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ResetPassViewModel : BaseViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _errorMail = MutableStateFlow<Int?>(null)
    val errorMail: StateFlow<Int?> = _errorMail


    fun onEmailChange(value: String) {
        _email.value = value

    }

    fun onSignupClicked(){
        navigate(Navigation.SignupScreen)
    }
    fun onResetClicked()  {
        if (_email.value.isEmpty()) {
            updateErrorMessage(R.string.empty)
        } else {
            // Effectuer la navigation ou les actions souhaitées pour le cas où les champs sont remplis
        }


    }

    private fun updateErrorMessage(message: Int) {
        _errorMail.value = message

    }


}