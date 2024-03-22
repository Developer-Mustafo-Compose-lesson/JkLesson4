package uz.coder.jklesson4.sealed

sealed class ScreenSealed(val route:String) {
    data object Home : ScreenSealed(HOME)
    data object Profile:ScreenSealed(PROFILE)
    data object Setting:ScreenSealed(SETTING)
    companion object{
        private const val HOME = "home"
        private const val PROFILE = "profile"
        private const val SETTING = "setting"
    }
}