package com.example.treinopesado.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.treinopesado.screen.home.HomeScreen
import com.example.treinopesado.screen.home.HomeViewModel
import com.example.treinopesado.screen.newTrain.NewTrain
import com.example.treinopesado.screen.startTrain.StartTrain

@Composable
fun NavGraphMenu(navController: NavHostController, viewModel: HomeViewModel) {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {

        composable(Screen.HomeScreen.route) {
            HomeScreen(navController, viewModel)
        }

        composable(Screen.NewTrainScreen.route) {
            NewTrain(navController = navController, viewModel)
        }

        composable(route = Screen.StartTrainScreen.route + "/{id}", arguments = listOf(
            navArgument("id") {
                type = NavType.StringType
            }
        )) { entry ->
            StartTrain(id = entry.arguments?.getString("id"), navController = navController, viewModel)
        }
    }
}