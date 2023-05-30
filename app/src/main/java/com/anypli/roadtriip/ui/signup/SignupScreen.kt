package com.anypli.roadtriip.ui.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.anypli.roadtriip.ui.Visibility
import com.anypli.roadtriip.R
import com.anypli.roadtriip.base.BaseScreen
import com.anypli.roadtriip.global.helper.Navigation
import com.anypli.roadtriip.global.utilities.fontDimensionResource
import com.anypli.roadtriip.ui.VisibilityOff
import com.anypli.roadtriip.ui.main.AppNavigator
import com.anypli.roadtriip.ui.shared.component.GlobalOutlinedTextField
import com.anypli.roadtriip.ui.shared.component.GlobalPasswordOutlinedTextField
import com.anypli.roadtriip.ui.shared.component.GradientButton
import com.anypli.roadtriip.ui.shared.theme.*
import com.anypli.roadtriip.ui.signin.SigninScreen

@Composable
fun SignupScreen(

    viewModel: SignupViewModel,
    navigator: AppNavigator
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val name by viewModel.name.collectAsState()
    val phoneNumber by viewModel.phoneNumber.collectAsState()
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val passwordHidden by viewModel.passwordHidden.collectAsState()
    val confirmPassword by viewModel.confirmPassword.collectAsState()
    val errorMail by viewModel.errorMail.collectAsState()
    val errorPass by viewModel.errorPass.collectAsState()
    val errorName by viewModel.errorName.collectAsState()
    val errorphone by viewModel.errorphone.collectAsState()
    val errorConfirmPass by viewModel.errorConfirmPass.collectAsState()




    BaseScreen(
        viewModel = viewModel,
        navigationCallback = {if (it is Navigation.SigninScreen)
            navigator.navigateTo(Navigation.SigninScreen)

        else if (it is Navigation.ResetPassScreen)
            navigator.navigateTo(Navigation.ResetPassScreen)
        },
        snackbarHostState = snackbarHostState
    ) { modifier ->
        SignupScreen(
            snackbarHostState = snackbarHostState,
            modifier = modifier,
            name = name,
            phoneNumber = phoneNumber,
            email = email ,
            password = password,
            passwordHidden = passwordHidden ,
            confirmPassword = confirmPassword,
            errorMail = errorMail,
            errorPass=errorPass,
            errorName = errorName,
            errorphone=errorphone,
            errorConfirmPass =errorConfirmPass,




            onNameChange = {
                viewModel.onNameChange(it)
            },
            onPhoneChange = {
                viewModel.onPhoneChange(it)
            },
            onEmailChange = {
                viewModel.onEmailChange(it)
            },
            onPasswordChange = {
                viewModel.onPasswordChange(it)
            },
            onPasswordHiddenChange ={
                viewModel.onPasswordHiddenChange(it)
            },
            onConfirmPasswordChange ={
                viewModel.onConfirmPasswordChange(it)
            },

            onSigninClicked ={
                viewModel.onSigninClicked()
            },
            onResetPasswordClicked ={
                viewModel.onResetPasswordClicked()
            },
            onRegisterClicked ={
                viewModel.onRegisterClicked()
            },






        )
    }
}

@Composable
private fun SignupScreen(
    snackbarHostState : SnackbarHostState = remember { SnackbarHostState() } ,
    modifier: Modifier ,
    name: String,
    phoneNumber: String,
    email : String,
    password: String ,
    confirmPassword: String,
    onPasswordChange:(String)->Unit ,
    onNameChange:(String)->Unit ,
    onPhoneChange:(String)->Unit,
    onEmailChange:(String)->Unit ,
    onConfirmPasswordChange:(String)->Unit ,
    passwordHidden: Boolean ,
    onPasswordHiddenChange:(Boolean)->Unit ,
    onSigninClicked: () -> Unit,
    onRegisterClicked: () -> Unit,
    onResetPasswordClicked: () -> Unit,
    errorMail: Int? ,
    errorPass: Int? ,
    errorName: Int? ,
    errorphone: Int? ,
    errorConfirmPass : Int?,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = RoadtriipTheme.colors.transparent ,
            )
    ) {
        Image(painter = painterResource(id = R.drawable.ic_shape), contentDescription = "",
            modifier = Modifier.fillMaxSize(),contentScale = ContentScale.FillBounds
        )


        Box(
            modifier = Modifier
                /*.background(
                    color = MaterialTheme.colorScheme.onPrimary,
                    shape = RoundedCornerShape(25.dp, 5.dp, 25.dp, 5.dp)
                )*/
                .align(Alignment.BottomCenter),
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(dimensionResource(R.dimen.global_logo_height))
                    .fillMaxWidth(),

                )
            Column(
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.margin_global_16dp))
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                ,

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //.........................Spacer
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.dimen_global_30)))

                //.........................Text: title
                androidx.compose.material3.Text(
                    text = stringResource(R.string.create_an_account),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = dimensionResource(R.dimen.dimen_global_130))
                        .fillMaxWidth(),
                    style = RoadtriipTheme.typography.fontSize24spBLack,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.margin_global_8dp)))
                RegisterName(name, onNameChange , errorName)

                Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.margin_global_3dp)))
                RegisterPhone(phoneNumber , onPhoneChange , errorphone )

                Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.margin_global_3dp)))
                RegisterEmail(email, onEmailChange , errorMail)

                Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.margin_global_3dp)))
                RegisterPassword(password, onPasswordChange , passwordHidden , onPasswordHiddenChange,errorPass)

                Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.margin_global_3dp)))
                RegisterPasswordConfirm(confirmPassword, onConfirmPasswordChange, passwordHidden, onPasswordHiddenChange , errorConfirmPass)

                val gradientColor = listOf(RoadtriipTheme.colors.yeloows ,RoadtriipTheme.colors.yeloowsc)
                val cornerRadius =  dimensionResource(R.dimen.margin_global_16dp)


                Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.margin_global_10dp)))

                GradientButton(
                    gradientColors = gradientColor,
                    cornerRadius = cornerRadius,
                    nameButton = stringResource(R.string.create_an_account),
                    roundedCornerShape = RoadtriipTheme.shapes.radiusShape30dp,
                    onClick = {
                        onRegisterClicked()
                    }
                )

                Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.margin_global_10dp)))
                androidx.compose.material3.TextButton(onClick = {
                    onSigninClicked()

                }) {
                    androidx.compose.material3.Text(
                        color = RoadtriipTheme.colors.black,
                        text = stringResource(R.string.sign_in),
                        letterSpacing = fontDimensionResource(R.dimen.font_1sp) ,
                        style = RoadtriipTheme.typography.fontSize14spBLack
                    )
                }


                Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.margin_global_5dp)))
                androidx.compose.material3.TextButton(onClick = {
                    onResetPasswordClicked()

                }) {
                    androidx.compose.material3.Text(
                        color = RoadtriipTheme.colors.black,
                        text = stringResource(R.string.reset_password),
                        letterSpacing = fontDimensionResource(R.dimen.font_1sp),
                        style = RoadtriipTheme.typography.fontSize14spBLack,
                    )
                }
                Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.margin_global_20dp)))

            }


        }

    }


}
//name
@OptIn(ExperimentalComposeUiApi::class , ExperimentalMaterial3Api::class)
@Composable
fun RegisterName(name: String, onNameChange: (String) -> Unit, errorName: Int? = null ) {
    GlobalOutlinedTextField(
        value = name ,
        onValueChange = onNameChange  ,
        label = stringResource(R.string.name) ,
        placeholder = stringResource(
            R.string.name
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text
        ) ,
        singleLine = true,
        errorMessage = errorName?.let {
            stringResource(id = it)
        }
    )
}


