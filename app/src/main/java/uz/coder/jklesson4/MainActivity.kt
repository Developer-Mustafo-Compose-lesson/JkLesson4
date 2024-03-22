package uz.coder.jklesson4

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uz.coder.jklesson4.model.BottomItem
import uz.coder.jklesson4.navigation.NavGraph
import uz.coder.jklesson4.sealed.ScreenSealed
import uz.coder.jklesson4.ui.theme.JkLesson4Theme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val controller = rememberNavController()
            JkLesson4Theme {
                Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
                    NavigationBar {
                        bars.forEachIndexed { index, item ->
                            MaterialTheme {
                                NavigationBarItem(selected = selectedItem.intValue == index, onClick = { selectedItem.intValue = index}, icon = { val icon = when(selectedItem.intValue == index){ true -> item.selectedIcon; false -> item.unselectedIcon }; Column(modifier = Modifier,horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){ Icon(icon, item.title,modifier = Modifier.align(Alignment.CenterHorizontally)); Text(if(selectedItem.intValue == index) item.title else "") } })
                            }
                        }
                    }
                }) { innerPadding ->
                    Greeting(
                        paddingValues = innerPadding,
                        controller = controller
                    )
                }
            }
        }

    }
}
private val selectedItem = mutableIntStateOf(0)
private val bars = listOf(
    BottomItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    ),
    BottomItem(
        title = "Profile",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person
    ),
    BottomItem(
        title = "Settings",
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings
    )
)
@Composable
fun Greeting(paddingValues: PaddingValues,controller: NavHostController) {
    val context = LocalContext.current
    Column(modifier = Modifier.padding(paddingValues)) {
        NavGraph(controller)
        when(selectedItem.intValue){
            0 -> {
                controller.navigate(ScreenSealed.Home.route)
            }
            1 -> {
                controller.navigate(ScreenSealed.Profile.route)
            }
            2 -> {
                controller.navigate(ScreenSealed.Setting.route)
            }
            else -> {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}