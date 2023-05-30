package com.anypli.roadtriip.ui.shared.theme
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.google.errorprone.annotations.Immutable


 val BLACK = Color( 0xFF000000)
 val BLUE = Color( 0xFF0A60F0)
 val RED = Color( 0xFFEC1B22)
 val GREEN = Color( 0xFF96DB46)
 val GREY = Color( 0xFF504F4C)
val GREYY = Color(0xBEF5F4F4)
 val YELLOW = Color( 0xFFECC224)
 val TRANSPARENT =Color(0x00000000)
val  YELOOWS = Color(0xFFF3CD3F)
val YELOOWSC = Color(0xFFDBB41F)
val WHITE =Color(0xFFFFFFFF)

@Immutable
data class RoadTripColors(
    val black: Color ,
    val blue: Color ,
    val red: Color ,
    val green: Color ,
    val grey: Color ,
    val yellow: Color ,
    val transparent : Color,
    val yeloows : Color,
    val yeloowsc : Color,
    val white: Color,
    val greyy : Color
)
val LocalCustomColors = staticCompositionLocalOf {
    RoadTripColors(
        black = Color.Unspecified,
        blue = Color.Unspecified,
        red = Color.Unspecified,
        green = Color.Unspecified,
        grey = Color.Unspecified ,
        yellow = Color.Unspecified,
        transparent = Color.Unspecified,
        yeloows = Color.Unspecified,
        yeloowsc = Color.Unspecified,
        white = Color.Unspecified,
        greyy = Color.Unspecified

    )

}