//phone
@OptIn(ExperimentalComposeUiApi::class , ExperimentalMaterial3Api::class)
@Composable
fun RegisterPhone(phoneNumber : String , onPhoneChange :(String) -> Unit , errorphone: Int? = null ) {

    GlobalOutlinedTextField(
        value = phoneNumber ,
        onValueChange = onPhoneChange  ,
        label = stringResource(R.string.phone) ,
        placeholder = stringResource(
            R.string.phone
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Phone
        ) ,
        singleLine = true,
        errorMessage = errorphone?.let {
            stringResource(id = it)
        }
    )

}


//email id
@OptIn(ExperimentalComposeUiApi::class , ExperimentalMaterial3Api::class)
@Composable
fun RegisterEmail(email: String, onEmailChange: (String) -> Unit, errorMail: Int? = null ) {
    val keyboardController = LocalSoftwareKeyboardController.current

    GlobalOutlinedTextField(
        value = email ,
        onValueChange = onEmailChange  ,
        label = stringResource(R.string.email_address) ,
        placeholder = stringResource(
            R.string.email_address
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        ) ,
        singleLine = true,
        errorMessage = errorMail?.let {
            stringResource(id = it)
        }
    )
}

//password
@OptIn(ExperimentalComposeUiApi::class , ExperimentalMaterial3Api::class)
@Composable
fun RegisterPassword(password: String , onPasswordChange: (String) -> Unit ,passwordHidden: Boolean , onPasswordHiddenChange: (Boolean) -> Unit, errorPass: Int? = null) {
    GlobalPasswordOutlinedTextField(
        errorPass = errorPass?.let {
            stringResource(id = it)
        },
        value = password ,
        onValueChange = onPasswordChange ,
        label = stringResource(R.string.enter_password) ,
        passwordHidden = passwordHidden,
        onPasswordHiddenChange = onPasswordHiddenChange ,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text
        ) ,
        singleLine = true,

        )
}

//password confirm
@OptIn(ExperimentalComposeUiApi::class , ExperimentalMaterial3Api::class)
@Composable
fun RegisterPasswordConfirm(confirmPassword: String , onConfirmPasswordChange: (String) -> Unit ,passwordHidden: Boolean , onPasswordHiddenChange: (Boolean) -> Unit, errorConfirmPass: Int? = null) {
    GlobalPasswordOutlinedTextField(

        value = confirmPassword ,
        onValueChange = onConfirmPasswordChange ,
        label = stringResource(R.string.confirm_password) ,
        passwordHidden = passwordHidden,
        onPasswordHiddenChange = onPasswordHiddenChange ,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text
        ) ,
        singleLine = true,
        errorPass = errorConfirmPass?.let {
            stringResource(id = it)
        },

        )
}
@Preview
@Composable
fun SignupScreenPreview() {
    SignupScreen(
        modifier = Modifier ,
        name = "name" ,
        phoneNumber = "phoneNumber" ,
        email = "email" ,
        passwordHidden = false,
        password = "password" ,
        confirmPassword = "confirmPassword" ,
        onPasswordChange = {} ,
        onNameChange = {} ,
        onEmailChange = {} ,
        onPhoneChange = {} ,
        onConfirmPasswordChange = {},
        onPasswordHiddenChange = {},
        onSigninClicked = {},
        onRegisterClicked = {},
        onResetPasswordClicked = {},
        errorMail = R.string.empty,
        errorPass = R.string.empty,
        errorName = R.string.empty,
        errorphone = R.string.empty,
        errorConfirmPass=R.string.empty

    )
}
