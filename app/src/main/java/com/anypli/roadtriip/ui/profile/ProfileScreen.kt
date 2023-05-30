package com.anypli.roadtriip.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anypli.roadtriip.R
import com.anypli.roadtriip.base.BaseScreen
import com.anypli.roadtriip.global.helper.Navigation
import com.anypli.roadtriip.ui.event.AddEventsViewModel
import com.anypli.roadtriip.ui.main.AppNavigator
import com.anypli.roadtriip.ui.shared.theme.RoadtriipTheme


@Composable
fun ProfileScreen(

    viewModel: AddEventsViewModel ,
    navigator: AppNavigator


) {

    val snackbarHostState = remember { SnackbarHostState() }


    BaseScreen(
        viewModel = viewModel ,
        navigationCallback = {
            if (it is Navigation.CameraScreen)
                navigator.navigateTo(Navigation.CameraScreen)
        } ,
        snackbarHostState = snackbarHostState
    ) { modifier ->
        ProfileScreen(
            snackbarHostState = snackbarHostState,
            modifier = modifier ,
        )
    }
}
    @Composable
    private fun ProfileScreen(
        snackbarHostState : SnackbarHostState = remember { SnackbarHostState() } ,
        modifier: Modifier ,
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(

                    color = RoadtriipTheme.colors.transparent ,
                )
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_shape) , contentDescription = "" ,
                modifier = Modifier.fillMaxSize() , contentScale = ContentScale.FillBounds
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 35.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(9f)
                    ) {

                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(top = 10.dp) ,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Button(
                            onClick = { /* Action d'annulation */ },
                            colors = ButtonDefaults.buttonColors(RoadtriipTheme.colors.yeloows),
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = dimensionResource(R.dimen.margin_global_8dp))
                        ) {
                            Text(text = stringResource(R.string.changer) , fontWeight = FontWeight.Bold)
                        }

                        Spacer(modifier = Modifier.weight(0.3f))

                        Button(
                            onClick = { /* Action d'annulation */ },
                            colors = ButtonDefaults.buttonColors(RoadtriipTheme.colors.yeloows),
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = dimensionResource(R.dimen.margin_global_8dp))
                        ) {
                            Text(text = stringResource(R.string.fermer) , fontWeight = FontWeight.Bold)
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(top = 20.dp) ,
                    verticalArrangement = Arrangement.Center
                ) {
                    Card(
                        modifier = Modifier
                            .size(80.dp)
                            .background(
                                color = Color(0xFF00FF00) ,
                                shape = RoundedCornerShape(250.dp)
                            )
                    ) {
                        Image(
                                painter = painterResource(id = R.drawable.ic_baseline_person_outline_24) ,
                                contentDescription = null ,
                                modifier = Modifier
                                    .size(100.dp) // Modifier la taille de l'image ici
                                    .fillMaxSize(),
                            )

                    }

                    Text(
                        text = "Nom Prénom" ,
                        modifier = Modifier.padding(top = 10.dp) ,
                        color = Color.Black ,
                        fontSize = 20.sp
                    )
                }
            }

            Button(
                onClick = { /* TODO: Implement */ } ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp) ,
                colors = ButtonDefaults.buttonColors(RoadtriipTheme.colors.transparent)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_outline_edit_24) ,
                        contentDescription = null ,
                        modifier = Modifier.padding(end = 10.dp)
                    )
                    Text(text = "Compte Profil" , color = Color.Black , fontSize = 15.sp)
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24) ,
                        contentDescription = null ,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }

            Button(
                onClick = { /* TODO: Implement */ } ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp) ,
                colors = ButtonDefaults.buttonColors(RoadtriipTheme.colors.transparent)
            ) {
                // Add the rest of the buttons
            }

            Button(
                onClick = { /* TODO: Implement */ } ,
                modifier = Modifier
                    .fillMaxWidth()
                    //.align(Alignment.BottomStart)
                    .padding(bottom = 50.dp) ,
                colors = ButtonDefaults.buttonColors(RoadtriipTheme.colors.transparent)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_exit_to_app_24) ,
                        contentDescription = null ,
                        modifier = Modifier.padding(end = 10.dp)
                    )
                    Text(text = "CHANGER LE  MOT DE PASSE" , color = Color.Black , fontSize = 15.sp)
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24) ,
                        contentDescription = null ,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }



        }
    }
@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(
        modifier = Modifier ,


        )
}

