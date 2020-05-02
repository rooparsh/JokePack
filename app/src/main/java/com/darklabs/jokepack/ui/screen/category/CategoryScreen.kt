package com.darklabs.jokepack.ui.screen.category

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.drawOpacity
import androidx.ui.foundation.*
import androidx.ui.graphics.Color
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.Row
import androidx.ui.layout.padding
import androidx.ui.material.*
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.darklabs.jokepack.data.observe
import com.darklabs.jokepack.ui.state.Screen
import com.darklabs.jokepack.ui.state.navigateTo

@Composable
fun CategoryScreen(viewModel: CategoryViewModel) {
    Scaffold(
        topAppBar = { TopAppBar() },
        bottomAppBar = { BottomAppBar() },
        bodyContent = { modifier -> Content(modifier, list = observe(viewModel.jokeCategories)) }
    )
}

@Composable
fun Content(modifier: Modifier, list: List<String>?) {

    Column(modifier = modifier.padding(start = 20.dp, end = 20.dp)) {
        Text(text = "Categories")
        list?.let {
            AdapterList(data = it) { category ->
                Clickable(onClick = { onCategoryClick(category) }) {
                    ListItemWithDivider(category = category)
                }
            }
        }
    }

}

private fun onCategoryClick(category: String) {
    navigateTo(Screen.Joke(category = category))
}

@Composable
fun TopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "JokePack",
                style = MaterialTheme.typography.h6.copy(
                    color = MaterialTheme.colors.onPrimary
                )
            )
        },
        backgroundColor = MaterialTheme.colors.primary
    )
}

@Composable
fun BottomAppBar() {
    BottomAppBar {
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "Hello")
            Text(text = "Bye")
        }
    }
}

@Composable
fun ListItemWithDivider(category: String) {
    Column {
        Text(
            text = category.capitalize(),
            modifier = Modifier.padding(top = 8.dp, end = 8.dp),
            style = TextStyle(fontSize = 24.sp),
            color = MaterialTheme.colors.onSurface,
            maxLines = 1
        )
    }
    LineDivider()
}

@Composable
private fun LineDivider() {
    Divider(
        modifier = Modifier.drawOpacity(0.12f),
        color = if (isSystemInDarkTheme()) {
            Color.White
        } else {
            Color.Black
        }
    )
}