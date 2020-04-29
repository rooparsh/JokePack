package com.darklabs.jokepack.ui.screen.category

import androidx.compose.Composable
import androidx.compose.remember
import androidx.ui.core.Modifier
import androidx.ui.core.drawOpacity
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Text
import androidx.ui.foundation.isSystemInDarkTheme
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.padding
import androidx.ui.material.*
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.darklabs.jokepack.data.observe

@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel,
    scaffoldState: ScaffoldState = remember { ScaffoldState() }
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topAppBar = { TopAppBar() },
        bottomAppBar = { BottomAppBar() }
    ) {
        Content(list = observe(viewModel.jokeCategories))
    }
}

@Composable
fun Content(list: List<String>?) {
    list?.let {
        AdapterList(data = it) { category ->
            ListItemWithDivider(category = category)
        }
    }
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
    BottomAppBar() {

    }
}

@Composable
fun ListItemWithDivider(category: String) {
    Column {
        Text(
            text = category,
            modifier = Modifier.padding(top = 8.dp, end = 8.dp),
            style = TextStyle(fontSize = 24.sp),
            color = MaterialTheme.colors.onSurface,
            maxLines = 1
        )
        LineDivider()
    }
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