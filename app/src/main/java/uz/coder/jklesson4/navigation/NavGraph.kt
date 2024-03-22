package uz.coder.jklesson4.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.coder.jklesson4.screens.HomeScreen
import uz.coder.jklesson4.screens.ProfileScreen
import uz.coder.jklesson4.screens.SettingScreen
import uz.coder.jklesson4.sealed.ScreenSealed

@Composable
fun NavGraph(controller: NavHostController) {
    NavHost(controller, startDestination = ScreenSealed.Home.route) {
        composable(ScreenSealed.Home.route) {
            HomeScreen(controller)
        }
        composable(ScreenSealed.Profile.route) {
            ProfileScreen(controller)
        }
        composable(ScreenSealed.Setting.route) {
            SettingScreen(controller)
        }
    }
}