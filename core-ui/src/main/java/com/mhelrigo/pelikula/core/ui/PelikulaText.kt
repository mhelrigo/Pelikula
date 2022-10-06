package com.mhelrigo.pelikula.core.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import com.mhelrigo.pelikula.core.designsystem.font.robotoFamily
import com.mhelrigo.pelikula.core.designsystem.dp
import com.mhelrigo.pelikula.core.designsystem.theme.Orange1

@Composable
fun PelikulaText(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 8.dp(),
    color: Color = Color.Black,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        modifier = modifier,
        fontFamily = robotoFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        color = color,
        textAlign = textAlign
    )
}