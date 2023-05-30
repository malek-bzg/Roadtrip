package com.anypli.roadtriip.ui.event

import androidx.compose.material.ButtonDefaults
import com.anypli.roadtriip.R
import com.anypli.roadtriip.base.BaseViewModel
import com.anypli.roadtriip.global.helper.TypeMessage
import com.anypli.roadtriip.ui.shared.theme.RoadtriipTheme

class CameraViewModel : BaseViewModel() {

    fun onNextClicked() {
        showChoseDialog(
            title = TypeMessage.ResourceMessage(R.string.camera_dialog_title),
            message = TypeMessage.ResourceMessage(R.string.camera_dialog_message),
            ok = TypeMessage.ResourceMessage(R.string.suivant),
            cancel = TypeMessage.ResourceMessage(R.string.annuler),
            //okActionBlock = {navigate()},
            cancelActionBlock = {}
        )
    }
}