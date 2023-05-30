package com.anypli.roadtriip.ui.event

import com.anypli.roadtriip.R
import com.anypli.roadtriip.base.BaseViewModel
import com.anypli.roadtriip.global.helper.Navigation
import com.anypli.roadtriip.global.helper.TypeMessage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AddEventsViewModel : BaseViewModel() {

    private val _titre = MutableStateFlow("")
    val titre: StateFlow<String> = _titre

    private val _description = MutableStateFlow("")
    val description: StateFlow<String> = _description

    private val _prix = MutableStateFlow("")
    val prix: StateFlow<String> = _prix


    private val _date = MutableStateFlow("")
    val date: StateFlow<String> = _date

    private val _nb = MutableStateFlow("")
    val nb: StateFlow<String> = _nb

    private val _errortitre = MutableStateFlow<Int?>(null)
    val errortitre: StateFlow<Int?> = _errortitre

    private val _errordescription = MutableStateFlow<Int?>(null)
    val errordescription: StateFlow<Int?> = _errordescription

    private val _errorprix = MutableStateFlow<Int?>(null)
    val errorprix: StateFlow<Int?> = _errorprix

    private val _errornb = MutableStateFlow<Int?>(null)
    val errornb: StateFlow<Int?> = _errornb

    private val _errordate = MutableStateFlow<Int?>(null)
    val errordate: StateFlow<Int?> = _errordate


    fun onTitreChange(value: String) {
        _titre.value = value
    }
    fun onDescriptionChange(value: String) {
        _description.value = value
    }
    fun onPrixChange(value: String) {
        _prix.value = value
    }
    fun onDateChange(value: String) {
        _date.value = value
    }
    fun onImageChange(value: String) {
        _prix.value = value
    }
    fun onNbDispoChange(value: String) {
        _nb.value = value
    }

    fun onCameraScreenClicked(){
        navigate(Navigation.CameraScreen)
    }

    fun onRegisterClicked()  {
        if (_titre.value.isEmpty() || _description.value.isEmpty()) {
            _prix.value.isEmpty()
            _nb.value.isEmpty()
            _date.value.isEmpty()

            updateErrorMessage(R.string.empty)
        } else {
            // Effectuer la navigation ou les actions souhaitées pour le cas où les champs sont remplis
        }


    }


    private fun updateErrorMessage(message: Int) {
        _errortitre.value = message
        _errordescription.value = message
        _errorprix.value = message
        _errornb.value = message
        _errordate.value = message
    }



}