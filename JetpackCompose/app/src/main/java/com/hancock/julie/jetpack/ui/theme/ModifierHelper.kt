package com.hancock.julie.jetpack.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

fun getModifier(
    size: Dp? = null,
    padding: Dp? = null,
    clipShape: Shape? = null,
    backgroundColor: Color? = null,
    width: Dp? = null,
    height: Dp? = null,
    percentWidthFill: Float? = null,
    percentHeightFill: Float? = null,
    opacity: Float? = null,
    rotate: Float? = null,
    border: Triple<Dp, Color, Shape>? = null,
): Modifier {
    val list: List<Modifier> = listOfNotNull(
        size?.let { Modifier.size(it) },
        padding?.let { Modifier.padding(it) },
        clipShape?.let { Modifier.clip(it) },
        backgroundColor?.let { Modifier.background(it) },
        width?.let { Modifier.width(it) },
        height?.let { Modifier.height(it) },
        percentWidthFill?.let { Modifier.fillMaxWidth(it) },
        percentHeightFill?.let { Modifier.fillMaxHeight(it) },
        opacity?.let { Modifier.alpha(it) },
        rotate?.let { Modifier.rotate(it) },
        border?.let { Modifier.border(it.first, it.second, it.third) },
    )

    return if (list.isEmpty()) Modifier
    else list.reduceRight { a, b -> a.then(b) }
}

