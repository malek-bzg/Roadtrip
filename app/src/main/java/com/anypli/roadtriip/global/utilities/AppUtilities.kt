package com.anypli.roadtriip.global.utilities

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.anypli.roadtriip.global.helper.TypeMessage

@Composable
fun TypeMessage.convertToString(): String {
    return if (this is TypeMessage.StringMessage)
        this.message
    else stringResource(id = (this as TypeMessage.ResourceMessage).messageId)

}