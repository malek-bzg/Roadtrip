package com.anypli.roadtriip.ui.splash


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.anypli.roadtriip.base.BaseScreen
import com.anypli.roadtriip.R

@Composable
fun SplashScreen(
    viewModel: SplashViewModel
    //navigator: DestinationsNavigator
) {
    val snackbarHostState = remember { SnackbarHostState() }

    BaseScreen(
        viewModel = viewModel,
        navigationCallback = {},
        snackbarHostState = snackbarHostState
    ) { modifier ->
        SplashScreen(
            snackbarHostState = snackbarHostState,
            modifier = modifier
        )
    }
}


@Composable
private fun SplashScreen(
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() } ,
    modifier: Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)

    )

    {
        Image(painter = painterResource(id = R.drawable.ic_shape), contentDescription = "",
            modifier = Modifier.fillMaxSize(),contentScale = ContentScale.FillBounds
        )
        // Logo centré
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .size(400.dp)
                .align(Alignment.Center)

        )
    }



}



