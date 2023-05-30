package com.anypli.roadtriip.ui.profile

import com.anypli.roadtriip.R
import com.anypli.roadtriip.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ModifierProfileViewModel : BaseViewModel() {


    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _lastname = MutableStateFlow("")
    val lastname: StateFlow<String> = _lastname


    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _errorMail = MutableStateFlow<Int?>(null)
    val errorMail: StateFlow<Int?> = _errorMail

    private val _errorname = MutableStateFlow<Int?>(null)
    val errorname: StateFlow<Int?> = _errorname

    private val _errorlastname = MutableStateFlow<Int?>(null)
    val errorlastname: StateFlow<Int?> = _errorlastname


    fun onEmailChange(value: String) {
        _email.value = value
    }
    fun onNameChange(value: String) {
        _name.value = value
    }
    fun onLastNameChange(value: String) {
        _lastname.value = value
    }
    fun onMiseAJourClicked()  {
        if (_email.value.isEmpty() || _name.value.isEmpty()) {
            _lastname.value.isEmpty()

            updateErrorMessage(R.string.empty)
        } else {
            // Effectuer la navigation ou les actions souhaitées pour le cas où les champs sont remplis
        }


    }

    private fun updateErrorMessage(message: Int) {
        _errorMail.value = message
        _errorname.value = message
        _errorlastname.value = message

    }


}

