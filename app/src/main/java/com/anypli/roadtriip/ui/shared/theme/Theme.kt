package com.anypli.roadtriip.ui.shared.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider


@Composable
fun RoadtriipTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val  RoadTripColors = RoadTripColors(
        black = BLACK ,
        blue = BLUE ,
        red = RED ,
        green = GREEN ,
        grey = GREY ,
        yellow = YELLOW,
        transparent = TRANSPARENT,
        yeloows = YELOOWS,
        yeloowsc =YELOOWSC,
        white= WHITE,
        greyy= GREYY


    )

    CompositionLocalProvider(
        LocalCustomColors provides  RoadTripColors ,

    ) {
        MaterialTheme(
            typography = Typography() ,
            shapes = Shapes() ,
            content = content
        )
    }
}
object RoadtriipTheme {
  val colors: RoadTripColors
       @Composable
        get() = LocalCustomColors.current
    val typography: Typography
        @Composable
        get() = MaterialTheme.typography
    val shapes : Shapes
        @Composable
        get() = MaterialTheme.shapes
        }



