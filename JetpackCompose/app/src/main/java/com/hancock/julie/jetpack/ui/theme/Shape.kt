package com.hancock.julie.jetpack.ui.theme

import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

val curCorners = AbsoluteCutCornerShape(25)
val diamond = AbsoluteCutCornerShape(50)
val roundCorners = AbsoluteRoundedCornerShape(25)
val circle = AbsoluteRoundedCornerShape(50)
val roundCorners2 = AbsoluteRoundedCornerShape(16.dp)
val wonkeyCorners = AbsoluteRoundedCornerShape(topLeft = 0.dp, topRight = 100.dp, bottomLeft = 75.dp, bottomRight = 150.dp)
val normal = AbsoluteCutCornerShape(0)

val shapesForTesting = listOf(
    normal,
    curCorners,
    diamond,
    roundCorners,
    circle,
    roundCorners2,
    wonkeyCorners
)