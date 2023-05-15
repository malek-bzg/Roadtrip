package com.anypli.roadtriip.ui.shared.theme
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.anypli.roadtriip.R



val elmessri = FontFamily(
listOf(
Font(R.font.elmessiri_regular, FontWeight.Normal) ,
Font(R.font.elmessiri_medium, FontWeight.Medium),
Font(R.font.elmessiri_semibold, FontWeight.SemiBold),
Font(R.font.elmessiri_bold, FontWeight.Bold),
)
)
//class RoadTripTypography : Typography() {
//}

val Typography = androidx.compose.material.Typography(
    body1 = TextStyle(
        color = BLACK ,
        fontFamily = elmessri ,
        fontWeight = FontWeight.Normal ,
        fontSize = 18.sp
    ) ,
    body2 = TextStyle(
        color = BLACK ,
        fontFamily = elmessri ,
        fontWeight = FontWeight.Normal ,
        fontSize = 16.sp
    ) ,
    h1 = TextStyle(
        color = BLACK ,
        fontFamily = elmessri ,
        fontWeight = FontWeight.Bold ,
        fontSize = 22.sp
    ) ,
    h2 = TextStyle(
        color = BLACK ,
        fontFamily = elmessri ,
        fontWeight = FontWeight.Bold ,
        fontSize = 24.sp
    ) ,
    h3 = TextStyle(
        color = BLACK ,
        fontFamily = elmessri ,
        fontWeight = FontWeight.Bold ,
        fontSize = 16.sp
    ) ,
    h4 = TextStyle(
        color = BLACK ,
        fontFamily = elmessri ,
        fontWeight = FontWeight.Bold ,
        fontSize = 18.sp
    )
)