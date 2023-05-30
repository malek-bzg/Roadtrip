package com.anypli.roadtriip.ui.resetpass

import com.anypli.roadtriip.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ChangemdpViewModel: BaseViewModel() {

    private val _ancienPass = MutableStateFlow("")
    val ancienPass: StateFlow<String> = _ancienPass

    private val _newPass = MutableStateFlow("")
    val newPass: StateFlow<String> = _newPass

    private val _confirmPass = MutableStateFlow("")
    val confirmPass: StateFlow<String> = _confirmPass


    fun onPassChange(value: String) {
        _ancienPass.value = value
    }

    fun onNewPassChange(value: String) {
        _newPass.value = value
    }

    fun onconfirmPassChange(value: String) {
        _confirmPass.value = value
    }



}