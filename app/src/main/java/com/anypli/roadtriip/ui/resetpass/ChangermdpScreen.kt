package com.anypli.roadtriip.ui.resetpass


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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anypli.roadtriip.R
import com.anypli.roadtriip.base.BaseScreen
import com.anypli.roadtriip.global.helper.Navigation
import com.anypli.roadtriip.ui.event.AddEventsViewModel
import com.anypli.roadtriip.ui.main.AppNavigator
import com.anypli.roadtriip.ui.shared.component.GlobalOutlinedTextField
import com.anypli.roadtriip.ui.shared.component.GradientButton
import com.anypli.roadtriip.ui.shared.theme.RoadtriipTheme
import com.anypli.roadtriip.ui.shared.theme.radiusShape30dp


@Composable
fun ChangermdpScreen(
    viewModel: ChangemdpViewModel ,
    navigator: AppNavigator
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val ancienPass by viewModel.ancienPass.collectAsState()
    val newPass by viewModel.newPass.collectAsState()
    val confirmPass by viewModel.confirmPass.collectAsState()

    BaseScreen(
        viewModel = viewModel ,
        navigationCallback = {
            if (it is Navigation.CameraScreen)
                navigator.navigateTo(Navigation.CameraScreen)
        } ,
        snackbarHostState = snackbarHostState
    ) { modifier ->
        ChangermdpScreen(
            snackbarHostState = snackbarHostState,
            modifier = modifier ,
            ancienPass = ancienPass ,
            newPass = newPass ,
            confirmPass = confirmPass ,

            onPassChange ={
                viewModel.onPassChange(it)
            },
            onNewPassChange ={
                viewModel.onNewPassChange(it)
            },
            onconfirmPassChange ={
                viewModel.onconfirmPassChange(it)
            },




        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ChangermdpScreen(
    snackbarHostState : SnackbarHostState = remember { SnackbarHostState() } ,
    modifier: Modifier ,
    ancienPass: String ,
    newPass: String ,
    confirmPass: String ,
    onPassChange: (String) -> Unit ,
    onNewPassChange: (String) -> Unit,
    onconfirmPassChange: (String) -> Unit,

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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp) ,
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                modifier = Modifier.weight(1f) ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_left_24) ,
                    contentDescription = null ,
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.Transparent)
                )
                Text(
                    text = stringResource(R.string.changer_mdp) ,
                    fontSize = 35.sp ,
                    color = Color.Black ,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
            Column(
                modifier = Modifier
                    .weight(8f)
                    .padding(top = 10.dp)
            ) {
                GlobalOutlinedTextField(
                    value = ancienPass ,
                    onValueChange = onPassChange ,
                    label = stringResource(R.string.ancien_mdp) ,
                    placeholder = stringResource(
                        R.string.ancien_mdp
                    ) ,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next ,
                        keyboardType = KeyboardType.Text
                    ) ,
                    singleLine = true ,
//                errorMessage = errortitre?.let {
//                    stringResource(id = it)
//                }
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.margin_global_12dp)))

                GlobalOutlinedTextField(
                    value = newPass ,
                    onValueChange = onNewPassChange ,
                    label = stringResource(R.string.new_mdp) ,
                    placeholder = stringResource(
                        R.string.new_mdp
                    ) ,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next ,
                        keyboardType = KeyboardType.Text
                    ) ,
                    singleLine = true ,
//                errorMessage = errortitre?.let {
//                    stringResource(id = it)
//                }
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.margin_global_12dp)))

                GlobalOutlinedTextField(
                    value = confirmPass ,
                    onValueChange = onconfirmPassChange ,
                    label = stringResource(R.string.confirm_mdp) ,
                    placeholder = stringResource(
                        R.string.confirm_mdp
                    ) ,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next ,
                        keyboardType = KeyboardType.Text
                    ) ,
                    singleLine = true ,
//                errorMessage = errortitre?.let {
//                    stringResource(id = it)
//                }
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.margin_global_12dp)))
            }
            val gradientColor =
                listOf(RoadtriipTheme.colors.yeloows , RoadtriipTheme.colors.yeloowsc)
            val cornerRadius = dimensionResource(R.dimen.margin_global_16dp)


            Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.margin_global_10dp)))

            GradientButton(
                gradientColors = gradientColor ,
                cornerRadius = cornerRadius ,
                nameButton = stringResource(R.string.changer_mdp) ,
                roundedCornerShape = RoadtriipTheme.shapes.radiusShape30dp ,
                onClick = {


                }
            )
        }


    }
}
@Preview
@Composable
fun ChangermdpScreenPreview() {
    ChangermdpScreen(
        modifier = Modifier ,
        ancienPass = "ancienPass" ,
        newPass = "newPass ",
        confirmPass = "confirmPass" ,
        onPassChange = {} ,
        onNewPassChange =  {} ,
        onconfirmPassChange =  {},


        )
}