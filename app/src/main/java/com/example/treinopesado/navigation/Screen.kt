package com.example.treinopesado.navigation

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object NewTrainScreen : Screen("new_train_screen")
    object StartTrainScreen : Screen("start_train_screen")

    fun withArgrs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/${arg}")
            }
        }
    }
}
