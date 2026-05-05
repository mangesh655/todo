package com.mangesh.movieloading.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TodoItem(
    title: String,
    isCompleted: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.body1,
            color = if (isCompleted) Color.Gray else Color.Black,
            textDecoration = if (isCompleted) TextDecoration.LineThrough else TextDecoration.None
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TodoItemPreview() {
    Row {
        TodoItem(
            title = "Buy groceries",
            isCompleted = false,
            modifier = Modifier.weight(1f)
        )
    }
}