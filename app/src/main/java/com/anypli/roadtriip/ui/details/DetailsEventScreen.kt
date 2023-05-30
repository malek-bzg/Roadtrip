package com.anypli.roadtriip.ui.details

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.anypli.roadtriip.R
import com.anypli.roadtriip.base.BaseScreen
import com.anypli.roadtriip.global.helper.Navigation
import com.anypli.roadtriip.ui.main.AppNavigator
import com.anypli.roadtriip.ui.shared.component.GradientButton
import com.anypli.roadtriip.ui.shared.theme.*

@Composable
fun DetailsEventsScreen(

    viewModel:DetailsViewModel  ,
    navigator: AppNavigator

) {

    val snackbarHostState = remember { SnackbarHostState() }

    BaseScreen(
        viewModel = viewModel ,
        navigationCallback = {
            if (it is Navigation.Back)
                navigator.popBackStack()
        } ,
        snackbarHostState = snackbarHostState
    ) { modifier ->
        DetailsEventsScreen(
            snackbarHostState = snackbarHostState ,
            modifier = modifier ,

            onLoginClicked ={
                viewModel.onBackClicked()
            }



        )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun DetailsEventsScreen (
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() } ,
    modifier: Modifier ,
    scrollState: ScrollState = rememberScrollState(),
    onLoginClicked: () -> Unit,

) {
    Image(
        painter = painterResource(id = R.drawable.ic_shape) , contentDescription = "" ,
        modifier = Modifier.fillMaxSize() , contentScale = ContentScale.FillBounds
    )
    Column(

        modifier = modifier
            .fillMaxSize()
            .background(RoadtriipTheme.colors.transparent)
            .padding(dimensionResource(R.dimen.margin_global_20dp))
            .verticalScroll(scrollState)
    ) {
        IconButton(
            onClick = { /* Action to perform on back button click */ },
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = dimensionResource(R.dimen.dimen_global_60))
        ) {
            IconButton(
                onClick = {
                    onLoginClicked()
                },
                content = {
                    Icon(
                        imageVector = Icons.Outlined.KeyboardArrowLeft,
                        contentDescription = stringResource(R.string.close)
                    )
                }
            )
        }

        Column(
            modifier = Modifier
                .weight(7.15f)
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.dimen_global_250)),

            ) {
                Image(
                    painter = painterResource(R.drawable.monastir),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Text(
                text = "Monastir",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(R.dimen.margin_global_10dp)),
                textAlign = TextAlign.Center,
                style = RoadtriipTheme.typography.fontSize20spBLack,
                color = RoadtriipTheme.colors.black
            )

            Text(
                text = stringResource(R.string.description),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(R.dimen.margin_global_10dp)),
                textAlign = TextAlign.Center,
                style = RoadtriipTheme.typography.fontSize18spBLack,
                color = RoadtriipTheme.colors.black
            )
        }

        Text(
            text = stringResource(R.string.price),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(R.dimen.margin_global_10dp)),
            textAlign = TextAlign.Center,
            style = RoadtriipTheme.typography.fontSize24spBLack,
            color = RoadtriipTheme.colors.black
        )
        val gradientColor = listOf(RoadtriipTheme.colors.yeloows ,RoadtriipTheme.colors.yeloowsc)
        val cornerRadius =  dimensionResource(R.dimen.margin_global_16dp)


        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.margin_global_13dp)))

        GradientButton(
            gradientColors = gradientColor,
            cornerRadius = cornerRadius,
            nameButton = stringResource(R.string.participer),
            roundedCornerShape = RoadtriipTheme.shapes.radiusShape30dp ,
            onClick = {
                // Action à effectuer lors du clic sur le bouton Reset
                // Par exemple, réinitialiser des valeurs ou effectuer une autre opération
            }

        )
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.margin_global_13dp)))
    }

}
@Preview
@Composable
fun DetailsEventsScreenPreview() {
    DetailsEventsScreen(
        modifier = Modifier ,
        onLoginClicked = {}
    )
}





