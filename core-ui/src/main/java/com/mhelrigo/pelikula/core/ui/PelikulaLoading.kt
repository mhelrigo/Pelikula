package com.mhelrigo.pelikula.core.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PelikulaLoading(
    modifier: Modifier = Modifier,
    activeColor: Color = Color.Gray,
    shapeCount: Int = 3,
    shape: Shape = CircleShape,
    size: Dp = 8.dp,
    spaceBetween: Dp = 4.dp
) {
    Row(modifier = modifier) {
        for (i in 0 until shapeCount) {
            AnimatedShapeObject(
                shape = shape,
                size = size,
                scale = 1F,
                backgroundColor = activeColor,
                delay = 200 * i,
                duration = 200
            )
            Spacer(modifier = Modifier.size(spaceBetween))
        }
    }
}

@Composable
fun AnimatedShapeObject(
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    size: Dp = 0.dp,
    scale: Float = 0F,
    backgroundColor: Color = Color.Gray,
    delay: Int = 0,
    duration: Int = 0
) {
    val transition by rememberInfiniteTransition().animateFloat(
        initialValue = 0F,
        targetValue = 0F,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = duration * 4
                0F at delay with FastOutSlowInEasing
                scale at delay + duration with FastOutSlowInEasing
                0F at delay + duration * 2
            }
        )
    )

    ShapeObject(shape = shape, size = size, scale = transition, backgroundColor = backgroundColor)
}

@Composable
private fun ShapeObject(
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    size: Dp = 8.dp,
    scale: Float = 0F,
    backgroundColor: Color = Color.Gray,
) {
    Box(
        modifier = modifier
            .clip(shape)
            .size(size)
            .scale(scale)
            .background(backgroundColor)
    )
}