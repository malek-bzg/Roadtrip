package com.anypli.roadtriip.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
 import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anypli.roadtriip.ui.resetpass.ResetPassScreen
import com.anypli.roadtriip.ui.resetpass.ResetPassViewModel
import com.anypli.roadtriip.ui.signin.SigninScreen
import com.anypli.roadtriip.ui.signin.SigninViewModel
import com.anypli.roadtriip.ui.signup.SignupScreen
import com.anypli.roadtriip.ui.signup.SignupViewModel
import com.anypli.roadtriip.ui.splash.SplashScreen
import com.anypli.roadtriip.ui.splash.SplashViewModel

@Composable
fun AppNavHost(navHostController: NavHostController = rememberNavController()) {

    NavHost(navHostController , startDestination = "signun", modifier = Modifier) {

        composable(route = "splash"){
            SplashScreen(SplashViewModel())
        }
        composable(route = "signin"){
            SigninScreen(SigninViewModel())
        }
        composable(route = "signun"){
            SignupScreen(SignupViewModel())
        }
        composable(route = "reset"){
            ResetPassScreen(ResetPassViewModel())

        }

    }

}