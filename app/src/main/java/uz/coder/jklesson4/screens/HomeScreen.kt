package uz.coder.jklesson4.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import uz.coder.jklesson4.R

@Composable
fun HomeScreen(controller: NavHostController) {
    Column {
        LazyColumn {
            itemsIndexed(listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10", "Item 11", "Item 12", "Item 13", "Item 14", "Item 15", "Item 16", "Item 17", "Item 18", "Item 19", "Item 20")) { index, item ->
                Card(colors = CardDefaults.cardColors(colorResource(id = R.color.purple_500)), modifier = Modifier.fillMaxWidth().padding(15.dp).height(80.dp)) {
                    Text(text = item)

                }
            }
        }
    }
}