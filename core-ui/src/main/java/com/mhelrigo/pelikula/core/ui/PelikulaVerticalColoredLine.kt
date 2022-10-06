package com.mhelrigo.pelikula.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mhelrigo.pelikula.core.designsystem.theme.Orange1

@Composable
fun VerticalColoredLine(modifier: Modifier = Modifier, color: Color = Orange1) {
    Spacer(modifier = modifier
        .width(24.dp)
        .height(1.dp)
        .background(color = color))
}