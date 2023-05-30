package com.anypli.roadtriip.ui.event
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anypli.roadtriip.R
import com.anypli.roadtriip.base.BaseScreen
import com.anypli.roadtriip.ui.main.AppNavigator
import com.anypli.roadtriip.ui.shared.theme.RoadtriipTheme

@Composable
fun CameraScreen(
    viewModel: CameraViewModel ,
    navigator: AppNavigator
) {
    val snackbarHostState = remember { SnackbarHostState() }

    BaseScreen(
        viewModel = viewModel ,
        navigationCallback = {} ,
        snackbarHostState = snackbarHostState
    ) { modifier ->
        CameraScreen(
            snackbarHostState = snackbarHostState,
            modifier = modifier ,
            onNextClicked ={
                viewModel.onNextClicked()
            },

        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CameraScreen(
    snackbarHostState : SnackbarHostState = remember { SnackbarHostState() } ,
    modifier: Modifier ,
    onNextClicked: () -> Unit,
    ){


    Image(
        painter = painterResource(id = R.drawable.ic_shape) , contentDescription = "" ,
        modifier = Modifier.fillMaxSize() , contentScale = ContentScale.FillBounds
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier.size(dimensionResource(R.dimen.dimen_global_48))
        ) {

            Icon(Icons.Default.CameraAlt, contentDescription = stringResource(R.string.camera_icon))

        }

        Image(
            painter = painterResource(R.drawable.image_add),
            //painter = painterResource(R.drawable.add_image),
            contentDescription = "image_add",
            modifier = Modifier
                .padding(vertical = dimensionResource(R.dimen.margin_global_16dp)) // Décaler l'image légèrement vers le haut et le bas
                .size(dimensionResource(R.dimen.dimen_global_240)) // Augmenter la taille de l'image
        )
        Button(
            onClick = {
                onNextClicked()
            },
            colors = ButtonDefaults.buttonColors(RoadtriipTheme.colors.yeloowsc),
            modifier = Modifier
                .padding(horizontal = dimensionResource(R.dimen.margin_global_16dp))
                .height(dimensionResource(R.dimen.dimen_global_48)) // Augmenter la hauteur du bouton
        ) {
            Text(text = stringResource(R.string.suivant))
        }
    }



    }
@Preview
@Composable
fun CameraScreenPreview() {
    CameraScreen(
        modifier= Modifier ,
        onNextClicked ={}

    )
}



