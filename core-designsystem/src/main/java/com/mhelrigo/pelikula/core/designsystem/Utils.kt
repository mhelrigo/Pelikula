package com.mhelrigo.pelikula.core.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun Int.dp() = with(LocalDensity.current) {  Dp(this@dp.toFloat()).toSp()  }