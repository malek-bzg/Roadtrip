package com.anypli.roadtriip.base

import androidx.lifecycle.ViewModel
import com.anypli.roadtriip.global.helper.BaseStateContent
import com.anypli.roadtriip.global.helper.Navigation
import com.anypli.roadtriip.global.helper.TypeMessage
import com.anypli.roadtriip.global.helper.dialog.ChooseDialog
import com.anypli.roadtriip.global.helper.dialog.SimpleDialog
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel : ViewModel() {



    //for blocking progress bar
    private val _progressBar: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val progressBar: StateFlow<Boolean>
        get() = _progressBar

    //for displaying simple dialog
    private val _simpleDialog: MutableStateFlow<SimpleDialog?> = MutableStateFlow(null)
    val simpleDialog: StateFlow<SimpleDialog?>
        get() = _simpleDialog

    //for displaying chose dialog
    private val _chooseDialog: MutableStateFlow<ChooseDialog?> = MutableStateFlow(null)
    val chooseDialog: StateFlow<ChooseDialog?>

        get() = _chooseDialog


    //for displaying global snack bar
    private val _snackBarMessage: MutableStateFlow<BaseStateContent<TypeMessage>?> = MutableStateFlow(null)
    val snackBarMessage: StateFlow<BaseStateContent<TypeMessage>?>
        get() = _snackBarMessage


    private val _navigation = MutableStateFlow<BaseStateContent<Navigation>?>(null)
    val navigation: StateFlow<BaseStateContent<Navigation>?>
        get() = _navigation


    fun onSnackBarDisplayed(id: Long) {
        if (_snackBarMessage.value?.id == id) {
            _snackBarMessage.value = null
        }
    }


}