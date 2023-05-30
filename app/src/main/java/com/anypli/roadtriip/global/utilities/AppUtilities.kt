package com.anypli.roadtriip.global.utilities

import androidx.annotation.DimenRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.anypli.roadtriip.global.helper.TypeMessage

@Composable
fun TypeMessage.convertToString(): String {
    return if (this is TypeMessage.StringMessage)
        this.message
    else stringResource(id = (this as TypeMessage.ResourceMessage).messageId)

}
@Composable
@ReadOnlyComposable
fun fontDimensionResource(@DimenRes id: Int) = dimensionResource(id = id).value.sp