package com.mhelrigo.pelikula.core.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.mhelrigo.pelikula.core.designsystem.theme.Orange1

@Composable
fun StarRating(
    modifier: Modifier = Modifier,
    rating: Float,
    starCount: Int,
    fillColor: Color = Orange1,
    trackColor: Color = White
) {
    Row(modifier = modifier) {
        for (i in 1..starCount) {
            Icon(
                Icons.Default.Star,
                "rating",
                tint = if (i <= rating.toInt()) fillColor else trackColor,
                modifier = Modifier
                    .size(16.dp)
            )
        }
    }
}