package uz.coder.jklesson4.model

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)