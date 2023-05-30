package com.anypli.roadtriip.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
 import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anypli.roadtriip.ui.resetpass.ResetPassScreen
import com.anypli.roadtriip.ui.signin.SigninScreen
import com.anypli.roadtriip.ui.signup.SignupScreen
import com.anypli.roadtriip.ui.splash.SplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.anypli.roadtriip.global.helper.Navigation
import com.anypli.roadtriip.ui.details.DetailsEventsScreen
import com.anypli.roadtriip.ui.event.AddEventsScreen
import com.anypli.roadtriip.ui.event.CameraScreen
import com.anypli.roadtriip.ui.home.HomeScreen
import com.anypli.roadtriip.ui.profile.ModifierProfileScreen
import com.anypli.roadtriip.ui.profile.ProfileScreen
import com.anypli.roadtriip.ui.resetpass.ChangermdpScreen


@Composable
fun AppNavHost(navHostController: NavHostController = rememberNavController()) {
     val navigator : AppNavigator = remember (navHostController){AppNavigatorImpl(navHostController)}

    NavHost(navHostController , startDestination = Navigation.ChangermdpScreen.route, modifier = Modifier) {

        composable(route = Navigation.SplashScreen.route){
            SplashScreen(viewModel(),navigator )
        }
        composable(route = Navigation.SigninScreen.route){
            SigninScreen(viewModel() ,navigator )
        }
        composable(route = Navigation.SignupScreen.route){
            SignupScreen(viewModel(),navigator )
        }
        composable(route = Navigation.ResetPassScreen.route){
            ResetPassScreen(viewModel(),navigator )

        }
        composable(route = Navigation.HomeScreen.route){
            HomeScreen(viewModel(),navigator )
        }

        composable(route = Navigation.DetailsEventsScreen.route){
            DetailsEventsScreen(viewModel(),navigator )
        }
        composable(route = Navigation.AddEventsScreen.route){
            AddEventsScreen(viewModel(),navigator )
        }
        composable(route = Navigation.CameraScreen.route){
            CameraScreen(viewModel(),navigator )
        }

        composable(route = Navigation.ModifierProfileScreen.route){
            ModifierProfileScreen(viewModel(),navigator )
        }

        composable(route = Navigation.ProfileScreen.route){
            ProfileScreen(viewModel(),navigator )
        }
        composable(route = Navigation.ChangermdpScreen.route){
            ChangermdpScreen(viewModel(),navigator )
        }



    }

}

interface AppNavigator{

    fun navigateTo(navigateTo: Navigation)
    fun popBackStack(route: String? = null , inclusive: Boolean = false ): Boolean

}

class AppNavigatorImpl(private val navHostController: NavHostController) : AppNavigator {
    override fun navigateTo(navigateTo: Navigation) {
        navHostController.navigate(navigateTo.route)
    }

    override fun popBackStack(route: String? , inclusive: Boolean): Boolean {

        return if (route ==null ) {
            navHostController.popBackStack()
        }
        else{
            navHostController.popBackStack(route, inclusive)
        }
    }

}