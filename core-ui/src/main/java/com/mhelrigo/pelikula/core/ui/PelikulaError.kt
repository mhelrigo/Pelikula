package com.mhelrigo.pelikula.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.mhelrigo.pelikula.core.designsystem.dp

@Composable
fun PelikulaError(modifier: Modifier = Modifier, message: String) {
    PelikulaText(
        text = message,
        modifier = modifier,
        fontSize = 16.dp(),
        fontWeight = FontWeight.Light,
    )
}
